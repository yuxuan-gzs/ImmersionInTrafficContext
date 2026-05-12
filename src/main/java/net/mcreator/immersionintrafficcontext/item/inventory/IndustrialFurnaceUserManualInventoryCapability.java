package net.mcreator.immersionintrafficcontext.item.inventory;

import net.neoforged.neoforge.items.ComponentItemHandler;
import net.neoforged.neoforge.event.entity.item.ItemTossEvent;
import net.neoforged.neoforge.common.MutableDataComponentHolder;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.component.DataComponents;

import net.mcreator.immersionintrafficcontext.world.inventory.IndustrialFurnaceUserManualGuiMenu;
import net.mcreator.immersionintrafficcontext.init.ImmersionInTrafficContextModItems;

import javax.annotation.Nonnull;

@EventBusSubscriber
public class IndustrialFurnaceUserManualInventoryCapability extends ComponentItemHandler {
	@SubscribeEvent
	public static void onItemDropped(ItemTossEvent event) {
		if (event.getEntity().getItem().getItem() == ImmersionInTrafficContextModItems.INDUSTRIAL_FURNACE_USER_MANUAL.get()) {
			Player player = event.getPlayer();
			if (player.containerMenu instanceof IndustrialFurnaceUserManualGuiMenu)
				player.closeContainer();
		}
	}

	public IndustrialFurnaceUserManualInventoryCapability(MutableDataComponentHolder parent) {
		super(parent, DataComponents.CONTAINER, 9);
	}

	@Override
	public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
		return stack.getItem() != ImmersionInTrafficContextModItems.INDUSTRIAL_FURNACE_USER_MANUAL.get();
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		return super.getStackInSlot(slot).copy();
	}
}