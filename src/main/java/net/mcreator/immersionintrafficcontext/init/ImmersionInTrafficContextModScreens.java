/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.immersionintrafficcontext.init;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.immersionintrafficcontext.client.gui.ItcitScreen;
import net.mcreator.immersionintrafficcontext.client.gui.IronDrawerCabinetGUIScreen;
import net.mcreator.immersionintrafficcontext.client.gui.IndustrialFurnaceUserManualGuiScreen;
import net.mcreator.immersionintrafficcontext.client.gui.ITCScreen;
import net.mcreator.immersionintrafficcontext.client.gui.A1Screen;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ImmersionInTrafficContextModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(ImmersionInTrafficContextModMenus.A_1.get(), A1Screen::new);
		event.register(ImmersionInTrafficContextModMenus.ITC.get(), ITCScreen::new);
		event.register(ImmersionInTrafficContextModMenus.IRON_DRAWER_CABINET_GUI.get(), IronDrawerCabinetGUIScreen::new);
		event.register(ImmersionInTrafficContextModMenus.ITCIT.get(), ItcitScreen::new);
		event.register(ImmersionInTrafficContextModMenus.INDUSTRIAL_FURNACE_USER_MANUAL_GUI.get(), IndustrialFurnaceUserManualGuiScreen::new);
	}

	public interface ScreenAccessor {
		void updateMenuState(int elementType, String name, Object elementState);
	}
}