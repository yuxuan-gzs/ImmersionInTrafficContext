package net.mcreator.immersionintrafficcontext.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;

import net.mcreator.immersionintrafficcontext.init.ImmersionInTrafficContextModBlocks;

public class SpringOnionSeedsYouJiFangKuaiShiFangKuaiDeWeiZhiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, ItemStack itemstack) {
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.FARMLAND) {
			itemstack.shrink(1);
			world.setBlock(BlockPos.containing(x, y + 1, z), ImmersionInTrafficContextModBlocks.SCALLION_1.get().defaultBlockState(), 3);
		}
	}
}