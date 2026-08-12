package net.mcreator.immersionintrafficcontext.jei_recipes;

import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.NonNullList;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.Minecraft;

import net.mcreator.immersionintrafficcontext.init.ImmersionInTrafficContextModJeiPlugin;
import net.mcreator.immersionintrafficcontext.init.ImmersionInTrafficContextModItems;

import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.constants.VanillaTypes;

import java.util.List;
import java.util.ArrayList;

public class Jei3RecipeCategory implements IRecipeCategory<Jei3Recipe> {
	public final static ResourceLocation UID = ResourceLocation.parse("immersion_in_traffic_context:jei_3");
	public final static ResourceLocation TEXTURE = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/jei_itcit.png");
	private final IDrawable background;
	private final IDrawable icon;
	private final Minecraft mc = Minecraft.getInstance();

	public Jei3RecipeCategory(IGuiHelper helper) {
		this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 76);
		this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ImmersionInTrafficContextModItems.LIQUID_BITUMEN_BUCKET.get()));
	}

	@Override
	public mezz.jei.api.recipe.RecipeType<Jei3Recipe> getRecipeType() {
		return ImmersionInTrafficContextModJeiPlugin.Jei3_Type;
	}

	@Override
	public Component getTitle() {
		return Component.literal("Industrial Furnace");
	}

	@Override
	public IDrawable getIcon() {
		return this.icon;
	}

	@Override
	public int getWidth() {
		return this.background.getWidth();
	}

	@Override
	public int getHeight() {
		return this.background.getHeight();
	}

	@Override
	public void draw(Jei3Recipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
		this.background.draw(guiGraphics);

	}

	@Override
	public void setRecipe(IRecipeLayoutBuilder builder, Jei3Recipe recipe, IFocusGroup focuses) {
		List<ItemStack> stacks = new ArrayList<>();
		List<ItemStack> recipeOutputs = recipe.getResultItems();
		List<ItemStack> actualOutputs = NonNullList.withSize(1, ItemStack.EMPTY);
		for (int i = 0; i < recipeOutputs.size(); i++) {
			actualOutputs.set(i, recipeOutputs.get(i));
		}
		stacks.clear();
		for (ItemStack item : (List<ItemStack>) List.of(recipe.getIngredients().get(0).getItems()))
			stacks.add(new ItemStack(item.getItem(), recipe.integers().get(0)));
		builder.addSlot(RecipeIngredientRole.INPUT, 6, 6).addItemStacks(stacks);
		stacks.clear();
		for (ItemStack item : (List<ItemStack>) List.of(recipe.getIngredients().get(1).getItems()))
			stacks.add(new ItemStack(item.getItem(), recipe.integers().get(1)));
		builder.addSlot(RecipeIngredientRole.INPUT, 59, 6).addItemStacks(stacks);
		stacks.clear();
		for (ItemStack item : (List<ItemStack>) List.of(recipe.getIngredients().get(2).getItems()))
			stacks.add(new ItemStack(item.getItem(), recipe.integers().get(2)));
		builder.addSlot(RecipeIngredientRole.INPUT, 89, 25).addItemStacks(stacks);
		stacks.clear();
		for (ItemStack item : (List<ItemStack>) List.of(recipe.getIngredients().get(3).getItems()))
			stacks.add(new ItemStack(item.getItem(), recipe.integers().get(3)));
		builder.addSlot(RecipeIngredientRole.INPUT, 67, 50).addItemStacks(stacks);
		builder.addSlot(RecipeIngredientRole.OUTPUT, 119, 6).addItemStack(actualOutputs.get(0));
	}
}