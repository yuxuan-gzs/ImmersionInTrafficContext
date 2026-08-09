package net.mcreator.immersionintrafficcontext.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.immersionintrafficcontext.world.inventory.TrafficLightMenu;
import net.mcreator.immersionintrafficcontext.init.ImmersionInTrafficContextModMenus;
import net.mcreator.immersionintrafficcontext.init.ImmersionInTrafficContextModItems;

import io.netty.buffer.Unpooled;

public class TrafficLightsShuBiaoYouJianDanJiFangKuaiShiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ImmersionInTrafficContextModItems.HAMMER.get()) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				_ent.openMenu(new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("TrafficLight");
					}

					@Override
					public boolean shouldTriggerClientSideContainerClosingOnOpen() {
						return false;
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new TrafficLightMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof ImmersionInTrafficContextModMenus.MenuAccessor _menu)
				_menu.sendMenuStateUpdate(_player, 0, "lv", (getBlockNBTString(world, BlockPos.containing(x, y, z), "lv1")), true);
			if (entity instanceof Player _player && _player.containerMenu instanceof ImmersionInTrafficContextModMenus.MenuAccessor _menu)
				_menu.sendMenuStateUpdate(_player, 0, "red", (getBlockNBTString(world, BlockPos.containing(x, y, z), "red1")), true);
			if (entity instanceof Player _player && _player.containerMenu instanceof ImmersionInTrafficContextModMenus.MenuAccessor _menu)
				_menu.sendMenuStateUpdate(_player, 0, "yell", (getBlockNBTString(world, BlockPos.containing(x, y, z), "yell1")), true);
		}
	}

	private static String getBlockNBTString(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getString(tag);
		return "";
	}
}