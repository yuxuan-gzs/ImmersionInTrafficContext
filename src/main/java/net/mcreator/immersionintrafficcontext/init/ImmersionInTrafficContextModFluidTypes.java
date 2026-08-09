/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.immersionintrafficcontext.init;

import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.fluids.FluidType;

import net.mcreator.immersionintrafficcontext.fluid.types.PetroleumFluidType;
import net.mcreator.immersionintrafficcontext.fluid.types.LiquidBitumenFluidType;
import net.mcreator.immersionintrafficcontext.fluid.types.EthyleneFluidType;
import net.mcreator.immersionintrafficcontext.ImmersionInTrafficContextMod;

public class ImmersionInTrafficContextModFluidTypes {
	public static final DeferredRegister<FluidType> REGISTRY = DeferredRegister.create(NeoForgeRegistries.FLUID_TYPES, ImmersionInTrafficContextMod.MODID);
	public static final DeferredHolder<FluidType, FluidType> PETROLEUM_TYPE = REGISTRY.register("petroleum", PetroleumFluidType::new);
	public static final DeferredHolder<FluidType, FluidType> LIQUID_BITUMEN_TYPE = REGISTRY.register("liquid_bitumen", LiquidBitumenFluidType::new);
	public static final DeferredHolder<FluidType, FluidType> ETHYLENE_TYPE = REGISTRY.register("ethylene", EthyleneFluidType::new);
}