/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.immersionintrafficcontext.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;
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

import java.util.function.Function;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class ImmersionInTrafficContextModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(ImmersionInTrafficContextMod.MODID);
	public static final DeferredItem<Item> PETROLEUM_BUCKET = register("petroleum_bucket", PetroleumItem::new);
	public static final DeferredItem<Item> WASTE = register("waste", WasteItem::new);
	public static final DeferredItem<Item> ASPHALT = register("asphalt", AsphaltItem::new);
	public static final DeferredItem<Item> HAMMER = register("hammer", HammerItem::new);
	public static final DeferredItem<Item> ASPHALT_MIXING_PLANT = block(ImmersionInTrafficContextModBlocks.ASPHALT_MIXING_PLANT);
	public static final DeferredItem<Item> REDSTONELEDTUBE = register("redstoneledtube", RedstoneledtubeItem::new);
	public static final DeferredItem<Item> ROUGH_ASPHALT_BLOCK = block(ImmersionInTrafficContextModBlocks.ROUGH_ASPHALT_BLOCK);
	public static final DeferredItem<Item> ASPHALT_ROAD_BLOCK = block(ImmersionInTrafficContextModBlocks.ASPHALT_ROAD_BLOCK);
	public static final DeferredItem<Item> WHITE_ZEBRA_CROSSING = block(ImmersionInTrafficContextModBlocks.WHITE_ZEBRA_CROSSING);
	public static final DeferredItem<Item> TEST_TUBE = register("test_tube", TestTubeItem::new);
	public static final DeferredItem<Item> PETROLEUM_IN_A_SMALL_BOTTLE = register("petroleum_in_a_small_bottle", PetroleumInASmallBottleItem::new);
	public static final DeferredItem<Item> JUNCTION_1 = block(ImmersionInTrafficContextModBlocks.JUNCTION_1);
	public static final DeferredItem<Item> JUNCTION_2 = block(ImmersionInTrafficContextModBlocks.JUNCTION_2);
	public static final DeferredItem<Item> JUNCTION_3 = block(ImmersionInTrafficContextModBlocks.JUNCTION_3);
	public static final DeferredItem<Item> ASPHALT_ROAD_BLOCK_ILLUMINATION_LIGHT = block(ImmersionInTrafficContextModBlocks.ASPHALT_ROAD_BLOCK_ILLUMINATION_LIGHT);
	public static final DeferredItem<Item> BITUMINOUS_ORE = block(ImmersionInTrafficContextModBlocks.BITUMINOUS_ORE);
	public static final DeferredItem<Item> ROAD_ENGINEERING = register("road_engineering", RoadEngineeringItem::new);
	public static final DeferredItem<Item> DUAL_YELLOW_ZEBRA_CROSSING = block(ImmersionInTrafficContextModBlocks.DUAL_YELLOW_ZEBRA_CROSSING);
	public static final DeferredItem<Item> LEFT_TURN_ASPHALT_PAVEMENT_BLOCK = block(ImmersionInTrafficContextModBlocks.LEFT_TURN_ASPHALT_PAVEMENT_BLOCK);
	public static final DeferredItem<Item> YELLOW_ZEBRA_CROSSING = block(ImmersionInTrafficContextModBlocks.YELLOW_ZEBRA_CROSSING);
	public static final DeferredItem<Item> STRAIGHT_AHEAD_ASPHALT_PAVEMENT_BLOCK = block(ImmersionInTrafficContextModBlocks.STRAIGHT_AHEAD_ASPHALT_PAVEMENT_BLOCK);
	public static final DeferredItem<Item> RIGHT_TURN_ASPHALT_PAVEMENT_BLOCK = block(ImmersionInTrafficContextModBlocks.RIGHT_TURN_ASPHALT_PAVEMENT_BLOCK);
	public static final DeferredItem<Item> ASPHALT_PAVEMENT_BLOCKS_FOR_LEFT_AND_RIGHT_TURNS = block(ImmersionInTrafficContextModBlocks.ASPHALT_PAVEMENT_BLOCKS_FOR_LEFT_AND_RIGHT_TURNS);
	public static final DeferredItem<Item> STRAIGHT_AHEAD_AND_LEFT_TURN_ASPHALT_PAVEMENT_BLOCK = block(ImmersionInTrafficContextModBlocks.STRAIGHT_AHEAD_AND_LEFT_TURN_ASPHALT_PAVEMENT_BLOCK);
	public static final DeferredItem<Item> STRAIGHT_AHEAD_AND_RIGHT_TURN_ASPHALT_PAVEMENT_BLOCK = block(ImmersionInTrafficContextModBlocks.STRAIGHT_AHEAD_AND_RIGHT_TURN_ASPHALT_PAVEMENT_BLOCK);
	public static final DeferredItem<Item> U_TURN_ASPHALT_PAVEMENT_BLOCK = block(ImmersionInTrafficContextModBlocks.U_TURN_ASPHALT_PAVEMENT_BLOCK);
	public static final DeferredItem<Item> IRON_DRAWER_CABINET = block(ImmersionInTrafficContextModBlocks.IRON_DRAWER_CABINET);
	public static final DeferredItem<Item> LIQUID_BITUMEN_BUCKET = register("liquid_bitumen_bucket", LiquidBitumenItem::new);
	public static final DeferredItem<Item> HOT_1 = block(ImmersionInTrafficContextModBlocks.HOT_1, new Item.Properties().stacksTo(1));
	public static final DeferredItem<Item> JGBKVHDMDRSJUDGJUPLSWQWQEZBNNJYJRWQWOI = block(ImmersionInTrafficContextModBlocks.JGBKVHDMDRSJUDGJUPLSWQWQEZBNNJYJRWQWOI);
	public static final DeferredItem<Item> INCLINED_WHITE_CONCRETE_HALF_BRICK = block(ImmersionInTrafficContextModBlocks.INCLINED_WHITE_CONCRETE_HALF_BRICK);
	public static final DeferredItem<Item> WHITE_CONCRETE_STONE_PILLAR = block(ImmersionInTrafficContextModBlocks.WHITE_CONCRETE_STONE_PILLAR);
	public static final DeferredItem<Item> GRAY_CONCRETE_STONE_PILLAR = block(ImmersionInTrafficContextModBlocks.GRAY_CONCRETE_STONE_PILLAR);
	public static final DeferredItem<Item> INCLINED_GRAY_CONCRETE_HALF_BRICK = block(ImmersionInTrafficContextModBlocks.INCLINED_GRAY_CONCRETE_HALF_BRICK);
	public static final DeferredItem<Item> ROAD_LINE_REMOVAL_SPRAY = register("road_line_removal_spray", RoadLineRemovalSprayItem::new);
	public static final DeferredItem<Item> INDUSTRIAL_CAPSICUM = block(ImmersionInTrafficContextModBlocks.INDUSTRIAL_CAPSICUM);
	public static final DeferredItem<Item> INDUSTRIAL_CAPSICUM_1 = register("industrial_capsicum_1", IndustrialCapsicum1Item::new);
	public static final DeferredItem<Item> IRON_CAN = register("iron_can", IronCanItem::new);
	public static final DeferredItem<Item> INDUSTRIAL_FURNACE = block(ImmersionInTrafficContextModBlocks.INDUSTRIAL_FURNACE);
	public static final DeferredItem<Item> MOULD = register("mould", MouldItem::new);
	public static final DeferredItem<Item> PLASTIC_INGOT = register("plastic_ingot", PlasticIngotItem::new);
	public static final DeferredItem<Item> SAFETY_HELMET = register("safety_helmet", SafetyItem.Helmet::new);
	public static final DeferredItem<Item> SAFETY_CHESTPLATE = register("safety_chestplate", SafetyItem.Chestplate::new);
	public static final DeferredItem<Item> SAFETY_LEGGINGS = register("safety_leggings", SafetyItem.Leggings::new);
	public static final DeferredItem<Item> SAFETY_BOOTS = register("safety_boots", SafetyItem.Boots::new);
	public static final DeferredItem<Item> INDUSTRIAL_FURNACE_BRICK = block(ImmersionInTrafficContextModBlocks.INDUSTRIAL_FURNACE_BRICK, new Item.Properties().rarity(Rarity.RARE));
	public static final DeferredItem<Item> INDUSTRIAL_FURNACE_TANK = block(ImmersionInTrafficContextModBlocks.INDUSTRIAL_FURNACE_TANK, new Item.Properties().rarity(Rarity.RARE).fireResistant());
	public static final DeferredItem<Item> INDUSTRIAL_FURNACE_USER_MANUAL = register("industrial_furnace_user_manual", IndustrialFurnaceUserManualItem::new);
	public static final DeferredItem<Item> ETHYLENE_BUCKET = register("ethylene_bucket", EthyleneItem::new);
	public static final DeferredItem<Item> SALT = register("salt", SaltItem::new);
	public static final DeferredItem<Item> ELECTRODE = register("electrode", ElectrodeItem::new);

	// Start of user code block custom items
	// End of user code block custom items
	private static <I extends Item> DeferredItem<I> register(String name, Function<Item.Properties, ? extends I> supplier) {
		return REGISTRY.registerItem(name, supplier, new Item.Properties());
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return block(block, new Item.Properties());
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block, Item.Properties properties) {
		return REGISTRY.registerItem(block.getId().getPath(), prop -> new BlockItem(block.get(), prop), properties);
	}

	@SubscribeEvent
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerItem(Capabilities.ItemHandler.ITEM, (stack, context) -> new RoadEngineeringInventoryCapability(stack), ROAD_ENGINEERING.get());
		event.registerItem(Capabilities.ItemHandler.ITEM, (stack, context) -> new IndustrialFurnaceUserManualInventoryCapability(stack), INDUSTRIAL_FURNACE_USER_MANUAL.get());
	}
}