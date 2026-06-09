package com.teamabode.verdance.core.integration.farmersdelight;

import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.core.Vec3i;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.ContainerUser;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.ContainerOpenersCounter;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

public class MulberryCabinetBlockEntity extends RandomizableContainerBlockEntity {
    private NonNullList<ItemStack> contents = NonNullList.withSize(27, ItemStack.EMPTY);
    private final ContainerOpenersCounter openersCounter = new ContainerOpenersCounter() {
        @Override
        protected void onOpen(Level level, BlockPos pos, BlockState state) {
            MulberryCabinetBlockEntity.this.playSound(state, "block.cabinet.open");
            MulberryCabinetBlockEntity.this.updateBlockState(state, true);
        }

        @Override
        protected void onClose(Level level, BlockPos pos, BlockState state) {
            MulberryCabinetBlockEntity.this.playSound(state, "block.cabinet.close");
            MulberryCabinetBlockEntity.this.updateBlockState(state, false);
        }

        @Override
        protected void openerCountChanged(Level level, BlockPos pos, BlockState state, int previous, int current) {
        }

        @Override
        public boolean isOwnContainer(Player player) {
            if (player.containerMenu instanceof ChestMenu menu) {
                Container container = menu.getContainer();
                return container == MulberryCabinetBlockEntity.this;
            }
            return false;
        }
    };

    public MulberryCabinetBlockEntity(BlockPos pos, BlockState state) {
        super(FDCompat.CABINET_BLOCK_ENTITY, pos, state);
    }

    @Override
    protected void loadAdditional(ValueInput input) {
        super.loadAdditional(input);
        this.contents = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        if (!this.tryLoadLootTable(input)) {
            ContainerHelper.loadAllItems(input, this.contents);
        }
    }

    @Override
    protected void saveAdditional(ValueOutput output) {
        super.saveAdditional(output);
        if (!this.trySaveLootTable(output)) {
            ContainerHelper.saveAllItems(output, this.contents);
        }
    }

    @Override
    public int getContainerSize() {
        return 27;
    }

    @Override
    protected NonNullList<ItemStack> getItems() {
        return this.contents;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> items) {
        this.contents = items;
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable("container.verdance.mulberry_cabinet");
    }

    @Override
    protected AbstractContainerMenu createMenu(int id, Inventory inventory) {
        return ChestMenu.threeRows(id, inventory, this);
    }

    @Override
    public void startOpen(ContainerUser user) {
        if (!this.remove && !user.getLivingEntity().isSpectator()) {
            this.openersCounter.incrementOpeners(user.getLivingEntity(), this.getLevel(), this.getBlockPos(), this.getBlockState(), user.getContainerInteractionRange());
        }
    }

    @Override
    public void stopOpen(ContainerUser user) {
        if (!this.remove && !user.getLivingEntity().isSpectator()) {
            this.openersCounter.decrementOpeners(user.getLivingEntity(), this.getLevel(), this.getBlockPos(), this.getBlockState());
        }
    }

    public void recheckOpen() {
        if (this.level != null && !this.remove) {
            this.openersCounter.recheckOpeners(this.level, this.getBlockPos(), this.getBlockState());
        }
    }

    void updateBlockState(BlockState state, boolean open) {
        if (this.level != null) {
            this.level.setBlock(this.getBlockPos(), state.setValue(MulberryCabinetBlock.OPEN, open), 3);
        }
    }

    private void playSound(BlockState state, String soundPath) {
        if (this.level == null) {
            return;
        }
        SoundEvent sound = BuiltInRegistries.SOUND_EVENT.getValue(Identifier.fromNamespaceAndPath("farmersdelight", soundPath));
        if (sound == null) {
            return;
        }
        Vec3i facing = state.getValue(MulberryCabinetBlock.FACING).getUnitVec3i();
        double x = this.worldPosition.getX() + 0.5 + facing.getX() / 2.0;
        double y = this.worldPosition.getY() + 0.5 + facing.getY() / 2.0;
        double z = this.worldPosition.getZ() + 0.5 + facing.getZ() / 2.0;
        this.level.playSound(null, x, y, z, sound, SoundSource.BLOCKS, 0.5f, this.level.getRandom().nextFloat() * 0.1f + 0.9f);
    }
}
