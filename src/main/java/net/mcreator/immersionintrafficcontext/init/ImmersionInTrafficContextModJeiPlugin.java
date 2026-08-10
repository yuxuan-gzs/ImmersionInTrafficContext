package net.mcreator.immersionintrafficcontext.init;

import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.Minecraft;

import net.mcreator.immersionintrafficcontext.jei_recipes.Jei1RecipeCategory;
import net.mcreator.immersionintrafficcontext.jei_recipes.Jei1Recipe;

import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.IModPlugin;

import java.util.stream.Collectors;
import java.util.Objects;
import java.util.List;

@JeiPlugin
public class ImmersionInTrafficContextModJeiPlugin implements IModPlugin {
	public static mezz.jei.api.recipe.RecipeType<Jei1Recipe> Jei1_Type = new mezz.jei.api.recipe.RecipeType<>(Jei1RecipeCategory.UID, Jei1Recipe.class);

	@Override
	public ResourceLocation getPluginUid() {
		return ResourceLocation.parse("immersion_in_traffic_context:jei_plugin");
	}

	@Override
	public void registerCategories(IRecipeCategoryRegistration registration) {
		registration.addRecipeCategories(new Jei1RecipeCategory(registration.getJeiHelpers().getGuiHelper()));
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		RecipeManager recipeManager = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
		List<Jei1Recipe> Jei1Recipes = recipeManager.getAllRecipesFor(Jei1Recipe.Type.INSTANCE).stream().map(RecipeHolder::value).collect(Collectors.toList());
		registration.addRecipes(Jei1_Type, Jei1Recipes);
	}

	@Override
	public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
		registration.addRecipeCatalyst(new ItemStack(ImmersionInTrafficContextModBlocks.INDUSTRIAL_FURNACE.get().asItem()), Jei1_Type);
	}
}