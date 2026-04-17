package net.mcreator.immersionintrafficcontext.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.immersionintrafficcontext.init.ImmersionInTrafficContextModMenus;

public class Ci2Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (((entity instanceof Player _entity0 && _entity0.containerMenu instanceof ImmersionInTrafficContextModMenus.MenuAccessor _menu0) ? _menu0.getMenuState(0, "pagination", "") : "").equals("1")
				&& ((entity instanceof Player _entity1 && _entity1.containerMenu instanceof ImmersionInTrafficContextModMenus.MenuAccessor _menu1) ? _menu1.getMenuState(0, "pagination", "") : "").equals("")) {
			return false;
		}
		return true;
	}
}