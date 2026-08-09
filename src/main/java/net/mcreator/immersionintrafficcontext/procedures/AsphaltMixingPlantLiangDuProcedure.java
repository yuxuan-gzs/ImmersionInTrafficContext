package net.mcreator.immersionintrafficcontext.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.immersionintrafficcontext.block.AsphaltMixingPlantBlock;

public class AsphaltMixingPlantLiangDuProcedure {
	public static double execute(LevelAccessor world, double x, double y, double z) {
		BlockPos pos = BlockPos.containing(x, y, z);
		BlockState blockstate = world.getBlockState(pos);
		
		// 直接从 BlockState 读取 LIGHT_ON 属性
		if (blockstate.getBlock() instanceof AsphaltMixingPlantBlock) {
			return blockstate.getValue(AsphaltMixingPlantBlock.LIGHT_ON) ? 15 : 0;
		}
		
		return 0;
	}
}