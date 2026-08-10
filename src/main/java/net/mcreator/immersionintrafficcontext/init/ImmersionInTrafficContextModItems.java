/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.immersionintrafficcontext.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.fluids.capability.wrappers.FluidBucketWrapper;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.mcreator.immersionintrafficcontext.item.inventory.RoadEngineeringInventoryCapability;
import net.mcreator.immersionintrafficcontext.item.inventory.IndustrialFurnaceUserManualInventoryCapability;
import net.mcreator.immersionintrafficcontext.item.*;
import net.mcreator.immersionintrafficcontext.ImmersionInTrafficContextMod;

@EventBusSubscriber
public class ImmersionInTrafficContextModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(ImmersionInTrafficContextMod.MODID);
	public static final DeferredItem<Item> PETROLEUM_BUCKET;
	public static final DeferredItem<Item> WASTE;
	public static final DeferredItem<Item> ASPHALT;
	public static final DeferredItem<Item> HAMMER;
	public static final DeferredItem<Item> ASPHALT_MIXING_PLANT;
	public static final DeferredItem<Item> REDSTONELEDTUBE;
	public static final DeferredItem<Item> ROUGH_ASPHALT_BLOCK;
	public static final DeferredItem<Item> ASPHALT_ROAD_BLOCK;
	public static final DeferredItem<Item> WHITE_ZEBRA_CROSSING;
	public static final DeferredItem<Item> TEST_TUBE;
	public static final DeferredItem<Item> PETROLEUM_IN_A_SMALL_BOTTLE;
	public static final DeferredItem<Item> JUNCTION_1;
	public static final DeferredItem<Item> JUNCTION_2;
	public static final DeferredItem<Item> JUNCTION_3;
	public static final DeferredItem<Item> ASPHALT_ROAD_BLOCK_ILLUMINATION_LIGHT;
	public static final DeferredItem<Item> BITUMINOUS_ORE;
	public static final DeferredItem<Item> ROAD_ENGINEERING;
	public static final DeferredItem<Item> DUAL_YELLOW_ZEBRA_CROSSING;
	public static final DeferredItem<Item> LEFT_TURN_ASPHALT_PAVEMENT_BLOCK;
	public static final DeferredItem<Item> YELLOW_ZEBRA_CROSSING;
	public static final DeferredItem<Item> STRAIGHT_AHEAD_ASPHALT_PAVEMENT_BLOCK;
	public static final DeferredItem<Item> RIGHT_TURN_ASPHALT_PAVEMENT_BLOCK;
	public static final DeferredItem<Item> ASPHALT_PAVEMENT_BLOCKS_FOR_LEFT_AND_RIGHT_TURNS;
	public static final DeferredItem<Item> STRAIGHT_AHEAD_AND_LEFT_TURN_ASPHALT_PAVEMENT_BLOCK;
	public static final DeferredItem<Item> STRAIGHT_AHEAD_AND_RIGHT_TURN_ASPHALT_PAVEMENT_BLOCK;
	public static final DeferredItem<Item> U_TURN_ASPHALT_PAVEMENT_BLOCK;
	public static final DeferredItem<Item> IRON_DRAWER_CABINET;
	public static final DeferredItem<Item> LIQUID_BITUMEN_BUCKET;
	public static final DeferredItem<Item> HOT_1;
	public static final DeferredItem<Item> INCLINED_WHITE_CONCRETE_HALF_BRICK;
	public static final DeferredItem<Item> WHITE_CONCRETE_STONE_PILLAR;
	public static final DeferredItem<Item> GRAY_CONCRETE_STONE_PILLAR;
	public static final DeferredItem<Item> INCLINED_GRAY_CONCRETE_HALF_BRICK;
	public static final DeferredItem<Item> ROAD_LINE_REMOVAL_SPRAY;
	public static final DeferredItem<Item> INDUSTRIAL_CAPSICUM_1;
	public static final DeferredItem<Item> IRON_CAN;
	public static final DeferredItem<Item> INDUSTRIAL_FURNACE;
	public static final DeferredItem<Item> MOULD;
	public static final DeferredItem<Item> PLASTIC_INGOT;
	public static final DeferredItem<Item> SAFETY_HELMET;
	public static final DeferredItem<Item> SAFETY_CHESTPLATE;
	public static final DeferredItem<Item> SAFETY_LEGGINGS;
	public static final DeferredItem<Item> SAFETY_BOOTS;
	public static final DeferredItem<Item> INDUSTRIAL_FURNACE_BRICK;
	public static final DeferredItem<Item> INDUSTRIAL_FURNACE_TANK;
	public static final DeferredItem<Item> INDUSTRIAL_FURNACE_USER_MANUAL;
	public static final DeferredItem<Item> ETHYLENE_BUCKET;
	public static final DeferredItem<Item> SALT;
	public static final DeferredItem<Item> ELECTRODE;
	public static final DeferredItem<Item> SOLID_PETROLEUM;
	public static final DeferredItem<Item> SIGNAL_BARREL;
	public static final DeferredItem<Item> CANNED_FISH;
	public static final DeferredItem<Item> CANNED_FISH_MAIN;
	public static final DeferredItem<Item> SPRING_ONION_SEEDS;
	public static final DeferredItem<Item> SCALLION_MAIN;
	public static final DeferredItem<Item> TRAFFIC_LIGHTS;
	public static final DeferredItem<Item> TRAFFIC_SIGNAL_POLE_I;
	public static final DeferredItem<Item> TRAFFIC_SIGNAL_POLE_II;
	public static final DeferredItem<Item> TRAFFIC_SIGNAL_POLE_I_AND_II;
	public static final DeferredItem<Item> SIMPLE_CIRCUIT_COMPONENTS;
	public static final DeferredItem<Item> WHITE_CONCRETE_HALF_BRICK;
	public static final DeferredItem<Item> WRENCH;
	static {
		PETROLEUM_BUCKET = REGISTRY.register("petroleum_bucket", PetroleumItem::new);
		WASTE = REGISTRY.register("waste", WasteItem::new);
		ASPHALT = REGISTRY.register("asphalt", AsphaltItem::new);
		HAMMER = REGISTRY.register("hammer", HammerItem::new);
		ASPHALT_MIXING_PLANT = block(ImmersionInTrafficContextModBlocks.ASPHALT_MIXING_PLANT);
		REDSTONELEDTUBE = REGISTRY.register("redstoneledtube", RedstoneledtubeItem::new);
		ROUGH_ASPHALT_BLOCK = block(ImmersionInTrafficContextModBlocks.ROUGH_ASPHALT_BLOCK);
		ASPHALT_ROAD_BLOCK = block(ImmersionInTrafficContextModBlocks.ASPHALT_ROAD_BLOCK);
		WHITE_ZEBRA_CROSSING = block(ImmersionInTrafficContextModBlocks.WHITE_ZEBRA_CROSSING);
		TEST_TUBE = REGISTRY.register("test_tube", TestTubeItem::new);
		PETROLEUM_IN_A_SMALL_BOTTLE = REGISTRY.register("petroleum_in_a_small_bottle", PetroleumInASmallBottleItem::new);
		JUNCTION_1 = block(ImmersionInTrafficContextModBlocks.JUNCTION_1);
		JUNCTION_2 = block(ImmersionInTrafficContextModBlocks.JUNCTION_2);
		JUNCTION_3 = block(ImmersionInTrafficContextModBlocks.JUNCTION_3);
		ASPHALT_ROAD_BLOCK_ILLUMINATION_LIGHT = block(ImmersionInTrafficContextModBlocks.ASPHALT_ROAD_BLOCK_ILLUMINATION_LIGHT);
		BITUMINOUS_ORE = block(ImmersionInTrafficContextModBlocks.BITUMINOUS_ORE);
		ROAD_ENGINEERING = REGISTRY.register("road_engineering", RoadEngineeringItem::new);
		DUAL_YELLOW_ZEBRA_CROSSING = block(ImmersionInTrafficContextModBlocks.DUAL_YELLOW_ZEBRA_CROSSING);
		LEFT_TURN_ASPHALT_PAVEMENT_BLOCK = block(ImmersionInTrafficContextModBlocks.LEFT_TURN_ASPHALT_PAVEMENT_BLOCK);
		YELLOW_ZEBRA_CROSSING = block(ImmersionInTrafficContextModBlocks.YELLOW_ZEBRA_CROSSING);
		STRAIGHT_AHEAD_ASPHALT_PAVEMENT_BLOCK = block(ImmersionInTrafficContextModBlocks.STRAIGHT_AHEAD_ASPHALT_PAVEMENT_BLOCK);
		RIGHT_TURN_ASPHALT_PAVEMENT_BLOCK = block(ImmersionInTrafficContextModBlocks.RIGHT_TURN_ASPHALT_PAVEMENT_BLOCK);
		ASPHALT_PAVEMENT_BLOCKS_FOR_LEFT_AND_RIGHT_TURNS = block(ImmersionInTrafficContextModBlocks.ASPHALT_PAVEMENT_BLOCKS_FOR_LEFT_AND_RIGHT_TURNS);
		STRAIGHT_AHEAD_AND_LEFT_TURN_ASPHALT_PAVEMENT_BLOCK = block(ImmersionInTrafficContextModBlocks.STRAIGHT_AHEAD_AND_LEFT_TURN_ASPHALT_PAVEMENT_BLOCK);
		STRAIGHT_AHEAD_AND_RIGHT_TURN_ASPHALT_PAVEMENT_BLOCK = block(ImmersionInTrafficContextModBlocks.STRAIGHT_AHEAD_AND_RIGHT_TURN_ASPHALT_PAVEMENT_BLOCK);
		U_TURN_ASPHALT_PAVEMENT_BLOCK = block(ImmersionInTrafficContextModBlocks.U_TURN_ASPHALT_PAVEMENT_BLOCK);
		IRON_DRAWER_CABINET = block(ImmersionInTrafficContextModBlocks.IRON_DRAWER_CABINET);
		LIQUID_BITUMEN_BUCKET = REGISTRY.register("liquid_bitumen_bucket", LiquidBitumenItem::new);
		HOT_1 = block(ImmersionInTrafficContextModBlocks.HOT_1, new Item.Properties().stacksTo(1));
		INCLINED_WHITE_CONCRETE_HALF_BRICK = block(ImmersionInTrafficContextModBlocks.INCLINED_WHITE_CONCRETE_HALF_BRICK);
		WHITE_CONCRETE_STONE_PILLAR = block(ImmersionInTrafficContextModBlocks.WHITE_CONCRETE_STONE_PILLAR);
		GRAY_CONCRETE_STONE_PILLAR = block(ImmersionInTrafficContextModBlocks.GRAY_CONCRETE_STONE_PILLAR);
		INCLINED_GRAY_CONCRETE_HALF_BRICK = block(ImmersionInTrafficContextModBlocks.INCLINED_GRAY_CONCRETE_HALF_BRICK);
		ROAD_LINE_REMOVAL_SPRAY = REGISTRY.register("road_line_removal_spray", RoadLineRemovalSprayItem::new);
		INDUSTRIAL_CAPSICUM_1 = REGISTRY.register("industrial_capsicum_1", IndustrialCapsicum1Item::new);
		IRON_CAN = REGISTRY.register("iron_can", IronCanItem::new);
		INDUSTRIAL_FURNACE = block(ImmersionInTrafficContextModBlocks.INDUSTRIAL_FURNACE);
		MOULD = REGISTRY.register("mould", MouldItem::new);
		PLASTIC_INGOT = REGISTRY.register("plastic_ingot", PlasticIngotItem::new);
		SAFETY_HELMET = REGISTRY.register("safety_helmet", SafetyItem.Helmet::new);
		SAFETY_CHESTPLATE = REGISTRY.register("safety_chestplate", SafetyItem.Chestplate::new);
		SAFETY_LEGGINGS = REGISTRY.register("safety_leggings", SafetyItem.Leggings::new);
		SAFETY_BOOTS = REGISTRY.register("safety_boots", SafetyItem.Boots::new);
		INDUSTRIAL_FURNACE_BRICK = block(ImmersionInTrafficContextModBlocks.INDUSTRIAL_FURNACE_BRICK, new Item.Properties().rarity(Rarity.RARE));
		INDUSTRIAL_FURNACE_TANK = block(ImmersionInTrafficContextModBlocks.INDUSTRIAL_FURNACE_TANK, new Item.Properties().rarity(Rarity.RARE).fireResistant());
		INDUSTRIAL_FURNACE_USER_MANUAL = REGISTRY.register("industrial_furnace_user_manual", IndustrialFurnaceUserManualItem::new);
		ETHYLENE_BUCKET = REGISTRY.register("ethylene_bucket", EthyleneItem::new);
		SALT = REGISTRY.register("salt", SaltItem::new);
		ELECTRODE = REGISTRY.register("electrode", ElectrodeItem::new);
		SOLID_PETROLEUM = block(ImmersionInTrafficContextModBlocks.SOLID_PETROLEUM);
		SIGNAL_BARREL = block(ImmersionInTrafficContextModBlocks.SIGNAL_BARREL);
		CANNED_FISH = REGISTRY.register("canned_fish", CannedFishItem::new);
		CANNED_FISH_MAIN = REGISTRY.register("canned_fish_main", CannedFishMainItem::new);
		SPRING_ONION_SEEDS = REGISTRY.register("spring_onion_seeds", SpringOnionSeedsItem::new);
		SCALLION_MAIN = REGISTRY.register("scallion_main", ScallionMainItem::new);
		TRAFFIC_LIGHTS = block(ImmersionInTrafficContextModBlocks.TRAFFIC_LIGHTS, new Item.Properties().rarity(Rarity.RARE));
		TRAFFIC_SIGNAL_POLE_I = block(ImmersionInTrafficContextModBlocks.TRAFFIC_SIGNAL_POLE_I);
		TRAFFIC_SIGNAL_POLE_II = block(ImmersionInTrafficContextModBlocks.TRAFFIC_SIGNAL_POLE_II);
		TRAFFIC_SIGNAL_POLE_I_AND_II = block(ImmersionInTrafficContextModBlocks.TRAFFIC_SIGNAL_POLE_I_AND_II);
		SIMPLE_CIRCUIT_COMPONENTS = REGISTRY.register("simple_circuit_components", SimpleCircuitComponentsItem::new);
		WHITE_CONCRETE_HALF_BRICK = block(ImmersionInTrafficContextModBlocks.WHITE_CONCRETE_HALF_BRICK);
		WRENCH = REGISTRY.register("wrench", WrenchItem::new);
	}

	// Start of user code block custom items
	// End of user code block custom items
	@SubscribeEvent
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerItem(Capabilities.ItemHandler.ITEM, (stack, context) -> new RoadEngineeringInventoryCapability(stack), ROAD_ENGINEERING.get());
		event.registerItem(Capabilities.ItemHandler.ITEM, (stack, context) -> new IndustrialFurnaceUserManualInventoryCapability(stack), INDUSTRIAL_FURNACE_USER_MANUAL.get());
		event.registerItem(Capabilities.FluidHandler.ITEM, (stack, context) -> new FluidBucketWrapper(stack), ETHYLENE_BUCKET.get());
		event.registerItem(Capabilities.FluidHandler.ITEM, (stack, context) -> new FluidBucketWrapper(stack), LIQUID_BITUMEN_BUCKET.get());
		event.registerItem(Capabilities.FluidHandler.ITEM, (stack, context) -> new FluidBucketWrapper(stack), PETROLEUM_BUCKET.get());
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return block(block, new Item.Properties());
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block, Item.Properties properties) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), properties));
	}
}