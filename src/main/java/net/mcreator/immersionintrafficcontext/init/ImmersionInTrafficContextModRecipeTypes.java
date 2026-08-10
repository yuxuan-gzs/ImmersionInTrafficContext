package net.mcreator.immersionintrafficcontext.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.fml.event.lifecycle.FMLConstructModEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.ModList;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.IEventBus;

import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.immersionintrafficcontext.jei_recipes.Jei1Recipe;

@EventBusSubscriber
public class ImmersionInTrafficContextModRecipeTypes {
	public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(BuiltInRegistries.RECIPE_TYPE, "immersion_in_traffic_context");
	public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(BuiltInRegistries.RECIPE_SERIALIZER, "immersion_in_traffic_context");

	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		IEventBus bus = ModList.get().getModContainerById("immersion_in_traffic_context").get().getEventBus();
		event.enqueueWork(() -> {
			RECIPE_TYPES.register(bus);
			SERIALIZERS.register(bus);
			RECIPE_TYPES.register("jei_1", () -> Jei1Recipe.Type.INSTANCE);
			SERIALIZERS.register("jei_1", () -> Jei1Recipe.Serializer.INSTANCE);
		});
	}
}