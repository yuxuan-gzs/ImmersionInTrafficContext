package net.mcreator.immersionintrafficcontext.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class SaltItem extends Item {
	public SaltItem(Item.Properties properties) {
		super(properties.food((new FoodProperties.Builder()).nutrition(2).saturationModifier(0.1f).alwaysEdible().build()));
	}
}