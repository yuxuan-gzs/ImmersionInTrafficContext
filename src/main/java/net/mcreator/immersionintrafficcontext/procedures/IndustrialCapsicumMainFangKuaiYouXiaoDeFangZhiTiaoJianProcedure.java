package net.mcreator.immersionintrafficcontext.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class IndustrialCapsicumMainFangKuaiYouXiaoDeFangZhiTiaoJianProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x, y - 0, z))).getBlock() == Blocks.GRASS_BLOCK) {
			return true;
		}
		return false;
	}
}