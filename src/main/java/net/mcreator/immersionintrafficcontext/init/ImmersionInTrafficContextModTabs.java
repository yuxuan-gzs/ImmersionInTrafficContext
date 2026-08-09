/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.immersionintrafficcontext.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.immersionintrafficcontext.ImmersionInTrafficContextMod;

public class ImmersionInTrafficContextModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ImmersionInTrafficContextMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> IMMERSION_IN_TRAFFIC_CONTEXT = REGISTRY.register("immersion_in_traffic_context", () -> CreativeModeTab.builder()
			.title(Component.translatable("item_group.immersion_in_traffic_context.immersion_in_traffic_context")).icon(() -> new ItemStack(ImmersionInTrafficContextModItems.PETROLEUM_BUCKET.get())).displayItems((parameters, tabData) -> {
				tabData.accept(ImmersionInTrafficContextModItems.PETROLEUM_BUCKET.get());
				tabData.accept(ImmersionInTrafficContextModItems.WASTE.get());
				tabData.accept(ImmersionInTrafficContextModItems.ASPHALT.get());
				tabData.accept(ImmersionInTrafficContextModItems.HAMMER.get());
				tabData.accept(ImmersionInTrafficContextModItems.REDSTONELEDTUBE.get());
				tabData.accept(ImmersionInTrafficContextModItems.TEST_TUBE.get());
				tabData.accept(ImmersionInTrafficContextModItems.PETROLEUM_IN_A_SMALL_BOTTLE.get());
				tabData.accept(ImmersionInTrafficContextModBlocks.BITUMINOUS_ORE.get().asItem());
				tabData.accept(ImmersionInTrafficContextModBlocks.ASPHALT_MIXING_PLANT.get().asItem());
				tabData.accept(ImmersionInTrafficContextModBlocks.ROUGH_ASPHALT_BLOCK.get().asItem());
				tabData.accept(ImmersionInTrafficContextModBlocks.ASPHALT_ROAD_BLOCK.get().asItem());
				tabData.accept(ImmersionInTrafficContextModBlocks.WHITE_ZEBRA_CROSSING.get().asItem());
				tabData.accept(ImmersionInTrafficContextModBlocks.JUNCTION_1.get().asItem());
				tabData.accept(ImmersionInTrafficContextModBlocks.JUNCTION_2.get().asItem());
				tabData.accept(ImmersionInTrafficContextModBlocks.JUNCTION_3.get().asItem());
				tabData.accept(ImmersionInTrafficContextModBlocks.ASPHALT_ROAD_BLOCK_ILLUMINATION_LIGHT.get().asItem());
				tabData.accept(ImmersionInTrafficContextModBlocks.LEFT_TURN_ASPHALT_PAVEMENT_BLOCK.get().asItem());
				tabData.accept(ImmersionInTrafficContextModBlocks.STRAIGHT_AHEAD_ASPHALT_PAVEMENT_BLOCK.get().asItem());
				tabData.accept(ImmersionInTrafficContextModBlocks.RIGHT_TURN_ASPHALT_PAVEMENT_BLOCK.get().asItem());
				tabData.accept(ImmersionInTrafficContextModBlocks.ASPHALT_PAVEMENT_BLOCKS_FOR_LEFT_AND_RIGHT_TURNS.get().asItem());
				tabData.accept(ImmersionInTrafficContextModBlocks.STRAIGHT_AHEAD_AND_LEFT_TURN_ASPHALT_PAVEMENT_BLOCK.get().asItem());
				tabData.accept(ImmersionInTrafficContextModBlocks.STRAIGHT_AHEAD_AND_RIGHT_TURN_ASPHALT_PAVEMENT_BLOCK.get().asItem());
				tabData.accept(ImmersionInTrafficContextModBlocks.U_TURN_ASPHALT_PAVEMENT_BLOCK.get().asItem());
				tabData.accept(ImmersionInTrafficContextModBlocks.YELLOW_ZEBRA_CROSSING.get().asItem());
				tabData.accept(ImmersionInTrafficContextModBlocks.DUAL_YELLOW_ZEBRA_CROSSING.get().asItem());
				tabData.accept(ImmersionInTrafficContextModBlocks.IRON_DRAWER_CABINET.get().asItem());
				tabData.accept(ImmersionInTrafficContextModItems.LIQUID_BITUMEN_BUCKET.get());
				tabData.accept(ImmersionInTrafficContextModBlocks.INCLINED_WHITE_CONCRETE_HALF_BRICK.get().asItem());
				tabData.accept(ImmersionInTrafficContextModBlocks.INCLINED_GRAY_CONCRETE_HALF_BRICK.get().asItem());
				tabData.accept(ImmersionInTrafficContextModBlocks.WHITE_CONCRETE_STONE_PILLAR.get().asItem());
				tabData.accept(ImmersionInTrafficContextModBlocks.GRAY_CONCRETE_STONE_PILLAR.get().asItem());
				tabData.accept(ImmersionInTrafficContextModItems.ROAD_LINE_REMOVAL_SPRAY.get());
				tabData.accept(ImmersionInTrafficContextModItems.INDUSTRIAL_CAPSICUM_1.get());
				tabData.accept(ImmersionInTrafficContextModItems.IRON_CAN.get());
				tabData.accept(ImmersionInTrafficContextModBlocks.INDUSTRIAL_FURNACE.get().asItem());
				tabData.accept(ImmersionInTrafficContextModItems.MOULD.get());
				tabData.accept(ImmersionInTrafficContextModItems.PLASTIC_INGOT.get());
				tabData.accept(ImmersionInTrafficContextModItems.SAFETY_HELMET.get());
				tabData.accept(ImmersionInTrafficContextModItems.SAFETY_CHESTPLATE.get());
				tabData.accept(ImmersionInTrafficContextModItems.SAFETY_LEGGINGS.get());
				tabData.accept(ImmersionInTrafficContextModItems.SAFETY_BOOTS.get());
				tabData.accept(ImmersionInTrafficContextModBlocks.INDUSTRIAL_FURNACE_BRICK.get().asItem());
				tabData.accept(ImmersionInTrafficContextModBlocks.INDUSTRIAL_FURNACE_TANK.get().asItem());
				tabData.accept(ImmersionInTrafficContextModItems.INDUSTRIAL_FURNACE_USER_MANUAL.get());
				tabData.accept(ImmersionInTrafficContextModItems.ETHYLENE_BUCKET.get());
				tabData.accept(ImmersionInTrafficContextModItems.SALT.get());
				tabData.accept(ImmersionInTrafficContextModItems.ELECTRODE.get());
				tabData.accept(ImmersionInTrafficContextModItems.ROAD_ENGINEERING.get());
				tabData.accept(ImmersionInTrafficContextModBlocks.SOLID_PETROLEUM.get().asItem());
				tabData.accept(ImmersionInTrafficContextModBlocks.SIGNAL_BARREL.get().asItem());
				tabData.accept(ImmersionInTrafficContextModItems.CANNED_FISH.get());
				tabData.accept(ImmersionInTrafficContextModItems.SPRING_ONION_SEEDS.get());
				tabData.accept(ImmersionInTrafficContextModItems.SCALLION_MAIN.get());
				tabData.accept(ImmersionInTrafficContextModBlocks.TRAFFIC_LIGHTS.get().asItem());
				tabData.accept(ImmersionInTrafficContextModBlocks.TRAFFIC_SIGNAL_POLE_I.get().asItem());
				tabData.accept(ImmersionInTrafficContextModBlocks.TRAFFIC_SIGNAL_POLE_II.get().asItem());
				tabData.accept(ImmersionInTrafficContextModBlocks.TRAFFIC_SIGNAL_POLE_I_AND_II.get().asItem());
				tabData.accept(ImmersionInTrafficContextModItems.SIMPLE_CIRCUIT_COMPONENTS.get());
			}).withSearchBar().build());
}