package net.mcreator.immersionintrafficcontext.init;

import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.Minecraft;

import net.mcreator.immersionintrafficcontext.jei_recipes.*;

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
	public static mezz.jei.api.recipe.RecipeType<Jei2Recipe> Jei2_Type = new mezz.jei.api.recipe.RecipeType<>(Jei2RecipeCategory.UID, Jei2Recipe.class);
	public static mezz.jei.api.recipe.RecipeType<Jei3Recipe> Jei3_Type = new mezz.jei.api.recipe.RecipeType<>(Jei3RecipeCategory.UID, Jei3Recipe.class);
	public static mezz.jei.api.recipe.RecipeType<Jei4Recipe> Jei4_Type = new mezz.jei.api.recipe.RecipeType<>(Jei4RecipeCategory.UID, Jei4Recipe.class);

	@Override
	public ResourceLocation getPluginUid() {
		return ResourceLocation.parse("immersion_in_traffic_context:jei_plugin");
	}

	@Override
	public void registerCategories(IRecipeCategoryRegistration registration) {
		registration.addRecipeCategories(new Jei1RecipeCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new Jei2RecipeCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new Jei3RecipeCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new Jei4RecipeCategory(registration.getJeiHelpers().getGuiHelper()));
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		RecipeManager recipeManager = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
		List<Jei1Recipe> Jei1Recipes = recipeManager.getAllRecipesFor(Jei1Recipe.Type.INSTANCE).stream().map(RecipeHolder::value).collect(Collectors.toList());
		registration.addRecipes(Jei1_Type, Jei1Recipes);
		List<Jei2Recipe> Jei2Recipes = recipeManager.getAllRecipesFor(Jei2Recipe.Type.INSTANCE).stream().map(RecipeHolder::value).collect(Collectors.toList());
		registration.addRecipes(Jei2_Type, Jei2Recipes);
		List<Jei3Recipe> Jei3Recipes = recipeManager.getAllRecipesFor(Jei3Recipe.Type.INSTANCE).stream().map(RecipeHolder::value).collect(Collectors.toList());
		registration.addRecipes(Jei3_Type, Jei3Recipes);
		List<Jei4Recipe> Jei4Recipes = recipeManager.getAllRecipesFor(Jei4Recipe.Type.INSTANCE).stream().map(RecipeHolder::value).collect(Collectors.toList());
		registration.addRecipes(Jei4_Type, Jei4Recipes);
	}

	@Override
	public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
		registration.addRecipeCatalyst(new ItemStack(ImmersionInTrafficContextModBlocks.INDUSTRIAL_FURNACE.get().asItem()), Jei1_Type);
		registration.addRecipeCatalyst(new ItemStack(ImmersionInTrafficContextModBlocks.INDUSTRIAL_FURNACE.get().asItem()), Jei2_Type);
		registration.addRecipeCatalyst(new ItemStack(ImmersionInTrafficContextModBlocks.INDUSTRIAL_FURNACE.get().asItem()), Jei3_Type);
		registration.addRecipeCatalyst(new ItemStack(ImmersionInTrafficContextModBlocks.ASPHALT_MIXING_PLANT.get().asItem()), Jei4_Type);
	}
}