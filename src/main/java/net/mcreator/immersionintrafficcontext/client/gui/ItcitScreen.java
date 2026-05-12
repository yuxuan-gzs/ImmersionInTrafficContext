package net.mcreator.immersionintrafficcontext.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.immersionintrafficcontext.world.inventory.ItcitMenu;
import net.mcreator.immersionintrafficcontext.procedures.*;
import net.mcreator.immersionintrafficcontext.init.ImmersionInTrafficContextModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class ItcitScreen extends AbstractContainerScreen<ItcitMenu> implements ImmersionInTrafficContextModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;

	public ItcitScreen(ItcitMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/itcit.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		boolean customTooltipShown = false;
		if (mouseX > leftPos + 62 && mouseX < leftPos + 86 && mouseY > topPos + 48 && mouseY < topPos + 72) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.immersion_in_traffic_context.itcit.tooltip_coal"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 56 && mouseX < leftPos + 80 && mouseY > topPos + 1 && mouseY < topPos + 25) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.immersion_in_traffic_context.itcit.tooltip_hammer"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (!customTooltipShown)
			this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		guiGraphics.blit(ResourceLocation.parse("immersion_in_traffic_context:textures/screens/rx8.png"), this.leftPos + 67, this.topPos + 34, 0, 0, 14, 14, 14, 14);
		guiGraphics.blit(ResourceLocation.parse("immersion_in_traffic_context:textures/screens/itc_it0.png"), this.leftPos + 107, this.topPos + 34, 0, 0, 10, 8, 10, 8);
		guiGraphics.blit(ResourceLocation.parse("immersion_in_traffic_context:textures/screens/itc_itc0.png"), this.leftPos + 60, this.topPos + 18, 0, 0, 25, 16, 25, 16);
		if (Itcit1Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("immersion_in_traffic_context:textures/screens/itc_itc0_1.png"), this.leftPos + 60, this.topPos + 18, 0, 0, 25, 16, 25, 16);
		}
		if (Itcit2Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("immersion_in_traffic_context:textures/screens/itc_itc0_9.png"), this.leftPos + 60, this.topPos + 18, 0, 0, 25, 16, 25, 16);
		}
		if (Itcit3Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("immersion_in_traffic_context:textures/screens/itc_itc1.png"), this.leftPos + 60, this.topPos + 18, 0, 0, 25, 16, 25, 16);
		}
		if (Itcit4Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("immersion_in_traffic_context:textures/screens/itc_itc2.png"), this.leftPos + 60, this.topPos + 18, 0, 0, 25, 16, 25, 16);
		}
		if (Itcit5Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("immersion_in_traffic_context:textures/screens/itc_itc3.png"), this.leftPos + 60, this.topPos + 18, 0, 0, 25, 16, 25, 16);
		}
		if (Itcit6Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("immersion_in_traffic_context:textures/screens/itc_itc4.png"), this.leftPos + 60, this.topPos + 18, 0, 0, 25, 16, 25, 16);
		}
		if (Itcit7Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("immersion_in_traffic_context:textures/screens/itc_itc5.png"), this.leftPos + 60, this.topPos + 18, 0, 0, 25, 16, 25, 16);
		}
		if (Itcit8Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("immersion_in_traffic_context:textures/screens/itc_itc6.png"), this.leftPos + 60, this.topPos + 18, 0, 0, 25, 16, 25, 16);
		}
		if (Itcit9Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("immersion_in_traffic_context:textures/screens/itc_itc7.png"), this.leftPos + 60, this.topPos + 18, 0, 0, 25, 16, 25, 16);
		}
		if (Itcit10Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("immersion_in_traffic_context:textures/screens/itc_itc8.png"), this.leftPos + 60, this.topPos + 18, 0, 0, 25, 16, 25, 16);
		}
		if (Itcit11Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("immersion_in_traffic_context:textures/screens/itc_itc9.png"), this.leftPos + 60, this.topPos + 18, 0, 0, 25, 16, 25, 16);
		}
		if (Itcit12Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("immersion_in_traffic_context:textures/screens/itc_itc10.png"), this.leftPos + 60, this.topPos + 18, 0, 0, 25, 16, 25, 16);
		}
		if (Itcit13Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("immersion_in_traffic_context:textures/screens/itc_itc11.png"), this.leftPos + 60, this.topPos + 18, 0, 0, 25, 16, 25, 16);
		}
		if (Itcit14Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("immersion_in_traffic_context:textures/screens/itc_itc12.png"), this.leftPos + 60, this.topPos + 18, 0, 0, 25, 16, 25, 16);
		}
		if (Itcit15Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("immersion_in_traffic_context:textures/screens/itc_itc13.png"), this.leftPos + 60, this.topPos + 18, 0, 0, 25, 16, 25, 16);
		}
		if (Itcit16Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("immersion_in_traffic_context:textures/screens/itc_itc14.png"), this.leftPos + 61, this.topPos + 18, 0, 0, 25, 16, 25, 16);
		}
		if (Itcit17Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("immersion_in_traffic_context:textures/screens/itc_itc16.png"), this.leftPos + 60, this.topPos + 18, 0, 0, 25, 16, 25, 16);
		}
		if (Itcit18Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("immersion_in_traffic_context:textures/screens/itc_itc17.png"), this.leftPos + 60, this.topPos + 18, 0, 0, 25, 16, 25, 16);
		}
		if (Itcit19Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("immersion_in_traffic_context:textures/screens/itc_itc18.png"), this.leftPos + 60, this.topPos + 18, 0, 0, 25, 16, 25, 16);
		}
		if (Itcit20Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("immersion_in_traffic_context:textures/screens/itc_itc19.png"), this.leftPos + 60, this.topPos + 18, 0, 0, 25, 16, 25, 16);
		}
		if (Itcit21Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("immersion_in_traffic_context:textures/screens/itc_itc20.png"), this.leftPos + 60, this.topPos + 18, 0, 0, 25, 16, 25, 16);
		}
		if (Itcit22Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("immersion_in_traffic_context:textures/screens/itc_itc21.png"), this.leftPos + 60, this.topPos + 18, 0, 0, 25, 16, 25, 16);
		}
		if (Itcit23Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("immersion_in_traffic_context:textures/screens/itc_itc22.png"), this.leftPos + 60, this.topPos + 18, 0, 0, 25, 16, 25, 16);
		}
		if (Itcit24Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("immersion_in_traffic_context:textures/screens/itc_itc23.png"), this.leftPos + 60, this.topPos + 18, 0, 0, 25, 16, 25, 16);
		}
		if (Itcit25Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("immersion_in_traffic_context:textures/screens/itc_itc24.png"), this.leftPos + 60, this.topPos + 18, 0, 0, 25, 16, 25, 16);
		}
		guiGraphics.blit(ResourceLocation.parse("immersion_in_traffic_context:textures/screens/957.png"), this.leftPos + 67, this.topPos + 50, 0, 0, 128, 128, 128, 128);
		if (Itcite1Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("immersion_in_traffic_context:textures/screens/rx1.png"), this.leftPos + 67, this.topPos + 34, 0, 0, 14, 14, 14, 14);
		}
		if (Itcite2Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("immersion_in_traffic_context:textures/screens/rx2.png"), this.leftPos + 67, this.topPos + 34, 0, 0, 14, 14, 14, 14);
		}
		if (Itcite3Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("immersion_in_traffic_context:textures/screens/rx3.png"), this.leftPos + 67, this.topPos + 34, 0, 0, 14, 14, 14, 14);
		}
		if (Itcite4Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("immersion_in_traffic_context:textures/screens/rx4.png"), this.leftPos + 67, this.topPos + 34, 0, 0, 14, 14, 14, 14);
		}
		if (Itcite5Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("immersion_in_traffic_context:textures/screens/rx5.png"), this.leftPos + 67, this.topPos + 34, 0, 0, 14, 14, 14, 14);
		}
		if (Itcite6Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("immersion_in_traffic_context:textures/screens/rx6.png"), this.leftPos + 67, this.topPos + 34, 0, 0, 14, 14, 14, 14);
		}
		if (Itcite7Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("immersion_in_traffic_context:textures/screens/rx7.png"), this.leftPos + 67, this.topPos + 34, 0, 0, 14, 14, 14, 14);
		}
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
	}

	@Override
	public void init() {
		super.init();
	}
}