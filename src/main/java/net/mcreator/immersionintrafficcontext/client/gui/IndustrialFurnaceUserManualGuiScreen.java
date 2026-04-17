package net.mcreator.immersionintrafficcontext.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.immersionintrafficcontext.world.inventory.IndustrialFurnaceUserManualGuiMenu;
import net.mcreator.immersionintrafficcontext.init.ImmersionInTrafficContextModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class IndustrialFurnaceUserManualGuiScreen extends AbstractContainerScreen<IndustrialFurnaceUserManualGuiMenu> implements ImmersionInTrafficContextModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;

	public IndustrialFurnaceUserManualGuiScreen(IndustrialFurnaceUserManualGuiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 270;
		this.imageHeight = 198;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/industrial_furnace_user_manual_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		guiGraphics.blit(ResourceLocation.parse("immersion_in_traffic_context:textures/screens/ping_mu_jie_tu__2026-04-06_150610.png"), this.leftPos + 6, this.topPos + 40, 0, 0, 257, 153, 257, 153);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.immersion_in_traffic_context.industrial_furnace_user_manual_gui.label_industrial_furnace_user_manual"), 56, 3, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.immersion_in_traffic_context.industrial_furnace_user_manual_gui.label_arrange_as_shown_above_must_be"), 26, 19, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.immersion_in_traffic_context.industrial_furnace_user_manual_gui.label_to_activate"), 102, 28, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
	}
}