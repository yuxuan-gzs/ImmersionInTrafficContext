package net.mcreator.immersionintrafficcontext.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class ScallionMainItem extends Item {
	public ScallionMainItem() {
		super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(0).saturationModifier(0.1f).alwaysEdible().build()));
	}
}