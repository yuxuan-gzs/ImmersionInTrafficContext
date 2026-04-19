package net.mcreator.immersionintrafficcontext.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class IndustrialCapsicum1Item extends Item {
	public IndustrialCapsicum1Item(Item.Properties properties) {
		super(properties.food((new FoodProperties.Builder()).nutrition(-300).saturationModifier(-5f).alwaysEdible().build()));
	}
}