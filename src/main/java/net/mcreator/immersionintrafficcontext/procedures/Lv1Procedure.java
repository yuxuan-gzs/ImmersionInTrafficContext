package net.mcreator.immersionintrafficcontext.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.immersionintrafficcontext.init.ImmersionInTrafficContextModMenus;

import java.util.Calendar;

public class Lv1Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Select") == 5) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("_lv", new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert((entity instanceof Player _entity1 && _entity1.containerMenu instanceof ImmersionInTrafficContextModMenus.MenuAccessor _menu1) ? _menu1.getMenuState(0, "lv", "") : ""));
					_blockEntity.getPersistentData().putString("lv1", ((entity instanceof Player _entity3 && _entity3.containerMenu instanceof ImmersionInTrafficContextModMenus.MenuAccessor _menu3) ? _menu3.getMenuState(0, "lv", "") : ""));
					_blockEntity.getPersistentData().putDouble("_red", new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert((entity instanceof Player _entity5 && _entity5.containerMenu instanceof ImmersionInTrafficContextModMenus.MenuAccessor _menu5) ? _menu5.getMenuState(0, "red", "") : ""));
					_blockEntity.getPersistentData().putString("red1", ((entity instanceof Player _entity7 && _entity7.containerMenu instanceof ImmersionInTrafficContextModMenus.MenuAccessor _menu7) ? _menu7.getMenuState(0, "red", "") : ""));
					_blockEntity.getPersistentData().putDouble("_yell", new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert((entity instanceof Player _entity9 && _entity9.containerMenu instanceof ImmersionInTrafficContextModMenus.MenuAccessor _menu9) ? _menu9.getMenuState(0, "yell", "") : ""));
					_blockEntity.getPersistentData().putString("yell1", ((entity instanceof Player _entity11 && _entity11.containerMenu instanceof ImmersionInTrafficContextModMenus.MenuAccessor _menu11) ? _menu11.getMenuState(0, "yell", "") : ""));
					_blockEntity.getPersistentData().putDouble("time_lv", Calendar.getInstance().get(Calendar.SECOND));
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}
}