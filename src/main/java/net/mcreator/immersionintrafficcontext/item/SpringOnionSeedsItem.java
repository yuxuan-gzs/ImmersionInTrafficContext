package net.mcreator.immersionintrafficcontext.item;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.Item;
import net.minecraft.world.InteractionResult;

import net.mcreator.immersionintrafficcontext.procedures.SpringOnionSeedsYouJiFangKuaiShiFangKuaiDeWeiZhiProcedure;

public class SpringOnionSeedsItem extends Item {
	public SpringOnionSeedsItem() {
		super(new Item.Properties());
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		SpringOnionSeedsYouJiFangKuaiShiFangKuaiDeWeiZhiProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getItemInHand());
		return InteractionResult.SUCCESS;
	}
}