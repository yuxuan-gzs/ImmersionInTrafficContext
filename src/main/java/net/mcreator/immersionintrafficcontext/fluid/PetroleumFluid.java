package net.mcreator.immersionintrafficcontext.fluid;

import net.neoforged.neoforge.fluids.BaseFlowingFluid;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.ParticleOptions;

import net.mcreator.immersionintrafficcontext.init.ImmersionInTrafficContextModItems;
import net.mcreator.immersionintrafficcontext.init.ImmersionInTrafficContextModFluids;
import net.mcreator.immersionintrafficcontext.init.ImmersionInTrafficContextModFluidTypes;
import net.mcreator.immersionintrafficcontext.init.ImmersionInTrafficContextModBlocks;

public abstract class PetroleumFluid extends BaseFlowingFluid {
	public static final BaseFlowingFluid.Properties PROPERTIES = new BaseFlowingFluid.Properties(() -> ImmersionInTrafficContextModFluidTypes.PETROLEUM_TYPE.get(), () -> ImmersionInTrafficContextModFluids.PETROLEUM.get(),
			() -> ImmersionInTrafficContextModFluids.FLOWING_PETROLEUM.get()).explosionResistance(100f).tickRate(12).slopeFindDistance(12).bucket(() -> ImmersionInTrafficContextModItems.PETROLEUM_BUCKET.get())
			.block(() -> (LiquidBlock) ImmersionInTrafficContextModBlocks.PETROLEUM.get());

	private PetroleumFluid() {
		super(PROPERTIES);
	}

	@Override
	public ParticleOptions getDripParticle() {
		return ParticleTypes.ASH;
	}

	public static class Source extends PetroleumFluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends PetroleumFluid {
		protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
			super.createFluidStateDefinition(builder);
			builder.add(LEVEL);
		}

		public int getAmount(FluidState state) {
			return state.getValue(LEVEL);
		}

		public boolean isSource(FluidState state) {
			return false;
		}
	}
}