package net.mcreator.immersionintrafficcontext.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
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
	private static final ResourceLocation BACKGROUND = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/a_1.png");
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/mi1.png");
	private static final ResourceLocation IMAGE_1 = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/957.png");
	private static final ResourceLocation IMAGE_2 = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/33.png");
	private static final ResourceLocation IMAGE_3 = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m1.png");
	private static final ResourceLocation IMAGE_4 = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m2.png");
	private static final ResourceLocation IMAGE_5 = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m3.png");
	private static final ResourceLocation IMAGE_6 = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m4.png");
	private static final ResourceLocation IMAGE_7 = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m5.png");
	private static final ResourceLocation IMAGE_8 = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m6.png");
	private static final ResourceLocation IMAGE_9 = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m7.png");
	private static final ResourceLocation IMAGE_10 = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m8.png");
	private static final ResourceLocation IMAGE_11 = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m9.png");
	private static final ResourceLocation IMAGE_12 = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m10.png");
	private static final ResourceLocation IMAGE_13 = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m11.png");
	private static final ResourceLocation IMAGE_14 = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m12.png");
	private static final ResourceLocation IMAGE_15 = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m13.png");
	private static final ResourceLocation IMAGE_16 = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m14.png");
	private static final ResourceLocation IMAGE_17 = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m15.png");
	private static final ResourceLocation IMAGE_18 = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m16.png");
	private static final ResourceLocation IMAGE_19 = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m17.png");
	private static final ResourceLocation IMAGE_20 = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m18.png");
	private static final ResourceLocation IMAGE_21 = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m19.png");
	private static final ResourceLocation IMAGE_22 = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m20.png");
	private static final ResourceLocation IMAGE_23 = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m21.png");
	private static final ResourceLocation IMAGE_24 = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m22.png");
	private static final ResourceLocation IMAGE_25 = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m23.png");
	private static final ResourceLocation IMAGE_26 = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m24.png");
	private static final ResourceLocation IMAGE_27 = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m25.png");
	private static final ResourceLocation IMAGE_28 = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m26.png");
	private static final ResourceLocation IMAGE_29 = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m27.png");
	private static final ResourceLocation IMAGE_30 = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m28.png");
	private static final ResourceLocation IMAGE_31 = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m29.png");
	private static final ResourceLocation IMAGE_32 = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m30.png");
	private static final ResourceLocation IMAGE_33 = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m31.png");
	private static final ResourceLocation IMAGE_34 = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m32.png");
	private static final ResourceLocation IMAGE_35 = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m33.png");
	private static final ResourceLocation IMAGE_36 = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m34.png");
	private static final ResourceLocation IMAGE_37 = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m35.png");
	private static final ResourceLocation IMAGE_38 = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m36.png");
	private static final ResourceLocation IMAGE_39 = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m37.png");
	private static final ResourceLocation IMAGE_40 = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m38.png");
	private static final ResourceLocation IMAGE_41 = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m39.png");
	private static final ResourceLocation IMAGE_42 = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m40.png");
	private static final ResourceLocation IMAGE_43 = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m41.png");
	private static final ResourceLocation IMAGE_44 = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m42.png");
	private static final ResourceLocation IMAGE_45 = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m43.png");
	private static final ResourceLocation IMAGE_46 = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m44.png");
	private static final ResourceLocation IMAGE_47 = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m45.png");
	private static final ResourceLocation IMAGE_48 = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m46.png");
	private static final ResourceLocation IMAGE_49 = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m47.png");
	private static final ResourceLocation IMAGE_50 = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m48.png");
	private static final ResourceLocation IMAGE_51 = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m49.png");
	private static final ResourceLocation IMAGE_52 = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m50.png");
	private static final ResourceLocation IMAGE_53 = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m51.png");
	private static final ResourceLocation IMAGE_54 = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m52.png");
	private static final ResourceLocation IMAGE_55 = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m53.png");
	private static final ResourceLocation IMAGE_56 = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m54.png");
	private static final ResourceLocation IMAGE_57 = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m55.png");
	private static final ResourceLocation IMAGE_58 = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m56.png");
	private static final ResourceLocation IMAGE_59 = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m57.png");
	private static final ResourceLocation IMAGE_60 = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m58.png");
	private static final ResourceLocation IMAGE_61 = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m59.png");
	private static final ResourceLocation IMAGE_62 = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m60.png");
	private static final ResourceLocation IMAGE_63 = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m61.png");
	private static final ResourceLocation IMAGE_64 = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m62.png");
	private static final ResourceLocation IMAGE_65 = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m63.png");
	private static final ResourceLocation IMAGE_66 = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m64.png");
	private static final ResourceLocation IMAGE_67 = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m65.png");
	private static final ResourceLocation IMAGE_68 = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m66.png");
	private static final ResourceLocation IMAGE_69 = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m67.png");
	private static final ResourceLocation IMAGE_70 = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/m68.png");

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
		guiGraphics.blit(BACKGROUND, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		guiGraphics.blit(IMAGE_0, this.leftPos + 74, this.topPos + 39, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(IMAGE_1, this.leftPos + 28, this.topPos + 49, 0, 0, 128, 128, 128, 128);
		guiGraphics.blit(IMAGE_2, this.leftPos + 48, this.topPos + 22, 0, 0, 70, 16, 70, 16);
		if (AA1Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_3, this.leftPos + 48, this.topPos + 21, 0, 0, 5, 16, 5, 16);
		}
		if (AA2Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_4, this.leftPos + 48, this.topPos + 21, 0, 0, 5, 16, 5, 16);
		}
		if (AA3Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_5, this.leftPos + 48, this.topPos + 21, 0, 0, 5, 16, 5, 16);
		}
		if (AA4Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_6, this.leftPos + 48, this.topPos + 21, 0, 0, 5, 16, 5, 16);
		}
		if (AA5Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_7, this.leftPos + 48, this.topPos + 21, 0, 0, 10, 16, 10, 16);
		}
		if (AA6Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_8, this.leftPos + 48, this.topPos + 21, 0, 0, 10, 16, 10, 16);
		}
		if (AA7Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_9, this.leftPos + 48, this.topPos + 21, 0, 0, 10, 16, 10, 16);
		}
		if (AA8Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_10, this.leftPos + 48, this.topPos + 21, 0, 0, 10, 16, 10, 16);
		}
		if (AA9Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_11, this.leftPos + 48, this.topPos + 21, 0, 0, 10, 16, 10, 16);
		}
		if (AA10Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_12, this.leftPos + 48, this.topPos + 21, 0, 0, 15, 16, 15, 16);
		}
		if (AA11Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_13, this.leftPos + 48, this.topPos + 21, 0, 0, 15, 16, 15, 16);
		}
		if (AA12Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_14, this.leftPos + 48, this.topPos + 21, 0, 0, 15, 16, 15, 16);
		}
		if (AA13Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_15, this.leftPos + 48, this.topPos + 21, 0, 0, 15, 16, 15, 16);
		}
		if (AA14Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_16, this.leftPos + 48, this.topPos + 21, 0, 0, 15, 16, 15, 16);
		}
		if (AA15Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_17, this.leftPos + 48, this.topPos + 21, 0, 0, 20, 16, 20, 16);
		}
		if (AA16Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_18, this.leftPos + 48, this.topPos + 21, 0, 0, 20, 16, 20, 16);
		}
		if (AA17Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_19, this.leftPos + 48, this.topPos + 21, 0, 0, 20, 16, 20, 16);
		}
		if (AA18Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_20, this.leftPos + 48, this.topPos + 21, 0, 0, 20, 16, 20, 16);
		}
		if (AA19Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_21, this.leftPos + 48, this.topPos + 21, 0, 0, 20, 16, 20, 16);
		}
		if (AA20Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_22, this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA21Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_23, this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA22Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_24, this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA23Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_25, this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA24Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_26, this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA25Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_27, this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA26Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_28, this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA27Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_29, this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA28Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_30, this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA29Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_31, this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA30Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_32, this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA31Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_33, this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA32Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_34, this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA33Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_35, this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA34Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_36, this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA35Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_37, this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA36Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_38, this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA37Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_39, this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA38Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_40, this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA39Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_41, this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA40Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_42, this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA41Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_43, this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA42Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_44, this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA43Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_45, this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA44Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_46, this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA45Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_47, this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA46Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_48, this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA47Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_49, this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA48Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_50, this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA49Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_51, this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA50Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_52, this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA51Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_53, this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA52Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_54, this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA53Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_55, this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA54Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_56, this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA55Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_57, this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA56Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_58, this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA57Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_59, this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA58Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_60, this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA59Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_61, this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA60Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_62, this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA61Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_63, this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA62Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_64, this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA63Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_65, this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA64Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_66, this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA65Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_67, this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA66Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_68, this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA67Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_69, this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
		}
		if (AA68Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(IMAGE_70, this.leftPos + 48, this.topPos + 21, 0, 0, 70, 16, 70, 16);
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