package net.mcreator.immersionintrafficcontext.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.immersionintrafficcontext.init.ImmersionInTrafficContextModMenus;

public class TrafficLightDangGaiGUIDaKaiShiMeiKeFaShengProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && _player.containerMenu instanceof ImmersionInTrafficContextModMenus.MenuAccessor _menu)
			_menu.sendMenuStateUpdate(_player, 0, "lv", (getBlockNBTString(world, BlockPos.containing(x, y, z), "lv1")), true);
		if (entity instanceof Player _player && _player.containerMenu instanceof ImmersionInTrafficContextModMenus.MenuAccessor _menu)
			_menu.sendMenuStateUpdate(_player, 0, "red", (getBlockNBTString(world, BlockPos.containing(x, y, z), "red1")), true);
		if (entity instanceof Player _player && _player.containerMenu instanceof ImmersionInTrafficContextModMenus.MenuAccessor _menu)
			_menu.sendMenuStateUpdate(_player, 0, "yell", (getBlockNBTString(world, BlockPos.containing(x, y, z), "yell1")), true);
	}

	private static String getBlockNBTString(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getString(tag);
		return "";
	}
}