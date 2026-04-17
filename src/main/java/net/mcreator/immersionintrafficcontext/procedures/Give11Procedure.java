package net.mcreator.immersionintrafficcontext.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;

import net.mcreator.immersionintrafficcontext.init.ImmersionInTrafficContextModItems;

public class Give11Procedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity) {
			ItemStack _setstack0 = new ItemStack(ImmersionInTrafficContextModItems.ROAD_ENGINEERING.get()).copy();
			_setstack0.setCount(1);
			_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack0);
			if (_entity instanceof Player _player)
				_player.getInventory().setChanged();
		}
	}
}