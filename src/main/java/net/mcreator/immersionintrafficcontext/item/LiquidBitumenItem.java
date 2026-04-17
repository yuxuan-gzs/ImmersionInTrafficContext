package net.mcreator.immersionintrafficcontext.item;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BucketItem;

import net.mcreator.immersionintrafficcontext.init.ImmersionInTrafficContextModFluids;

public class LiquidBitumenItem extends BucketItem {
	public LiquidBitumenItem() {
		super(ImmersionInTrafficContextModFluids.LIQUID_BITUMEN.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)

		);
	}
}