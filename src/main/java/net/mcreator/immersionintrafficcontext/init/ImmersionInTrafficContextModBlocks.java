/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.immersionintrafficcontext.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.Block;

import net.mcreator.immersionintrafficcontext.block.*;
import net.mcreator.immersionintrafficcontext.ImmersionInTrafficContextMod;

public class ImmersionInTrafficContextModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(ImmersionInTrafficContextMod.MODID);
	public static final DeferredBlock<Block> PETROLEUM;
	public static final DeferredBlock<Block> ASPHALT_MIXING_PLANT;
	public static final DeferredBlock<Block> ROUGH_ASPHALT_BLOCK;
	public static final DeferredBlock<Block> ASPHALT_ROAD_BLOCK;
	public static final DeferredBlock<Block> WHITE_ZEBRA_CROSSING;
	public static final DeferredBlock<Block> JUNCTION_1;
	public static final DeferredBlock<Block> JUNCTION_2;
	public static final DeferredBlock<Block> JUNCTION_3;
	public static final DeferredBlock<Block> ASPHALT_ROAD_BLOCK_ILLUMINATION_LIGHT;
	public static final DeferredBlock<Block> BITUMINOUS_ORE;
	public static final DeferredBlock<Block> DUAL_YELLOW_ZEBRA_CROSSING;
	public static final DeferredBlock<Block> LEFT_TURN_ASPHALT_PAVEMENT_BLOCK;
	public static final DeferredBlock<Block> YELLOW_ZEBRA_CROSSING;
	public static final DeferredBlock<Block> STRAIGHT_AHEAD_ASPHALT_PAVEMENT_BLOCK;
	public static final DeferredBlock<Block> RIGHT_TURN_ASPHALT_PAVEMENT_BLOCK;
	public static final DeferredBlock<Block> ASPHALT_PAVEMENT_BLOCKS_FOR_LEFT_AND_RIGHT_TURNS;
	public static final DeferredBlock<Block> STRAIGHT_AHEAD_AND_LEFT_TURN_ASPHALT_PAVEMENT_BLOCK;
	public static final DeferredBlock<Block> STRAIGHT_AHEAD_AND_RIGHT_TURN_ASPHALT_PAVEMENT_BLOCK;
	public static final DeferredBlock<Block> U_TURN_ASPHALT_PAVEMENT_BLOCK;
	public static final DeferredBlock<Block> IRON_DRAWER_CABINET;
	public static final DeferredBlock<Block> LIQUID_BITUMEN;
	public static final DeferredBlock<Block> HOT_1;
	public static final DeferredBlock<Block> INCLINED_WHITE_CONCRETE_HALF_BRICK;
	public static final DeferredBlock<Block> WHITE_CONCRETE_STONE_PILLAR;
	public static final DeferredBlock<Block> GRAY_CONCRETE_STONE_PILLAR;
	public static final DeferredBlock<Block> INCLINED_GRAY_CONCRETE_HALF_BRICK;
	public static final DeferredBlock<Block> INDUSTRIAL_FURNACE;
	public static final DeferredBlock<Block> INDUSTRIAL_FURNACE_BRICK;
	public static final DeferredBlock<Block> INDUSTRIAL_FURNACE_TANK;
	public static final DeferredBlock<Block> ETHYLENE;
	public static final DeferredBlock<Block> INDUSTRIAL_CAPSICUM;
	public static final DeferredBlock<Block> INDUSTRIAL_CAPSICUM_MAIN;
	public static final DeferredBlock<Block> SOLID_PETROLEUM;
	public static final DeferredBlock<Block> SIGNAL_BARREL;
	public static final DeferredBlock<Block> CANNED_FISH_BLOCK;
	public static final DeferredBlock<Block> SCALLION;
	public static final DeferredBlock<Block> SCALLION_2;
	public static final DeferredBlock<Block> SCALLION_1;
	public static final DeferredBlock<Block> TRAFFIC_LIGHTS;
	public static final DeferredBlock<Block> TRAFFIC_SIGNAL_POLE_I;
	public static final DeferredBlock<Block> TRAFFIC_SIGNAL_POLE_II;
	public static final DeferredBlock<Block> TRAFFIC_SIGNAL_POLE_I_AND_II;
	public static final DeferredBlock<Block> WHITE_CONCRETE_HALF_BRICK;
	static {
		PETROLEUM = REGISTRY.register("petroleum", PetroleumBlock::new);
		ASPHALT_MIXING_PLANT = REGISTRY.register("asphalt_mixing_plant", AsphaltMixingPlantBlock::new);
		ROUGH_ASPHALT_BLOCK = REGISTRY.register("rough_asphalt_block", RoughAsphaltBlockBlock::new);
		ASPHALT_ROAD_BLOCK = REGISTRY.register("asphalt_road_block", AsphaltRoadBlockBlock::new);
		WHITE_ZEBRA_CROSSING = REGISTRY.register("white_zebra_crossing", WhiteZebraCrossingBlock::new);
		JUNCTION_1 = REGISTRY.register("junction_1", Junction1Block::new);
		JUNCTION_2 = REGISTRY.register("junction_2", Junction2Block::new);
		JUNCTION_3 = REGISTRY.register("junction_3", Junction3Block::new);
		ASPHALT_ROAD_BLOCK_ILLUMINATION_LIGHT = REGISTRY.register("asphalt_road_block_illumination_light", AsphaltRoadBlockIlluminationLightBlock::new);
		BITUMINOUS_ORE = REGISTRY.register("bituminous_ore", BituminousOreBlock::new);
		DUAL_YELLOW_ZEBRA_CROSSING = REGISTRY.register("dual_yellow_zebra_crossing", DualYellowZebraCrossingBlock::new);
		LEFT_TURN_ASPHALT_PAVEMENT_BLOCK = REGISTRY.register("left_turn_asphalt_pavement_block", LeftTurnAsphaltPavementBlockBlock::new);
		YELLOW_ZEBRA_CROSSING = REGISTRY.register("yellow_zebra_crossing", YellowZebraCrossingBlock::new);
		STRAIGHT_AHEAD_ASPHALT_PAVEMENT_BLOCK = REGISTRY.register("straight_ahead_asphalt_pavement_block", StraightAheadAsphaltPavementBlockBlock::new);
		RIGHT_TURN_ASPHALT_PAVEMENT_BLOCK = REGISTRY.register("right_turn_asphalt_pavement_block", RightTurnAsphaltPavementBlockBlock::new);
		ASPHALT_PAVEMENT_BLOCKS_FOR_LEFT_AND_RIGHT_TURNS = REGISTRY.register("asphalt_pavement_blocks_for_left_and_right_turns", AsphaltPavementBlocksForLeftAndRightTurnsBlock::new);
		STRAIGHT_AHEAD_AND_LEFT_TURN_ASPHALT_PAVEMENT_BLOCK = REGISTRY.register("straight_ahead_and_left_turn_asphalt_pavement_block", StraightAheadAndLeftTurnAsphaltPavementBlockBlock::new);
		STRAIGHT_AHEAD_AND_RIGHT_TURN_ASPHALT_PAVEMENT_BLOCK = REGISTRY.register("straight_ahead_and_right_turn_asphalt_pavement_block", StraightAheadAndRightTurnAsphaltPavementBlockBlock::new);
		U_TURN_ASPHALT_PAVEMENT_BLOCK = REGISTRY.register("u_turn_asphalt_pavement_block", UTurnAsphaltPavementBlockBlock::new);
		IRON_DRAWER_CABINET = REGISTRY.register("iron_drawer_cabinet", IronDrawerCabinetBlock::new);
		LIQUID_BITUMEN = REGISTRY.register("liquid_bitumen", LiquidBitumenBlock::new);
		HOT_1 = REGISTRY.register("hot_1", Hot1Block::new);
		INCLINED_WHITE_CONCRETE_HALF_BRICK = REGISTRY.register("inclined_white_concrete_half_brick", InclinedWhiteConcreteHalfBrickBlock::new);
		WHITE_CONCRETE_STONE_PILLAR = REGISTRY.register("white_concrete_stone_pillar", WhiteConcreteStonePillarBlock::new);
		GRAY_CONCRETE_STONE_PILLAR = REGISTRY.register("gray_concrete_stone_pillar", GrayConcreteStonePillarBlock::new);
		INCLINED_GRAY_CONCRETE_HALF_BRICK = REGISTRY.register("inclined_gray_concrete_half_brick", InclinedGrayConcreteHalfBrickBlock::new);
		INDUSTRIAL_FURNACE = REGISTRY.register("industrial_furnace", IndustrialFurnaceBlock::new);
		INDUSTRIAL_FURNACE_BRICK = REGISTRY.register("industrial_furnace_brick", IndustrialFurnaceBrickBlock::new);
		INDUSTRIAL_FURNACE_TANK = REGISTRY.register("industrial_furnace_tank", IndustrialFurnaceTankBlock::new);
		ETHYLENE = REGISTRY.register("ethylene", EthyleneBlock::new);
		INDUSTRIAL_CAPSICUM = REGISTRY.register("industrial_capsicum", IndustrialCapsicumBlock::new);
		INDUSTRIAL_CAPSICUM_MAIN = REGISTRY.register("industrial_capsicum_main", IndustrialCapsicumMainBlock::new);
		SOLID_PETROLEUM = REGISTRY.register("solid_petroleum", SolidPetroleumBlock::new);
		SIGNAL_BARREL = REGISTRY.register("signal_barrel", SignalBarrelBlock::new);
		CANNED_FISH_BLOCK = REGISTRY.register("canned_fish_block", CannedFishBlockBlock::new);
		SCALLION = REGISTRY.register("scallion", ScallionBlock::new);
		SCALLION_2 = REGISTRY.register("scallion_2", Scallion2Block::new);
		SCALLION_1 = REGISTRY.register("scallion_1", Scallion1Block::new);
		TRAFFIC_LIGHTS = REGISTRY.register("traffic_lights", TrafficLightsBlock::new);
		TRAFFIC_SIGNAL_POLE_I = REGISTRY.register("traffic_signal_pole_i", TrafficSignalPoleIBlock::new);
		TRAFFIC_SIGNAL_POLE_II = REGISTRY.register("traffic_signal_pole_ii", TrafficSignalPoleIIBlock::new);
		TRAFFIC_SIGNAL_POLE_I_AND_II = REGISTRY.register("traffic_signal_pole_i_and_ii", TrafficSignalPoleIAndIIBlock::new);
		WHITE_CONCRETE_HALF_BRICK = REGISTRY.register("white_concrete_half_brick", WhiteConcreteHalfBrickBlock::new);
	}
	// Start of user code block custom blocks
	// End of user code block custom blocks
}