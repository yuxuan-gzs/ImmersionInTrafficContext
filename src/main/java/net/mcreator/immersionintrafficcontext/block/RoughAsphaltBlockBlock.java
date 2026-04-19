package net.mcreator.immersionintrafficcontext.block;

import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.*;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.core.Direction;

import com.mojang.serialization.MapCodec;

public class RoughAsphaltBlockBlock extends FallingBlock {
	public static final EnumProperty<Direction> FACING = HorizontalDirectionalBlock.FACING;
	public static final MapCodec<RoughAsphaltBlockBlock> CODEC = simpleCodec(RoughAsphaltBlockBlock::new);

	public MapCodec<RoughAsphaltBlockBlock> codec() {
		return CODEC;
	}

	public RoughAsphaltBlockBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.SAND).strength(2f, 9f).requiresCorrectToolForDrops().friction(0.58f).speedFactor(0.8f).jumpFactor(0.8f));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 15;
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(FACING);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return super.getStateForPlacement(context).setValue(FACING, context.getHorizontalDirection().getOpposite());
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}
}