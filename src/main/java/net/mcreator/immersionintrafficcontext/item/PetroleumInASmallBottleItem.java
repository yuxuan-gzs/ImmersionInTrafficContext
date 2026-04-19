package net.mcreator.immersionintrafficcontext.item;

import net.neoforged.neoforge.event.ModifyDefaultComponentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.component.UseRemainder;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.core.component.DataComponents;

import net.mcreator.immersionintrafficcontext.init.ImmersionInTrafficContextModItems;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class PetroleumInASmallBottleItem extends Item {
	public PetroleumInASmallBottleItem(Item.Properties properties) {
		super(properties.rarity(Rarity.UNCOMMON).stacksTo(16).food((new FoodProperties.Builder()).nutrition(-4).saturationModifier(-6f).alwaysEdible().build(), Consumables.defaultFood().animation(ItemUseAnimation.NONE).build()));
	}

	@SubscribeEvent
	public static void modifyItemComponents(ModifyDefaultComponentsEvent event) {
		event.modify(ImmersionInTrafficContextModItems.PETROLEUM_IN_A_SMALL_BOTTLE.get(), builder -> builder.set(DataComponents.USE_REMAINDER, new UseRemainder(new ItemStack(ImmersionInTrafficContextModItems.TEST_TUBE.get()))));
	}
}