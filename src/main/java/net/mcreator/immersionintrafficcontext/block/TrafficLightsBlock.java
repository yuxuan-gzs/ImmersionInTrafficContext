package net.mcreator.immersionintrafficcontext.block;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.Containers;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.immersionintrafficcontext.procedures.TrafficLightsZaiYouXiKeGengXinShiProcedure;
import net.mcreator.immersionintrafficcontext.procedures.TrafficLightsShuBiaoYouJianDanJiFangKuaiShiProcedure;
import net.mcreator.immersionintrafficcontext.procedures.TrafficLightsFangKuaiBeiFangZhiShiProcedure;
import net.mcreator.immersionintrafficcontext.block.entity.TrafficLightsBlockEntity;

import com.google.common.collect.ImmutableMap;

public class TrafficLightsBlock extends Block implements EntityBlock {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 2);
	private final ImmutableMap<BlockState, VoxelShape> shapes = this.makeShapes();

	public TrafficLightsBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(1f, 17f).lightLevel(blockstate -> 15).requiresCorrectToolForDrops().noOcclusion().pushReaction(PushReaction.IGNORE).hasPostProcess((bs, br, bp) -> true)
				.emissiveRendering((bs, br, bp) -> true).isRedstoneConductor((bs, br, bp) -> false).instrument(NoteBlockInstrument.IRON_XYLOPHONE));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(AGE, 0));
	}

	private ImmutableMap<BlockState, VoxelShape> makeShapes() {
		return this.getShapeForEachState(state -> {
			return switch (state.getValue(FACING)) {
				case NORTH -> Shapes.or(box(-11, 5, 5, -5, 11, 11), box(-5, 7, 7, 0, 9, 9), box(1, -2, 4, 2, 18, 12), box(2, 12, 6, 3, 16, 10), box(2, 6, 6, 3, 10, 10), box(2, 0, 6, 3, 4, 10), box(2, -2, 4, 3, 18, 6), box(2, -2, 6, 3, 0, 10),
						box(2, -2, 10, 3, 18, 12), box(2, 16, 6, 3, 18, 10), box(2, 10, 6, 3, 12, 10), box(2, 4, 6, 3, 6, 10), box(3, 0, 10, 4, 4, 11), box(3, 4, 5, 4, 5, 11), box(3, 0, 5, 4, 4, 6), box(3, 6, 5, 4, 10, 6), box(3, 6, 10, 4, 10, 11),
						box(3, 10, 5, 4, 11, 11), box(3, 12, 5, 4, 16, 6), box(3, 12, 10, 4, 16, 11), box(3, 16, 5, 4, 17, 11), box(0, -1, 5, 1, 17, 11), box(-1, 1, 7, 1, 15, 9));
				case EAST -> Shapes.or(box(5, 5, -11, 11, 11, -5), box(7, 7, -5, 9, 9, 0), box(4, -2, 1, 12, 18, 2), box(6, 12, 2, 10, 16, 3), box(6, 6, 2, 10, 10, 3), box(6, 0, 2, 10, 4, 3), box(10, -2, 2, 12, 18, 3), box(6, -2, 2, 10, 0, 3),
						box(4, -2, 2, 6, 18, 3), box(6, 16, 2, 10, 18, 3), box(6, 10, 2, 10, 12, 3), box(6, 4, 2, 10, 6, 3), box(5, 0, 3, 6, 4, 4), box(5, 4, 3, 11, 5, 4), box(10, 0, 3, 11, 4, 4), box(10, 6, 3, 11, 10, 4), box(5, 6, 3, 6, 10, 4),
						box(5, 10, 3, 11, 11, 4), box(10, 12, 3, 11, 16, 4), box(5, 12, 3, 6, 16, 4), box(5, 16, 3, 11, 17, 4), box(5, -1, 0, 11, 17, 1), box(7, 1, -1, 9, 15, 1));
				case WEST -> Shapes.or(box(5, 5, 21, 11, 11, 27), box(7, 7, 16, 9, 9, 21), box(4, -2, 14, 12, 18, 15), box(6, 12, 13, 10, 16, 14), box(6, 6, 13, 10, 10, 14), box(6, 0, 13, 10, 4, 14), box(4, -2, 13, 6, 18, 14),
						box(6, -2, 13, 10, 0, 14), box(10, -2, 13, 12, 18, 14), box(6, 16, 13, 10, 18, 14), box(6, 10, 13, 10, 12, 14), box(6, 4, 13, 10, 6, 14), box(10, 0, 12, 11, 4, 13), box(5, 4, 12, 11, 5, 13), box(5, 0, 12, 6, 4, 13),
						box(5, 6, 12, 6, 10, 13), box(10, 6, 12, 11, 10, 13), box(5, 10, 12, 11, 11, 13), box(5, 12, 12, 6, 16, 13), box(10, 12, 12, 11, 16, 13), box(5, 16, 12, 11, 17, 13), box(5, -1, 15, 11, 17, 16), box(7, 1, 15, 9, 15, 17));
				default -> Shapes.or(box(21, 5, 5, 27, 11, 11), box(16, 7, 7, 21, 9, 9), box(14, -2, 4, 15, 18, 12), box(13, 12, 6, 14, 16, 10), box(13, 6, 6, 14, 10, 10), box(13, 0, 6, 14, 4, 10), box(13, -2, 10, 14, 18, 12),
						box(13, -2, 6, 14, 0, 10), box(13, -2, 4, 14, 18, 6), box(13, 16, 6, 14, 18, 10), box(13, 10, 6, 14, 12, 10), box(13, 4, 6, 14, 6, 10), box(12, 0, 5, 13, 4, 6), box(12, 4, 5, 13, 5, 11), box(12, 0, 10, 13, 4, 11),
						box(12, 6, 10, 13, 10, 11), box(12, 6, 5, 13, 10, 6), box(12, 10, 5, 13, 11, 11), box(12, 12, 10, 13, 16, 11), box(12, 12, 5, 13, 16, 6), box(12, 16, 5, 13, 17, 11), box(15, -1, 5, 16, 17, 11), box(15, 1, 7, 17, 15, 9));
			};
		});
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return shapes.get(state);
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return true;
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
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(FACING, AGE);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		BlockState state = super.getStateForPlacement(context);
		if (state == null)
			return null;
		return state.setValue(FACING, context.getHorizontalDirection().getOpposite()).setValue(AGE, 0);
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	@Override
	public boolean isSignalSource(BlockState state) {
		return true;
	}

	@Override
	public int getSignal(BlockState blockstate, BlockGetter blockAccess, BlockPos pos, Direction direction) {
		return 2;
	}

	@Override
	public boolean canConnectRedstone(BlockState state, BlockGetter world, BlockPos pos, Direction side) {
		return true;
	}

	@Override
	public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
		super.onPlace(blockstate, world, pos, oldState, moving);
		world.scheduleTick(pos, this, 20);
		TrafficLightsFangKuaiBeiFangZhiShiProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}

	@Override
	public void tick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
		super.tick(blockstate, world, pos, random);
		TrafficLightsZaiYouXiKeGengXinShiProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
		world.scheduleTick(pos, this, 20);
	}

	@Override
	public InteractionResult useWithoutItem(BlockState blockstate, Level world, BlockPos pos, Player entity, BlockHitResult hit) {
		super.useWithoutItem(blockstate, world, pos, entity, hit);
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		double hitX = hit.getLocation().x;
		double hitY = hit.getLocation().y;
		double hitZ = hit.getLocation().z;
		Direction direction = hit.getDirection();
		TrafficLightsShuBiaoYouJianDanJiFangKuaiShiProcedure.execute(world, x, y, z, entity);
		return InteractionResult.SUCCESS;
	}

	@Override
	public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
		BlockEntity tileEntity = worldIn.getBlockEntity(pos);
		return tileEntity instanceof MenuProvider menuProvider ? menuProvider : null;
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new TrafficLightsBlockEntity(pos, state);
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
			if (blockEntity instanceof TrafficLightsBlockEntity be) {
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
		if (tileentity instanceof TrafficLightsBlockEntity be)
			return AbstractContainerMenu.getRedstoneSignalFromContainer(be);
		else
			return 0;
	}
}