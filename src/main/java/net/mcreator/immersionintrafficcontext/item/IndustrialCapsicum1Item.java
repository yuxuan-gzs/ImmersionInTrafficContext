package net.mcreator.immersionintrafficcontext.item;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.InteractionResult;

import net.mcreator.immersionintrafficcontext.procedures.IndustrialCapsicum1YouJiFangKuaiShiFangKuaiDeWeiZhiProcedure;

public class IndustrialCapsicum1Item extends Item {
	public IndustrialCapsicum1Item() {
		super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(-300).saturationModifier(-5f).alwaysEdible().build()));
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		IndustrialCapsicum1YouJiFangKuaiShiFangKuaiDeWeiZhiProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getPlayer());
		return InteractionResult.SUCCESS;
	}
}