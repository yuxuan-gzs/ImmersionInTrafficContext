package net.mcreator.immersionintrafficcontext.block;

import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.*;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.core.Direction;

import com.mojang.serialization.MapCodec;

public class RoughAsphaltBlockBlock extends FallingBlock {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public static final MapCodec<RoughAsphaltBlockBlock> CODEC = simpleCodec(properties -> new RoughAsphaltBlockBlock());

	public MapCodec<RoughAsphaltBlockBlock> codec() {
		return CODEC;
	}

	public RoughAsphaltBlockBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.SAND).strength(2f, 9f).requiresCorrectToolForDrops().friction(0.58f).speedFactor(0.8f).jumpFactor(0.8f));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(FACING);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		BlockState state = super.getStateForPlacement(context);
		if (state == null)
			return null;
		return state.setValue(FACING, context.getHorizontalDirection().getOpposite());
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}
}