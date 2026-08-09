package net.mcreator.immersionintrafficcontext.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.immersionintrafficcontext.init.ImmersionInTrafficContextModBlocks;

public class Scallion1GuFenChengGongShiYongShiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
		world.setBlock(BlockPos.containing(x, y, z), ImmersionInTrafficContextModBlocks.SCALLION_2.get().defaultBlockState(), 3);
	}
}