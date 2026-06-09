package com.teamabode.verdance.core.level;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.Mth;
import net.minecraft.world.level.biome.Biome;

import java.util.ArrayList;
import java.util.List;

public final class VerdanceBiomeReplacements {
    private static final int REPLACEMENT_SCALE = 4;
    private static final double[] SCALE = {
            256.0 * REPLACEMENT_SCALE,
            64.0 * REPLACEMENT_SCALE,
            16.0 * REPLACEMENT_SCALE,
            4.0 * REPLACEMENT_SCALE
    };

    private static final List<Entry> ENTRIES = new ArrayList<>();

    private static volatile List<Active> active = List.of();
    private static volatile OpenSimplexNoise2 noise;
    private static volatile int[] seedlets = new int[8];

    private VerdanceBiomeReplacements() {
    }

    public static void register(ResourceKey<Biome> target, ResourceKey<Biome> replacement, double proportion) {
        ENTRIES.add(new Entry(target, replacement, Mth.clamp(proportion, 0.0, 1.0)));
    }

    public static void bind(MinecraftServer server) {
        long seed = server.getWorldGenSettings().options().seed();
        OpenSimplexNoise2 replacementNoise = new OpenSimplexNoise2(seed);
        int[] offsets = new int[8];
        for (int i = 0; i < offsets.length; i++) {
            offsets[i] = (int) (seed >> (i * 8) & 0xffL);
        }
        Registry<Biome> biomes = server.registryAccess().lookupOrThrow(Registries.BIOME);
        List<Active> built = new ArrayList<>(ENTRIES.size());
        for (Entry entry : ENTRIES) {
            Holder<Biome> holder = biomes.getOrThrow(entry.replacement());
            built.add(new Active(entry.target(), holder, entry.proportion(), highBand(seed, entry.target())));
        }
        noise = replacementNoise;
        seedlets = offsets;
        active = List.copyOf(built);
    }

    public static Holder<Biome> replace(Holder<Biome> original, int quartX, int quartZ) {
        List<Active> current = active;
        if (current.isEmpty()) {
            return original;
        }
        double localNoise = -1.0;
        for (int i = 0; i < current.size(); i++) {
            Active entry = current.get(i);
            if (original.is(entry.target())) {
                if (localNoise < 0.0) {
                    localNoise = localNoise(quartX, quartZ);
                }
                boolean replaced = entry.high()
                        ? localNoise > 1.0 - entry.proportion()
                        : localNoise < entry.proportion();
                if (replaced) {
                    return entry.holder();
                }
            }
        }
        return original;
    }

    public static List<Holder<Biome>> additionsFor(List<Holder<Biome>> base) {
        List<Holder<Biome>> additions = new ArrayList<>();
        for (Active entry : active) {
            Holder<Biome> replacement = entry.holder();
            if (containsKey(base, entry.target()) && !contains(base, replacement) && !contains(additions, replacement)) {
                additions.add(replacement);
            }
        }
        return additions;
    }

    private static boolean containsKey(List<Holder<Biome>> holders, ResourceKey<Biome> key) {
        for (int i = 0; i < holders.size(); i++) {
            if (holders.get(i).is(key)) {
                return true;
            }
        }
        return false;
    }

    private static boolean contains(List<Holder<Biome>> holders, Holder<Biome> holder) {
        for (int i = 0; i < holders.size(); i++) {
            if (holders.get(i) == holder || holders.get(i).is(holder)) {
                return true;
            }
        }
        return false;
    }

    private static double localNoise(int x, int z) {
        OpenSimplexNoise2 sampler = noise;
        int[] offsets = seedlets;
        double value = sampler.sample((x + offsets[0]) / SCALE[0], (z + offsets[1]) / SCALE[0]);
        value += sampler.sample((x + offsets[2]) / SCALE[1], (z + offsets[3]) / SCALE[1]) / 8.0;
        value += sampler.sample((x + offsets[4]) / SCALE[2], (z + offsets[5]) / SCALE[2]) / 16.0;
        value += sampler.sample((x + offsets[6]) / SCALE[3], (z + offsets[7]) / SCALE[3]) / 32.0;
        return normalize(value / 1.21875);
    }

    private static double normalize(double value) {
        return Mth.clamp(value * 0.5375 + 0.5, 0.0, 1.0 - Double.MIN_NORMAL);
    }

    private static boolean highBand(long seed, ResourceKey<Biome> target) {
        long value = seed * 0x9E3779B97F4A7C15L + target.identifier().toString().hashCode();
        value ^= value >>> 32;
        value *= 0xBF58476D1CE4E5B9L;
        return (value >>> 63) != 0L;
    }

    private record Entry(ResourceKey<Biome> target, ResourceKey<Biome> replacement, double proportion) {
    }

    private record Active(ResourceKey<Biome> target, Holder<Biome> holder, double proportion, boolean high) {
    }
}
