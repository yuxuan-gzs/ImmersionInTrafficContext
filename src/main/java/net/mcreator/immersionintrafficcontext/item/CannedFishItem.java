package net.mcreator.immersionintrafficcontext.item;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.Item;
import net.minecraft.world.InteractionResult;

import net.mcreator.immersionintrafficcontext.procedures.CannedFishYouJiFangKuaiShiFangKuaiDeWeiZhiProcedure;

public class CannedFishItem extends Item {
	public CannedFishItem() {
		super(new Item.Properties().stacksTo(16));
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		CannedFishYouJiFangKuaiShiFangKuaiDeWeiZhiProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getItemInHand());
		return InteractionResult.SUCCESS;
	}
}