package net.mcreator.immersionintrafficcontext.item;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BucketItem;

import net.mcreator.immersionintrafficcontext.init.ImmersionInTrafficContextModFluids;

public class EthyleneItem extends BucketItem {
	public EthyleneItem(Item.Properties properties) {
		super(ImmersionInTrafficContextModFluids.ETHYLENE.get(), properties.craftRemainder(Items.BUCKET).stacksTo(1)

		);
	}
}