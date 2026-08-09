package net.mcreator.immersionintrafficcontext.block;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import com.mojang.serialization.MapCodec;

import com.google.common.collect.ImmutableMap;

public class CannedFishBlockBlock extends FallingBlock implements SimpleWaterloggedBlock {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	private final ImmutableMap<BlockState, VoxelShape> shapes = this.makeShapes();
	public static final MapCodec<CannedFishBlockBlock> CODEC = simpleCodec(properties -> new CannedFishBlockBlock());

	public MapCodec<CannedFishBlockBlock> codec() {
		return CODEC;
	}

	public CannedFishBlockBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(0.1f, 10f).noOcclusion().pushReaction(PushReaction.DESTROY).isRedstoneConductor((bs, br, bp) -> false).dynamicShape().offsetType(Block.OffsetType.XZ)
				.instrument(NoteBlockInstrument.IRON_XYLOPHONE));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, false));
	}

	private ImmutableMap<BlockState, VoxelShape> makeShapes() {
		return this.getShapeForEachState(state -> {
			return switch (state.getValue(FACING)) {
				case NORTH -> Shapes.or(box(7, 7, 5, 11, 8, 9), box(7, 8, 5, 7.5, 11, 9), box(7.5, 8, 5, 10.5, 11, 5.5), box(10.5, 8, 5, 11, 11, 9), box(7.5, 8, 8.5, 10.5, 11, 9), box(8.5, 10.8, 7.4, 9.5, 11, 8.4),
						box(7.5, 10.7, 5.5, 10.5, 10.9, 8.5), box(7.5, 8, 5.5, 10.5, 9, 8.5), box(7.5, 9, 5.5, 10.5, 10, 8.5), box(7.5, 10, 5.5, 10.5, 10.5, 8.5));
				case EAST -> Shapes.or(box(7, 7, 7, 11, 8, 11), box(7, 8, 7, 11, 11, 7.5), box(10.5, 8, 7.5, 11, 11, 10.5), box(7, 8, 10.5, 11, 11, 11), box(7, 8, 7.5, 7.5, 11, 10.5), box(7.6, 10.8, 8.5, 8.6, 11, 9.5),
						box(7.5, 10.7, 7.5, 10.5, 10.9, 10.5), box(7.5, 8, 7.5, 10.5, 9, 10.5), box(7.5, 9, 7.5, 10.5, 10, 10.5), box(7.5, 10, 7.5, 10.5, 10.5, 10.5));
				case WEST -> Shapes.or(box(5, 7, 5, 9, 8, 9), box(5, 8, 8.5, 9, 11, 9), box(5, 8, 5.5, 5.5, 11, 8.5), box(5, 8, 5, 9, 11, 5.5), box(8.5, 8, 5.5, 9, 11, 8.5), box(7.4, 10.8, 6.5, 8.4, 11, 7.5), box(5.5, 10.7, 5.5, 8.5, 10.9, 8.5),
						box(5.5, 8, 5.5, 8.5, 9, 8.5), box(5.5, 9, 5.5, 8.5, 10, 8.5), box(5.5, 10, 5.5, 8.5, 10.5, 8.5));
				default -> Shapes.or(box(5, 7, 7, 9, 8, 11), box(8.5, 8, 7, 9, 11, 11), box(5.5, 8, 10.5, 8.5, 11, 11), box(5, 8, 7, 5.5, 11, 11), box(5.5, 8, 7, 8.5, 11, 7.5), box(6.5, 10.8, 7.6, 7.5, 11, 8.6), box(5.5, 10.7, 7.5, 8.5, 10.9, 10.5),
						box(5.5, 8, 7.5, 8.5, 9, 10.5), box(5.5, 9, 7.5, 8.5, 10, 10.5), box(5.5, 10, 7.5, 8.5, 10.5, 10.5));
			};
		});
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		Vec3 offset = state.getOffset(world, pos);
		return shapes.get(state).move(offset.x, offset.y, offset.z);
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return state.getFluidState().isEmpty();
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return propagatesSkylightDown(state, worldIn, pos) ? 0 : 1;
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
	public ItemStack getCloneItemStack(LevelReader level, BlockPos pos, BlockState state) {
		return ItemStack.EMPTY;
	}
}