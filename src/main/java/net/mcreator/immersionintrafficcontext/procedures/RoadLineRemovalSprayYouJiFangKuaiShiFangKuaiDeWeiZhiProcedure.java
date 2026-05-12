package net.mcreator.immersionintrafficcontext.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.immersionintrafficcontext.init.ImmersionInTrafficContextModBlocks;

public class RoadLineRemovalSprayYouJiFangKuaiShiFangKuaiDeWeiZhiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, ItemStack itemstack) {
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == ImmersionInTrafficContextModBlocks.WHITE_ZEBRA_CROSSING.get()
				|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == ImmersionInTrafficContextModBlocks.JUNCTION_1.get()
				|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == ImmersionInTrafficContextModBlocks.JUNCTION_3.get()
				|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == ImmersionInTrafficContextModBlocks.JUNCTION_2.get()
				|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == ImmersionInTrafficContextModBlocks.STRAIGHT_AHEAD_AND_RIGHT_TURN_ASPHALT_PAVEMENT_BLOCK.get()
				|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == ImmersionInTrafficContextModBlocks.U_TURN_ASPHALT_PAVEMENT_BLOCK.get()
				|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == ImmersionInTrafficContextModBlocks.DUAL_YELLOW_ZEBRA_CROSSING.get()
				|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == ImmersionInTrafficContextModBlocks.ASPHALT_ROAD_BLOCK_ILLUMINATION_LIGHT.get()
				|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == ImmersionInTrafficContextModBlocks.LEFT_TURN_ASPHALT_PAVEMENT_BLOCK.get()
				|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == ImmersionInTrafficContextModBlocks.YELLOW_ZEBRA_CROSSING.get()
				|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == ImmersionInTrafficContextModBlocks.STRAIGHT_AHEAD_ASPHALT_PAVEMENT_BLOCK.get()
				|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == ImmersionInTrafficContextModBlocks.RIGHT_TURN_ASPHALT_PAVEMENT_BLOCK.get()
				|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == ImmersionInTrafficContextModBlocks.ASPHALT_PAVEMENT_BLOCKS_FOR_LEFT_AND_RIGHT_TURNS.get()
				|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == ImmersionInTrafficContextModBlocks.STRAIGHT_AHEAD_AND_LEFT_TURN_ASPHALT_PAVEMENT_BLOCK.get()) {
			{
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockState _bs = ImmersionInTrafficContextModBlocks.ASPHALT_ROAD_BLOCK.get().defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Property<?> _propertyOld : _bso.getProperties()) {
					Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
					if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
						try {
							_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
			if (world instanceof ServerLevel _level) {
				itemstack.hurtAndBreak(5, _level, null, _stkprov -> {
				});
			}
		}
	}
}