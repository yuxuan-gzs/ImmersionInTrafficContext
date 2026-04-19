package net.mcreator.immersionintrafficcontext.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.immersionintrafficcontext.world.inventory.A1Menu;
import net.mcreator.immersionintrafficcontext.procedures.*;
import net.mcreator.immersionintrafficcontext.init.ImmersionInTrafficContextModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class A1Screen extends AbstractContainerScreen<A1Menu> implements ImmersionInTrafficContextModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;

	public A1Screen(A1Menu container, Inventory inventory, Component text) {
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

	private static final ResourceLocation texture = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/a_1.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		boolean customTooltipShown = false;
		if (mouseX > leftPos + 46 && mouseX < leftPos + 70 && mouseY > topPos + 4 && mouseY < topPos + 28) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.immersion_in_traffic_context.a_1.tooltip_when_making_do_not_exit_this_pa"), mouseX, mouseY);
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
		guiGraphics.blit(RenderType::guiTextured, texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		guiGraphics.blit(RenderType::guiTextured, ResourceLocation.parse("immersion_in_traffic_context:textures/screens/mi1.png"), this.leftPos + 74, this.topPos + 39, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(RenderType::guiTextured, ResourceLocation.parse("immersion_in_traffic_context:textures/screens/957.png"), this.leftPos + 28, this.topPos + 49, 0, 0, 128, 128, 128, 128);
		guiGraphics.blit(RenderType::guiTextured, ResourceLocation.parse("immersion_in_traffic_context:textures/screens/33.png"), this.leftPos + 48, this.topPos + 22, 0, 0, 70, 16, 70, 16);
		if (AA1Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderType::guiTextured, ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m1.png"), this.leftPos + 48, this.topPos + 21, 0, 0, 5, 16, 5, 16);
		}
		if (AA2Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderType::guiTextured, ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m2.png"), this.leftPos + 48, this.topPos + 21, 0, 0, 5, 16, 5, 16);
		}
		if (AA3Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderType::guiTextured, ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m3.png"), this.leftPos + 48, this.topPos + 21, 0, 0, 5, 16, 5, 16);
		}
		if (AA4Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderType::guiTextured, ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m4.png"), this.leftPos + 48, this.topPos + 21, 0, 0, 5, 16, 5, 16);
		}
		if (AA5Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderType::guiTextured, ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m5.png"), this.leftPos + 48, this.topPos + 21, 0, 0, 10, 16, 10, 16);
		}
		if (AA6Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderType::guiTextured, ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m6.png"), this.leftPos + 48, this.topPos + 21, 0, 0, 10, 16, 10, 16);
		}
		if (AA7Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderType::guiTextured, ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m7.png"), this.leftPos + 48, this.topPos + 21, 0, 0, 10, 16, 10, 16);
		}
		if (AA8Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderType::guiTextured, ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m8.png"), this.leftPos + 48, this.topPos + 21, 0, 0, 10, 16, 10, 16);
		}
		if (AA9Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderType::guiTextured, ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m9.png"), this.leftPos + 48, this.topPos + 21, 0, 0, 10, 16, 10, 16);
		}
		if (AA10Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderType::guiTextured, ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m10.png"), this.leftPos + 48, this.topPos + 21, 0, 0, 15, 16, 15, 16);
		}
		if (AA11Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderType::guiTextured, ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m11.png"), this.leftPos + 48, this.topPos + 21, 0, 0, 15, 16, 15, 16);
		}
		if (AA12Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderType::guiTextured, ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m12.png"), this.leftPos + 48, this.topPos + 21, 0, 0, 15, 16, 15, 16);
		}
		if (AA13Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderType::guiTextured, ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m13.png"), this.leftPos + 48, this.topPos + 21, 0, 0, 15, 16, 15, 16);
		}
		if (AA14Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderType::guiTextured, ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m14.png"), this.leftPos + 48, this.topPos + 21, 0, 0, 15, 16, 15, 16);
		}
		if (AA15Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderType::guiTextured, ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m15.png"), this.leftPos + 48, this.topPos + 21, 0, 0, 20, 16, 20, 16);
		}
		if (AA16Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderType::guiTextured, ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m16.png"), this.leftPos + 48, this.topPos + 21, 0, 0, 20, 16, 20, 16);
		}
		if (AA17Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderType::guiTextured, ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m17.png"), this.leftPos + 48, this.topPos + 21, 0, 0, 20, 16, 20, 16);
		}
		if (AA18Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderType::guiTextured, ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m18.png"), this.leftPos + 48, this.topPos + 21, 0, 0, 20, 16, 20, 16);
		}
		if (AA19Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderType::guiTextured, ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m19.png"), this.leftPos + 48, this.topPos + 21, 0, 0, 20, 16, 20, 16);
		}
		if (AA20Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderType::guiTextured, ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m20.png"), this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA21Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderType::guiTextured, ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m21.png"), this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA22Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderType::guiTextured, ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m22.png"), this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA23Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderType::guiTextured, ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m23.png"), this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA24Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderType::guiTextured, ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m24.png"), this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA25Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderType::guiTextured, ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m25.png"), this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA26Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderType::guiTextured, ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m26.png"), this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA27Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderType::guiTextured, ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m27.png"), this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA28Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderType::guiTextured, ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m28.png"), this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA29Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderType::guiTextured, ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m29.png"), this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA30Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderType::guiTextured, ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m30.png"), this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA31Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderType::guiTextured, ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m31.png"), this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA32Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderType::guiTextured, ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m32.png"), this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA33Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderType::guiTextured, ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m33.png"), this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA34Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderType::guiTextured, ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m34.png"), this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA35Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderType::guiTextured, ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m35.png"), this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA36Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderType::guiTextured, ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m36.png"), this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA37Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderType::guiTextured, ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m37.png"), this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA38Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderType::guiTextured, ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m38.png"), this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA39Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderType::guiTextured, ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m39.png"), this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA40Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderType::guiTextured, ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m40.png"), this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA41Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderType::guiTextured, ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m41.png"), this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA42Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderType::guiTextured, ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m42.png"), this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA43Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderType::guiTextured, ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m43.png"), this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA44Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderType::guiTextured, ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m44.png"), this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA45Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderType::guiTextured, ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m45.png"), this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA46Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderType::guiTextured, ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m46.png"), this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA47Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderType::guiTextured, ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m47.png"), this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA48Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderType::guiTextured, ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m48.png"), this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA49Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderType::guiTextured, ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m49.png"), this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA50Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderType::guiTextured, ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m50.png"), this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA51Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderType::guiTextured, ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m51.png"), this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA52Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderType::guiTextured, ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m52.png"), this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA53Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderType::guiTextured, ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m53.png"), this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA54Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderType::guiTextured, ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m54.png"), this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA55Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderType::guiTextured, ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m55.png"), this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA56Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderType::guiTextured, ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m56.png"), this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA57Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderType::guiTextured, ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m57.png"), this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA58Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderType::guiTextured, ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m58.png"), this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA59Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderType::guiTextured, ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m59.png"), this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA60Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderType::guiTextured, ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m60.png"), this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA61Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderType::guiTextured, ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m61.png"), this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA62Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderType::guiTextured, ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m62.png"), this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA63Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderType::guiTextured, ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m63.png"), this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA64Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderType::guiTextured, ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m64.png"), this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA65Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderType::guiTextured, ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m65.png"), this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA66Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderType::guiTextured, ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m66.png"), this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA67Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderType::guiTextured, ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m67.png"), this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA68Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderType::guiTextured, ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m68.png"), this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		guiGraphics.blit(RenderType::guiTextured, ResourceLocation.parse("immersion_in_traffic_context:textures/screens/mfk.png"), this.leftPos + 50, this.topPos + 7, 0, 0, 16, 16, 16, 16);
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