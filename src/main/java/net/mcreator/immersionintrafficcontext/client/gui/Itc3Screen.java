package net.mcreator.immersionintrafficcontext.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.immersionintrafficcontext.world.inventory.Itc3Menu;
import net.mcreator.immersionintrafficcontext.network.Itc3ButtonMessage;
import net.mcreator.immersionintrafficcontext.init.ImmersionInTrafficContextModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class Itc3Screen extends AbstractContainerScreen<Itc3Menu> implements ImmersionInTrafficContextModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_bb1;
	private static final ResourceLocation BACKGROUND = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/itc_3.png");
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/itc2.png");
	private static final ResourceLocation IMAGE_1 = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/2026-07-16_13.21.54.png");
	private static final ResourceLocation IMAGE_2 = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/2026-07-16_13.23.05.png");

	public Itc3Screen(Itc3Menu container, Inventory inventory, Component text) {
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
		guiGraphics.blit(IMAGE_0, this.leftPos + -58, this.topPos + -17, 0, 0, 292, 184, 292, 184);
		guiGraphics.blit(IMAGE_1, this.leftPos + 52, this.topPos + 40, 0, 0, 213, 120, 213, 120);
		guiGraphics.blit(IMAGE_2, this.leftPos + -82, this.topPos + 22, 0, 0, 213, 120, 213, 120);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.immersion_in_traffic_context.itc_3.label_back"), -43, 1, -16777172, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.immersion_in_traffic_context.itc_3.label_industrial_furnace_has_a_3x3_str"), 102, -4, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.immersion_in_traffic_context.itc_3.label_after_placing_a_tank"), 102, 15, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.immersion_in_traffic_context.itc_3.label_at_the_center_and_a"), 102, 24, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.immersion_in_traffic_context.itc_3.label_main_unit_on_any"), 102, 33, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.immersion_in_traffic_context.itc_3.label_it_becomes_operational"), 102, 43, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.immersion_in_traffic_context.itc_3.label_a_3x3x3_structure"), 102, 5, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_bb1 = new ImageButton(this.leftPos + -47, this.topPos + -1, 100, 16,
				new WidgetSprites(ResourceLocation.parse("immersion_in_traffic_context:textures/screens/bb1.png"), ResourceLocation.parse("immersion_in_traffic_context:textures/screens/bb2.png")), e -> {
					int x = Itc3Screen.this.x;
					int y = Itc3Screen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new Itc3ButtonMessage(0, x, y, z));
						Itc3ButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_bb1);
	}
}