package net.mcreator.immersionintrafficcontext.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.immersionintrafficcontext.init.ImmersionInTrafficContextModItems;
import net.mcreator.immersionintrafficcontext.init.ImmersionInTrafficContextModBlocks;

public class IndustrialCapsicum1YouJiFangKuaiShiFangKuaiDeWeiZhiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.GRASS_BLOCK && hasEntityInInventory(entity, new ItemStack(ImmersionInTrafficContextModItems.INDUSTRIAL_CAPSICUM_1.get()))) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(ImmersionInTrafficContextModItems.INDUSTRIAL_CAPSICUM_1.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
			world.setBlock(BlockPos.containing(x, y + 1, z), ImmersionInTrafficContextModBlocks.INDUSTRIAL_CAPSICUM_MAIN.get().defaultBlockState(), 3);
		}
	}

	private static boolean hasEntityInInventory(Entity entity, ItemStack itemstack) {
		if (entity instanceof Player player)
			return player.getInventory().contains(stack -> !stack.isEmpty() && ItemStack.isSameItem(stack, itemstack));
		return false;
	}
}