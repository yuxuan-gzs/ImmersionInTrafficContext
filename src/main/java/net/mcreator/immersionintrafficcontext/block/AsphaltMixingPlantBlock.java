package net.mcreator.immersionintrafficcontext.block;

import org.checkerframework.checker.units.qual.s;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;

import net.minecraft.world.phys.BlockHitResult;
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
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.Containers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.immersionintrafficcontext.world.inventory.A1Menu;
import net.mcreator.immersionintrafficcontext.block.entity.AsphaltMixingPlantBlockEntity;

import io.netty.buffer.Unpooled;

public class AsphaltMixingPlantBlock extends Block implements SimpleWaterloggedBlock, EntityBlock {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	
	// 添加发光控制属性
	public static final BooleanProperty LIGHT_ON = BooleanProperty.create("light_on");

	public AsphaltMixingPlantBlock() {
		super(BlockBehaviour.Properties.of()
				.sound(SoundType.LODESTONE)
				.strength(9f, 13f)
				.requiresCorrectToolForDrops()
				.instrument(NoteBlockInstrument.IRON_XYLOPHONE)
				.lightLevel(state -> state.getValue(LIGHT_ON) ? 15 : 0)); // 根据LIGHT_ON控制发光强度
		
		this.registerDefaultState(this.stateDefinition.any()
				.setValue(FACING, Direction.NORTH)
				.setValue(WATERLOGGED, false)
				.setValue(LIGHT_ON, false)); // 默认不发光
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(FACING, WATERLOGGED, LIGHT_ON); // 注册LIGHT_ON属性
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		BlockState state = super.getStateForPlacement(context);
		if (state == null)
			return null;
		boolean flag = context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER;
		return state.setValue(FACING, context.getHorizontalDirection().getOpposite())
					.setValue(WATERLOGGED, flag)
					.setValue(LIGHT_ON, false); // 放置时默认不发光
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
	public InteractionResult useWithoutItem(BlockState blockstate, Level world, BlockPos pos, Player entity, BlockHitResult hit) {
		super.useWithoutItem(blockstate, world, pos, entity, hit);
		if (entity instanceof ServerPlayer player) {
			player.openMenu(new MenuProvider() {
				@Override
				public Component getDisplayName() {
					return Component.literal("Asphalt Mixing Plant");
				}

				@Override
				public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
					return new A1Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(pos));
				}
			}, pos);
		}
		return InteractionResult.SUCCESS;
	}

	@Override
	public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
		BlockEntity tileEntity = worldIn.getBlockEntity(pos);
		return tileEntity instanceof MenuProvider menuProvider ? menuProvider : null;
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new AsphaltMixingPlantBlockEntity(pos, state);
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
			if (blockEntity instanceof AsphaltMixingPlantBlockEntity be) {
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
		if (tileentity instanceof AsphaltMixingPlantBlockEntity be)
			return AbstractContainerMenu.getRedstoneSignalFromContainer(be);
		else
			return 0;
	}

	// 添加 onPlace 方法，在方块放置时启动首次调度
	@Override
	public void onPlace(BlockState state, Level world, BlockPos pos, BlockState oldState, boolean isMoving) {
		super.onPlace(state, world, pos, oldState, isMoving);
		if (!world.isClientSide()) {
			// 在方块放置后20刻开始执行第一次tick
			world.scheduleTick(pos, this, 20);
		}
	}
	
	@Override
	public void tick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
		super.tick(blockstate, world, pos, random);
		
		// 在执行流程前，先同步一次光照状态（从NBT读取）
		syncLightFromNBT(world, pos);
		
		// 调用Xcbm1Procedure流程
		net.mcreator.immersionintrafficcontext.procedures.Xcbm1Procedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
		
		// 执行完流程后，再次同步光照状态（因为Xcbm1Procedure可能修改了NBT中的light值）
		syncLightFromNBT(world, pos);
		
		// 调用AsphaltMixingPlantLiangDuProcedure获取当前光照值
		double lightLevel = net.mcreator.immersionintrafficcontext.procedures.AsphaltMixingPlantLiangDuProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
		
		// 重新调度下一个20刻
		world.scheduleTick(pos, this, 20);
	}
	
	// 同步NBT中的light值到BlockState的LIGHT_ON属性
	private void syncLightFromNBT(ServerLevel world, BlockPos pos) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null) {
			// 从NBT读取light值
			double lightNBT = blockEntity.getPersistentData().getDouble("light");
			boolean shouldBeOn = lightNBT == 1;
			
			BlockState currentState = world.getBlockState(pos);
			boolean currentLightOn = currentState.getValue(LIGHT_ON);
			
			// 如果状态不一致，更新BlockState
			if (currentLightOn != shouldBeOn) {
				world.setBlock(pos, currentState.setValue(LIGHT_ON, shouldBeOn), 3);
			}
		}
	}
}