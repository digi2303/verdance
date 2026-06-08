package com.teamabode.verdance;

import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import dev.yumi.mc.core.api.YumiMods;
import net.minecraft.util.Mth;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class VerdanceConfig {
    private static final Path CONFIG_PATH = YumiMods.get().getConfigDirectory().resolve("verdance.json");
    public static VerdanceConfig instance = new VerdanceConfig();

    @SerializedName("can_bonemeal_sugar_cane")
    public boolean canBonemealSugarCane = true;
    @SerializedName("can_bonemeal_spore_blossom")
    public boolean canBonemealSporeBlossom = true;
    @SerializedName("mulberry_forest_proportion")
    public double mulberryForestProportion = 0.25d;
    @SerializedName("shrublands_proportion")
    public double shrublandsProportion = 0.35d;

    public static void load() {
        try {
            if (Files.exists(CONFIG_PATH)) {
                var gson = new GsonBuilder().disableHtmlEscaping().create();
                var config = gson.fromJson(Files.readString(CONFIG_PATH), VerdanceConfig.class);
                if (config != null) {
                    config.mulberryForestProportion = Mth.clamp(config.mulberryForestProportion, 0.0d, 1.0d);
                    config.shrublandsProportion = Mth.clamp(config.shrublandsProportion, 0.0d, 1.0d);
                    instance = config;
                }
            }
            save();
        } catch (Throwable e) {
            Verdance.LOGGER.warn("Failed to load Verdance config!", e);
        }
    }

    public static void save() {
        try {
            var gson = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();
            Files.writeString(CONFIG_PATH, gson.toJson(instance), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (Throwable e) {
            Verdance.LOGGER.warn("Failed to save Verdance config!", e);
        }
    }
}
