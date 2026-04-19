package net.mcreator.immersionintrafficcontext.block;

import net.minecraft.world.level.redstone.Orientation;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.immersionintrafficcontext.procedures.LiquidBitumenShengWuWanJiaPengZhuangGaiFangKuaiShiProcedure;
import net.mcreator.immersionintrafficcontext.procedures.LiquidBitumenPiLinFangKuaiGengXinShiProcedure;
import net.mcreator.immersionintrafficcontext.init.ImmersionInTrafficContextModFluids;

import javax.annotation.Nullable;

public class LiquidBitumenBlock extends LiquidBlock {
	public LiquidBitumenBlock(BlockBehaviour.Properties properties) {
		super(ImmersionInTrafficContextModFluids.LIQUID_BITUMEN.get(), properties.mapColor(MapColor.COLOR_BLACK).strength(101f).noCollission().noLootTable().liquid().pushReaction(PushReaction.DESTROY).sound(SoundType.EMPTY).replaceable());
	}

	@Override
	public void neighborChanged(BlockState blockstate, Level world, BlockPos pos, Block neighborBlock, @Nullable Orientation orientation, boolean moving) {
		super.neighborChanged(blockstate, world, pos, neighborBlock, orientation, moving);
		LiquidBitumenPiLinFangKuaiGengXinShiProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}

	@Override
	public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
		super.entityInside(blockstate, world, pos, entity);
		LiquidBitumenShengWuWanJiaPengZhuangGaiFangKuaiShiProcedure.execute(entity);
	}
}