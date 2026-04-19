package net.mcreator.immersionintrafficcontext.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.immersionintrafficcontext.init.ImmersionInTrafficContextModItems;

public class ItcitliuchenProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 9).copy()).getItem() == ImmersionInTrafficContextModItems.HAMMER.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 9).getCount() == 1
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 20).copy()).getItem() == Items.COAL && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 20).getCount() >= 10
				&& itemFromBlockInventory(world, BlockPos.containing(x, y, z), 11).getCount() == 0 && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 12).getCount() == 0
				&& itemFromBlockInventory(world, BlockPos.containing(x, y, z), 13).getCount() == 0 && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 14).getCount() == 0
				&& itemFromBlockInventory(world, BlockPos.containing(x, y, z), 15).getCount() == 0 && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 16).getCount() == 0
				&& itemFromBlockInventory(world, BlockPos.containing(x, y, z), 17).getCount() == 0 && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 18).getCount() == 0
				&& itemFromBlockInventory(world, BlockPos.containing(x, y, z), 19).getCount() == 0
				&& ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == ImmersionInTrafficContextModItems.ASPHALT.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).getCount() >= 9
						&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 10).copy()).getItem() == Items.BUCKET && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 10).getCount() >= 1
						|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == ImmersionInTrafficContextModItems.ETHYLENE_BUCKET.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).getCount() >= 1
								&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == ImmersionInTrafficContextModItems.SALT.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount() >= 10
								&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 10).copy()).getItem() == ImmersionInTrafficContextModItems.MOULD.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 10).getCount() >= 1
						|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == Items.WATER_BUCKET && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).getCount() == 1
								&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 10).copy()).getItem() == ImmersionInTrafficContextModItems.ELECTRODE.get()
								&& itemFromBlockInventory(world, BlockPos.containing(x, y, z), 10).getCount() >= 1)) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putDouble("jd", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "jd") + 1));
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putDouble("sj", 1);
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "jd") >= 25 && (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == ImmersionInTrafficContextModItems.ASPHALT.get()
					&& itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).getCount() >= 9 && (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 10).copy()).getItem() == Items.BUCKET
					&& itemFromBlockInventory(world, BlockPos.containing(x, y, z), 10).getCount() >= 1) {
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					int _slotid = 0;
					ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
					_stk.shrink(9);
					_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					int _slotid = 10;
					ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
					_stk.shrink(1);
					_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					int _slotid = 20;
					ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
					_stk.shrink(10);
					_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					ItemStack _setstack = new ItemStack(ImmersionInTrafficContextModItems.LIQUID_BITUMEN_BUCKET.get()).copy();
					_setstack.setCount(1);
					_itemHandlerModifiable.setStackInSlot(11, _setstack);
				}
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putDouble("sj", 0);
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putDouble("jd", 0);
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (world instanceof ILevelExtension _ext && world instanceof ServerLevel _serverLevel
						&& _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					int _slotid = 9;
					ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
					_stk.hurtAndBreak(200, _serverLevel, null, _stkprov -> {
					});
					_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
				}
			} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "jd") >= 25 && (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == ImmersionInTrafficContextModItems.ETHYLENE_BUCKET.get()
					&& itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).getCount() >= 1 && (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == ImmersionInTrafficContextModItems.SALT.get()
					&& itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount() >= 10 && (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 10).copy()).getItem() == ImmersionInTrafficContextModItems.MOULD.get()
					&& itemFromBlockInventory(world, BlockPos.containing(x, y, z), 10).getCount() >= 1) {
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					int _slotid = 0;
					ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
					_stk.shrink(8);
					_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
				}
				if (world instanceof ILevelExtension _ext && world instanceof ServerLevel _serverLevel
						&& _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					int _slotid = 10;
					ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
					_stk.hurtAndBreak(2, _serverLevel, null, _stkprov -> {
					});
					_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					int _slotid = 20;
					ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
					_stk.shrink(10);
					_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					ItemStack _setstack = new ItemStack(ImmersionInTrafficContextModItems.PLASTIC_INGOT.get()).copy();
					_setstack.setCount(15);
					_itemHandlerModifiable.setStackInSlot(11, _setstack);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					ItemStack _setstack = new ItemStack(ImmersionInTrafficContextModItems.WASTE.get()).copy();
					_setstack.setCount(9);
					_itemHandlerModifiable.setStackInSlot(12, _setstack);
				}
				if (world instanceof ILevelExtension _ext && world instanceof ServerLevel _serverLevel
						&& _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					int _slotid = 9;
					ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
					_stk.hurtAndBreak(50, _serverLevel, null, _stkprov -> {
					});
					_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
				}
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putDouble("sj", 0);
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putDouble("jd", 0);
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "jd") >= 25 && (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == Items.WATER_BUCKET
					&& itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).getCount() == 1 && (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 10).copy()).getItem() == ImmersionInTrafficContextModItems.ELECTRODE.get()
					&& itemFromBlockInventory(world, BlockPos.containing(x, y, z), 10).getCount() >= 1) {
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					int _slotid = 0;
					ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
					_stk.shrink(1);
					_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
				}
				if (world instanceof ILevelExtension _ext && world instanceof ServerLevel _serverLevel
						&& _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					int _slotid = 10;
					ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
					_stk.hurtAndBreak(1, _serverLevel, null, _stkprov -> {
					});
					_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					int _slotid = 20;
					ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
					_stk.shrink(10);
					_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					ItemStack _setstack = new ItemStack(ImmersionInTrafficContextModItems.SALT.get()).copy();
					_setstack.setCount(63);
					_itemHandlerModifiable.setStackInSlot(11, _setstack);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					ItemStack _setstack = new ItemStack(Items.BUCKET).copy();
					_setstack.setCount(1);
					_itemHandlerModifiable.setStackInSlot(12, _setstack);
				}
				if (world instanceof ILevelExtension _ext && world instanceof ServerLevel _serverLevel
						&& _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					int _slotid = 9;
					ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
					_stk.hurtAndBreak(13, _serverLevel, null, _stkprov -> {
					});
					_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
				}
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putDouble("sj", 0);
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putDouble("jd", 0);
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		} else {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putDouble("jd", 0);
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putDouble("sj", 0);
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
	}

	private static ItemStack itemFromBlockInventory(LevelAccessor world, BlockPos pos, int slot) {
		if (world instanceof ILevelExtension ext) {
			IItemHandler itemHandler = ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
			if (itemHandler != null)
				return itemHandler.getStackInSlot(slot);
		}
		return ItemStack.EMPTY;
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}
}