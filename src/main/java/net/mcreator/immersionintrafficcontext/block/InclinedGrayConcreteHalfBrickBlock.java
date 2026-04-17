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

public class InclinedGrayConcreteHalfBrickBlock extends Block implements SimpleWaterloggedBlock {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public static final EnumProperty<AttachFace> FACE = FaceAttachedHorizontalDirectionalBlock.FACE;
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

	public InclinedGrayConcreteHalfBrickBlock() {
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
				case FLOOR -> Shapes.or(box(0, 0, 15, 15, 8, 16), box(0, 0, 1, 1, 8, 16), box(1, 0, 8, 8, 8, 15), box(8, 0, 14, 14, 8, 15), box(8, 0, 11, 11, 8, 14), box(8, 0, 10, 10, 8, 11), box(11, 0, 13, 13, 8, 14), box(1, 0, 7, 7, 8, 8),
						box(1, 0, 4, 4, 8, 7), box(1, 0, 3, 3, 8, 4), box(4, 0, 6, 6, 8, 7), box(8, 0, 9, 9, 8, 10), box(4, 0, 5, 5, 8, 6), box(11, 0, 12, 12, 8, 13), box(1, 0, 2, 2, 8, 3));
				case WALL -> Shapes.or(box(0, 0, 0, 15, 1, 8), box(0, 0, 0, 1, 15, 8), box(1, 1, 0, 8, 8, 8), box(8, 1, 0, 14, 2, 8), box(8, 2, 0, 11, 5, 8), box(8, 5, 0, 10, 6, 8), box(11, 2, 0, 13, 3, 8), box(1, 8, 0, 7, 9, 8),
						box(1, 9, 0, 4, 12, 8), box(1, 12, 0, 3, 13, 8), box(4, 9, 0, 6, 10, 8), box(8, 6, 0, 9, 7, 8), box(4, 10, 0, 5, 11, 8), box(11, 3, 0, 12, 4, 8), box(1, 13, 0, 2, 14, 8));
				case CEILING -> Shapes.or(box(1, 8, 15, 16, 16, 16), box(15, 8, 1, 16, 16, 16), box(8, 8, 8, 15, 16, 15), box(2, 8, 14, 8, 16, 15), box(5, 8, 11, 8, 16, 14), box(6, 8, 10, 8, 16, 11), box(3, 8, 13, 5, 16, 14), box(9, 8, 7, 15, 16, 8),
						box(12, 8, 4, 15, 16, 7), box(13, 8, 3, 15, 16, 4), box(10, 8, 6, 12, 16, 7), box(7, 8, 9, 8, 16, 10), box(11, 8, 5, 12, 16, 6), box(4, 8, 12, 5, 16, 13), box(14, 8, 2, 15, 16, 3));
			};
			case NORTH -> switch (state.getValue(FACE)) {
				case FLOOR -> Shapes.or(box(1, 0, 0, 16, 8, 1), box(15, 0, 0, 16, 8, 15), box(8, 0, 1, 15, 8, 8), box(2, 0, 1, 8, 8, 2), box(5, 0, 2, 8, 8, 5), box(6, 0, 5, 8, 8, 6), box(3, 0, 2, 5, 8, 3), box(9, 0, 8, 15, 8, 9),
						box(12, 0, 9, 15, 8, 12), box(13, 0, 12, 15, 8, 13), box(10, 0, 9, 12, 8, 10), box(7, 0, 6, 8, 8, 7), box(11, 0, 10, 12, 8, 11), box(4, 0, 3, 5, 8, 4), box(14, 0, 13, 15, 8, 14));
				case WALL -> Shapes.or(box(1, 0, 8, 16, 1, 16), box(15, 0, 8, 16, 15, 16), box(8, 1, 8, 15, 8, 16), box(2, 1, 8, 8, 2, 16), box(5, 2, 8, 8, 5, 16), box(6, 5, 8, 8, 6, 16), box(3, 2, 8, 5, 3, 16), box(9, 8, 8, 15, 9, 16),
						box(12, 9, 8, 15, 12, 16), box(13, 12, 8, 15, 13, 16), box(10, 9, 8, 12, 10, 16), box(7, 6, 8, 8, 7, 16), box(11, 10, 8, 12, 11, 16), box(4, 3, 8, 5, 4, 16), box(14, 13, 8, 15, 14, 16));
				case CEILING -> Shapes.or(box(0, 8, 0, 15, 16, 1), box(0, 8, 0, 1, 16, 15), box(1, 8, 1, 8, 16, 8), box(8, 8, 1, 14, 16, 2), box(8, 8, 2, 11, 16, 5), box(8, 8, 5, 10, 16, 6), box(11, 8, 2, 13, 16, 3), box(1, 8, 8, 7, 16, 9),
						box(1, 8, 9, 4, 16, 12), box(1, 8, 12, 3, 16, 13), box(4, 8, 9, 6, 16, 10), box(8, 8, 6, 9, 16, 7), box(4, 8, 10, 5, 16, 11), box(11, 8, 3, 12, 16, 4), box(1, 8, 13, 2, 16, 14));
			};
			case EAST -> switch (state.getValue(FACE)) {
				case FLOOR -> Shapes.or(box(15, 0, 1, 16, 8, 16), box(1, 0, 15, 16, 8, 16), box(8, 0, 8, 15, 8, 15), box(14, 0, 2, 15, 8, 8), box(11, 0, 5, 14, 8, 8), box(10, 0, 6, 11, 8, 8), box(13, 0, 3, 14, 8, 5), box(7, 0, 9, 8, 8, 15),
						box(4, 0, 12, 7, 8, 15), box(3, 0, 13, 4, 8, 15), box(6, 0, 10, 7, 8, 12), box(9, 0, 7, 10, 8, 8), box(5, 0, 11, 6, 8, 12), box(12, 0, 4, 13, 8, 5), box(2, 0, 14, 3, 8, 15));
				case WALL -> Shapes.or(box(0, 0, 1, 8, 1, 16), box(0, 0, 15, 8, 15, 16), box(0, 1, 8, 8, 8, 15), box(0, 1, 2, 8, 2, 8), box(0, 2, 5, 8, 5, 8), box(0, 5, 6, 8, 6, 8), box(0, 2, 3, 8, 3, 5), box(0, 8, 9, 8, 9, 15),
						box(0, 9, 12, 8, 12, 15), box(0, 12, 13, 8, 13, 15), box(0, 9, 10, 8, 10, 12), box(0, 6, 7, 8, 7, 8), box(0, 10, 11, 8, 11, 12), box(0, 3, 4, 8, 4, 5), box(0, 13, 14, 8, 14, 15));
				case CEILING -> Shapes.or(box(15, 8, 0, 16, 16, 15), box(1, 8, 0, 16, 16, 1), box(8, 8, 1, 15, 16, 8), box(14, 8, 8, 15, 16, 14), box(11, 8, 8, 14, 16, 11), box(10, 8, 8, 11, 16, 10), box(13, 8, 11, 14, 16, 13),
						box(7, 8, 1, 8, 16, 7), box(4, 8, 1, 7, 16, 4), box(3, 8, 1, 4, 16, 3), box(6, 8, 4, 7, 16, 6), box(9, 8, 8, 10, 16, 9), box(5, 8, 4, 6, 16, 5), box(12, 8, 11, 13, 16, 12), box(2, 8, 1, 3, 16, 2));
			};
			case WEST -> switch (state.getValue(FACE)) {
				case FLOOR -> Shapes.or(box(0, 0, 0, 1, 8, 15), box(0, 0, 0, 15, 8, 1), box(1, 0, 1, 8, 8, 8), box(1, 0, 8, 2, 8, 14), box(2, 0, 8, 5, 8, 11), box(5, 0, 8, 6, 8, 10), box(2, 0, 11, 3, 8, 13), box(8, 0, 1, 9, 8, 7),
						box(9, 0, 1, 12, 8, 4), box(12, 0, 1, 13, 8, 3), box(9, 0, 4, 10, 8, 6), box(6, 0, 8, 7, 8, 9), box(10, 0, 4, 11, 8, 5), box(3, 0, 11, 4, 8, 12), box(13, 0, 1, 14, 8, 2));
				case WALL -> Shapes.or(box(8, 0, 0, 16, 1, 15), box(8, 0, 0, 16, 15, 1), box(8, 1, 1, 16, 8, 8), box(8, 1, 8, 16, 2, 14), box(8, 2, 8, 16, 5, 11), box(8, 5, 8, 16, 6, 10), box(8, 2, 11, 16, 3, 13), box(8, 8, 1, 16, 9, 7),
						box(8, 9, 1, 16, 12, 4), box(8, 12, 1, 16, 13, 3), box(8, 9, 4, 16, 10, 6), box(8, 6, 8, 16, 7, 9), box(8, 10, 4, 16, 11, 5), box(8, 3, 11, 16, 4, 12), box(8, 13, 1, 16, 14, 2));
				case CEILING -> Shapes.or(box(0, 8, 1, 1, 16, 16), box(0, 8, 15, 15, 16, 16), box(1, 8, 8, 8, 16, 15), box(1, 8, 2, 2, 16, 8), box(2, 8, 5, 5, 16, 8), box(5, 8, 6, 6, 16, 8), box(2, 8, 3, 3, 16, 5), box(8, 8, 9, 9, 16, 15),
						box(9, 8, 12, 12, 16, 15), box(12, 8, 13, 13, 16, 15), box(9, 8, 10, 10, 16, 12), box(6, 8, 7, 7, 16, 8), box(10, 8, 11, 11, 16, 12), box(3, 8, 4, 4, 16, 5), box(13, 8, 14, 14, 16, 15));
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