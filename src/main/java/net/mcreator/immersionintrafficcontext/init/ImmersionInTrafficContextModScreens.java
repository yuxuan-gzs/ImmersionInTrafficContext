/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.immersionintrafficcontext.init;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.immersionintrafficcontext.client.gui.*;

@EventBusSubscriber(Dist.CLIENT)
public class ImmersionInTrafficContextModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(ImmersionInTrafficContextModMenus.A_1.get(), A1Screen::new);
		event.register(ImmersionInTrafficContextModMenus.ITC.get(), ITCScreen::new);
		event.register(ImmersionInTrafficContextModMenus.IRON_DRAWER_CABINET_GUI.get(), IronDrawerCabinetGUIScreen::new);
		event.register(ImmersionInTrafficContextModMenus.ITCIT.get(), ItcitScreen::new);
		event.register(ImmersionInTrafficContextModMenus.INDUSTRIAL_FURNACE_USER_MANUAL_GUI.get(), IndustrialFurnaceUserManualGuiScreen::new);
		event.register(ImmersionInTrafficContextModMenus.ITC_1.get(), Itc1Screen::new);
		event.register(ImmersionInTrafficContextModMenus.ITC_2.get(), Itc2Screen::new);
		event.register(ImmersionInTrafficContextModMenus.ITC_3.get(), Itc3Screen::new);
		event.register(ImmersionInTrafficContextModMenus.TRAFFIC_LIGHT.get(), TrafficLightScreen::new);
		event.register(ImmersionInTrafficContextModMenus.ITC_4.get(), Itc4Screen::new);
	}

	public interface ScreenAccessor {
		void updateMenuState(int elementType, String name, Object elementState);
	}
}