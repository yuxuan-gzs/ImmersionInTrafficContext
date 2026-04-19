/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.immersionintrafficcontext.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;

import net.mcreator.immersionintrafficcontext.fluid.PetroleumFluid;
import net.mcreator.immersionintrafficcontext.fluid.LiquidBitumenFluid;
import net.mcreator.immersionintrafficcontext.fluid.EthyleneFluid;
import net.mcreator.immersionintrafficcontext.ImmersionInTrafficContextMod;

public class ImmersionInTrafficContextModFluids {
	public static final DeferredRegister<Fluid> REGISTRY = DeferredRegister.create(BuiltInRegistries.FLUID, ImmersionInTrafficContextMod.MODID);
	public static final DeferredHolder<Fluid, FlowingFluid> PETROLEUM = REGISTRY.register("petroleum", () -> new PetroleumFluid.Source());
	public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_PETROLEUM = REGISTRY.register("flowing_petroleum", () -> new PetroleumFluid.Flowing());
	public static final DeferredHolder<Fluid, FlowingFluid> LIQUID_BITUMEN = REGISTRY.register("liquid_bitumen", () -> new LiquidBitumenFluid.Source());
	public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_LIQUID_BITUMEN = REGISTRY.register("flowing_liquid_bitumen", () -> new LiquidBitumenFluid.Flowing());
	public static final DeferredHolder<Fluid, FlowingFluid> ETHYLENE = REGISTRY.register("ethylene", () -> new EthyleneFluid.Source());
	public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_ETHYLENE = REGISTRY.register("flowing_ethylene", () -> new EthyleneFluid.Flowing());

	@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class FluidsClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			ItemBlockRenderTypes.setRenderLayer(PETROLEUM.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_PETROLEUM.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(LIQUID_BITUMEN.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_LIQUID_BITUMEN.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(ETHYLENE.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_ETHYLENE.get(), RenderType.translucent());
		}
	}
}