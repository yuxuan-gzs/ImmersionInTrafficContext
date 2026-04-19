package net.mcreator.immersionintrafficcontext.item;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

public class HammerItem extends Item {
	public HammerItem(Item.Properties properties) {
		super(properties.durability(5000).fireResistant().enchantable(14).setNoCombineRepair());
	}

	@Override
	public ItemStack getCraftingRemainder(ItemStack itemstack) {
		ItemStack retval = new ItemStack(this);
		retval.setDamageValue(itemstack.getDamageValue() + 1);
		if (retval.getDamageValue() >= retval.getMaxDamage()) {
			return ItemStack.EMPTY;
		}
		return retval;
	}

	@Override
	public float getDestroySpeed(ItemStack itemstack, BlockState state) {
		return 7.2f;
	}
}