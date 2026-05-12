/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.immersionintrafficcontext.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;

import net.minecraft.world.inventory.Slot;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.registries.Registries;
import net.minecraft.client.Minecraft;

import net.mcreator.immersionintrafficcontext.world.inventory.ItcitMenu;
import net.mcreator.immersionintrafficcontext.world.inventory.IronDrawerCabinetGUIMenu;
import net.mcreator.immersionintrafficcontext.world.inventory.IndustrialFurnaceUserManualGuiMenu;
import net.mcreator.immersionintrafficcontext.world.inventory.ITCMenu;
import net.mcreator.immersionintrafficcontext.world.inventory.A1Menu;
import net.mcreator.immersionintrafficcontext.network.MenuStateUpdateMessage;
import net.mcreator.immersionintrafficcontext.ImmersionInTrafficContextMod;

import java.util.Map;

public class ImmersionInTrafficContextModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, ImmersionInTrafficContextMod.MODID);
	public static final DeferredHolder<MenuType<?>, MenuType<A1Menu>> A_1 = REGISTRY.register("a_1", () -> IMenuTypeExtension.create(A1Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ITCMenu>> ITC = REGISTRY.register("itc", () -> IMenuTypeExtension.create(ITCMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<IronDrawerCabinetGUIMenu>> IRON_DRAWER_CABINET_GUI = REGISTRY.register("iron_drawer_cabinet_gui", () -> IMenuTypeExtension.create(IronDrawerCabinetGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ItcitMenu>> ITCIT = REGISTRY.register("itcit", () -> IMenuTypeExtension.create(ItcitMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<IndustrialFurnaceUserManualGuiMenu>> INDUSTRIAL_FURNACE_USER_MANUAL_GUI = REGISTRY.register("industrial_furnace_user_manual_gui",
			() -> IMenuTypeExtension.create(IndustrialFurnaceUserManualGuiMenu::new));

	public interface MenuAccessor {
		Map<String, Object> getMenuState();

		Map<Integer, Slot> getSlots();

		default void sendMenuStateUpdate(Player player, int elementType, String name, Object elementState, boolean needClientUpdate) {
			getMenuState().put(elementType + ":" + name, elementState);
			if (player instanceof ServerPlayer serverPlayer) {
				PacketDistributor.sendToPlayer(serverPlayer, new MenuStateUpdateMessage(elementType, name, elementState));
			} else if (player.level().isClientSide) {
				if (Minecraft.getInstance().screen instanceof ImmersionInTrafficContextModScreens.ScreenAccessor accessor && needClientUpdate)
					accessor.updateMenuState(elementType, name, elementState);
				PacketDistributor.sendToServer(new MenuStateUpdateMessage(elementType, name, elementState));
			}
		}

		default <T> T getMenuState(int elementType, String name, T defaultValue) {
			try {
				return (T) getMenuState().getOrDefault(elementType + ":" + name, defaultValue);
			} catch (ClassCastException e) {
				return defaultValue;
			}
		}
	}
}