package net.mcreator.immersionintrafficcontext.block;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class WhiteConcreteStonePillarBlock extends Block implements SimpleWaterloggedBlock {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public static final EnumProperty<AttachFace> FACE = FaceAttachedHorizontalDirectionalBlock.FACE;
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

	public WhiteConcreteStonePillarBlock() {
		super(BlockBehaviour.Properties.of().strength(1f, 10f).requiresCorrectToolForDrops().noOcclusion().isRedstoneConductor((bs, br, bp) -> false).instrument(NoteBlockInstrument.BASS));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(FACE, AttachFace.WALL).setValue(WATERLOGGED, false));
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return state.getFluidState().isEmpty();
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}

	@Override
	public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return Shapes.empty();
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return switch (state.getValue(FACING)) {
			default -> switch (state.getValue(FACE)) {
				case FLOOR -> Shapes.or(box(1, 0, 5, 15, 16, 11), box(1, 0, 5, 15, 16, 11), box(5, 0, 1, 11, 16, 15), box(5, 0, 1, 11, 16, 15));
				case WALL -> Shapes.or(box(1, 5, 0, 15, 11, 16), box(1, 5, 0, 15, 11, 16), box(5, 1, 0, 11, 15, 16), box(5, 1, 0, 11, 15, 16));
				case CEILING -> Shapes.or(box(1, 0, 5, 15, 16, 11), box(1, 0, 5, 15, 16, 11), box(5, 0, 1, 11, 16, 15), box(5, 0, 1, 11, 16, 15));
			};
			case NORTH -> switch (state.getValue(FACE)) {
				case FLOOR -> Shapes.or(box(1, 0, 5, 15, 16, 11), box(1, 0, 5, 15, 16, 11), box(5, 0, 1, 11, 16, 15), box(5, 0, 1, 11, 16, 15));
				case WALL -> Shapes.or(box(1, 5, 0, 15, 11, 16), box(1, 5, 0, 15, 11, 16), box(5, 1, 0, 11, 15, 16), box(5, 1, 0, 11, 15, 16));
				case CEILING -> Shapes.or(box(1, 0, 5, 15, 16, 11), box(1, 0, 5, 15, 16, 11), box(5, 0, 1, 11, 16, 15), box(5, 0, 1, 11, 16, 15));
			};
			case EAST -> switch (state.getValue(FACE)) {
				case FLOOR -> Shapes.or(box(5, 0, 1, 11, 16, 15), box(5, 0, 1, 11, 16, 15), box(1, 0, 5, 15, 16, 11), box(1, 0, 5, 15, 16, 11));
				case WALL -> Shapes.or(box(0, 5, 1, 16, 11, 15), box(0, 5, 1, 16, 11, 15), box(0, 1, 5, 16, 15, 11), box(0, 1, 5, 16, 15, 11));
				case CEILING -> Shapes.or(box(5, 0, 1, 11, 16, 15), box(5, 0, 1, 11, 16, 15), box(1, 0, 5, 15, 16, 11), box(1, 0, 5, 15, 16, 11));
			};
			case WEST -> switch (state.getValue(FACE)) {
				case FLOOR -> Shapes.or(box(5, 0, 1, 11, 16, 15), box(5, 0, 1, 11, 16, 15), box(1, 0, 5, 15, 16, 11), box(1, 0, 5, 15, 16, 11));
				case WALL -> Shapes.or(box(0, 5, 1, 16, 11, 15), box(0, 5, 1, 16, 11, 15), box(0, 1, 5, 16, 15, 11), box(0, 1, 5, 16, 15, 11));
				case CEILING -> Shapes.or(box(5, 0, 1, 11, 16, 15), box(5, 0, 1, 11, 16, 15), box(1, 0, 5, 15, 16, 11), box(1, 0, 5, 15, 16, 11));
			};
		};
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(FACING, FACE, WATERLOGGED);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		boolean flag = context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER;
		return super.getStateForPlacement(context).setValue(FACE, faceForDirection(context.getNearestLookingDirection())).setValue(FACING, context.getHorizontalDirection().getOpposite()).setValue(WATERLOGGED, flag);
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	private AttachFace faceForDirection(Direction direction) {
		if (direction.getAxis() == Direction.Axis.Y)
			return direction == Direction.UP ? AttachFace.CEILING : AttachFace.FLOOR;
		else
			return AttachFace.WALL;
	}

	@Override
	public FluidState getFluidState(BlockState state) {
		return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
	}

	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor world, BlockPos currentPos, BlockPos facingPos) {
		if (state.getValue(WATERLOGGED)) {
			world.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
		}
		return super.updateShape(state, facing, facingState, world, currentPos, facingPos);
	}
}