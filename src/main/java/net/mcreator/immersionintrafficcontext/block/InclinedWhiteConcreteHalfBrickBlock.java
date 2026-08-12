package net.mcreator.immersionintrafficcontext.block;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.Containers;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.immersionintrafficcontext.block.entity.InclinedWhiteConcreteHalfBrickBlockEntity;

import com.google.common.collect.ImmutableMap;

public class InclinedWhiteConcreteHalfBrickBlock extends Block implements SimpleWaterloggedBlock, EntityBlock {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	private final ImmutableMap<BlockState, VoxelShape> shapes = this.makeShapes();

	public InclinedWhiteConcreteHalfBrickBlock() {
		super(BlockBehaviour.Properties.of().strength(1f, 10f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false).instrument(NoteBlockInstrument.BASS));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, false));
	}

	private ImmutableMap<BlockState, VoxelShape> makeShapes() {
		return this.getShapeForEachState(state -> {
			return switch (state.getValue(FACING)) {
				case NORTH -> Shapes.or(box(1, 0, 0, 16, 8, 1), box(15, 0, 0, 16, 8, 15), box(8, 0, 1, 15, 8, 8), box(2, 0, 1, 8, 8, 2), box(5, 0, 2, 8, 8, 5), box(6, 0, 5, 8, 8, 6), box(3, 0, 2, 5, 8, 3), box(9, 0, 8, 15, 8, 9),
						box(12, 0, 9, 15, 8, 12), box(13, 0, 12, 15, 8, 13), box(10, 0, 9, 12, 8, 10), box(7, 0, 6, 8, 8, 7), box(11, 0, 10, 12, 8, 11), box(4, 0, 3, 5, 8, 4), box(14, 0, 13, 15, 8, 14));
				case EAST -> Shapes.or(box(15, 0, 1, 16, 8, 16), box(1, 0, 15, 16, 8, 16), box(8, 0, 8, 15, 8, 15), box(14, 0, 2, 15, 8, 8), box(11, 0, 5, 14, 8, 8), box(10, 0, 6, 11, 8, 8), box(13, 0, 3, 14, 8, 5), box(7, 0, 9, 8, 8, 15),
						box(4, 0, 12, 7, 8, 15), box(3, 0, 13, 4, 8, 15), box(6, 0, 10, 7, 8, 12), box(9, 0, 7, 10, 8, 8), box(5, 0, 11, 6, 8, 12), box(12, 0, 4, 13, 8, 5), box(2, 0, 14, 3, 8, 15));
				case WEST -> Shapes.or(box(0, 0, 0, 1, 8, 15), box(0, 0, 0, 15, 8, 1), box(1, 0, 1, 8, 8, 8), box(1, 0, 8, 2, 8, 14), box(2, 0, 8, 5, 8, 11), box(5, 0, 8, 6, 8, 10), box(2, 0, 11, 3, 8, 13), box(8, 0, 1, 9, 8, 7),
						box(9, 0, 1, 12, 8, 4), box(12, 0, 1, 13, 8, 3), box(9, 0, 4, 10, 8, 6), box(6, 0, 8, 7, 8, 9), box(10, 0, 4, 11, 8, 5), box(3, 0, 11, 4, 8, 12), box(13, 0, 1, 14, 8, 2));
				default -> Shapes.or(box(0, 0, 15, 15, 8, 16), box(0, 0, 1, 1, 8, 16), box(1, 0, 8, 8, 8, 15), box(8, 0, 14, 14, 8, 15), box(8, 0, 11, 11, 8, 14), box(8, 0, 10, 10, 8, 11), box(11, 0, 13, 13, 8, 14), box(1, 0, 7, 7, 8, 8),
						box(1, 0, 4, 4, 8, 7), box(1, 0, 3, 3, 8, 4), box(4, 0, 6, 6, 8, 7), box(8, 0, 9, 9, 8, 10), box(4, 0, 5, 5, 8, 6), box(11, 0, 12, 12, 8, 13), box(1, 0, 2, 2, 8, 3));
			};
		});
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return shapes.get(state);
	}

	@Override
	public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return Shapes.empty();
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(FACING, WATERLOGGED);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		BlockState state = super.getStateForPlacement(context);
		if (state == null)
			return null;
		boolean flag = context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER;
		return state.setValue(FACING, context.getHorizontalDirection().getOpposite()).setValue(WATERLOGGED, flag);
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
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

	@Override
	public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
		BlockEntity tileEntity = worldIn.getBlockEntity(pos);
		return tileEntity instanceof MenuProvider menuProvider ? menuProvider : null;
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new InclinedWhiteConcreteHalfBrickBlockEntity(pos, state);
	}

	@Override
	public boolean triggerEvent(BlockState state, Level world, BlockPos pos, int eventID, int eventParam) {
		super.triggerEvent(state, world, pos, eventID, eventParam);
		BlockEntity blockEntity = world.getBlockEntity(pos);
		return blockEntity != null && blockEntity.triggerEvent(eventID, eventParam);
	}

	@Override
	public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean isMoving) {
		if (state.getBlock() != newState.getBlock()) {
			BlockEntity blockEntity = world.getBlockEntity(pos);
			if (blockEntity instanceof InclinedWhiteConcreteHalfBrickBlockEntity be) {
				Containers.dropContents(world, pos, be);
				world.updateNeighbourForOutputSignal(pos, this);
			}
			super.onRemove(state, world, pos, newState, isMoving);
		}
	}

	@Override
	public boolean hasAnalogOutputSignal(BlockState state) {
		return true;
	}

	@Override
	public int getAnalogOutputSignal(BlockState blockState, Level world, BlockPos pos) {
		BlockEntity tileentity = world.getBlockEntity(pos);
		if (tileentity instanceof InclinedWhiteConcreteHalfBrickBlockEntity be)
			return AbstractContainerMenu.getRedstoneSignalFromContainer(be);
		else
			return 0;
	}
}