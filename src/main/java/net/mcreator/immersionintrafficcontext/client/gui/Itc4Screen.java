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

import net.mcreator.immersionintrafficcontext.world.inventory.Itc4Menu;
import net.mcreator.immersionintrafficcontext.network.Itc4ButtonMessage;
import net.mcreator.immersionintrafficcontext.init.ImmersionInTrafficContextModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class Itc4Screen extends AbstractContainerScreen<Itc4Menu> implements ImmersionInTrafficContextModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_bb2;
	private static final ResourceLocation BACKGROUND = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/itc_4.png");
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/itc2.png");

	public Itc4Screen(Itc4Menu container, Inventory inventory, Component text) {
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
		guiGraphics.blit(IMAGE_0, this.leftPos + -58, this.topPos + -18, 0, 0, 292, 184, 292, 184);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.immersion_in_traffic_context.itc_4.label_back"), -45, -4, -16777172, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.immersion_in_traffic_context.itc_4.label_how_to_configure_traffic_lights"), 97, -10, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.immersion_in_traffic_context.itc_4.label_traffic_lights"), 140, 0, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.immersion_in_traffic_context.itc_4.label_you_may_not_be_able_to_open_the"), 97, 17, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.immersion_in_traffic_context.itc_4.label_to_open_the_traffic_lights_confi"), 98, 56, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.immersion_in_traffic_context.itc_4.label_open_the_configuration"), 97, 26, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.immersion_in_traffic_context.itc_4.label_interface_for"), 97, 36, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.immersion_in_traffic_context.itc_4.label_traffic_lights1"), 142, 45, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.immersion_in_traffic_context.itc_4.label_lights_configuration"), 98, 66, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.immersion_in_traffic_context.itc_4.label_interface_hold_a_hammer"), 98, 76, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.immersion_in_traffic_context.itc_4.label_and_rightclick"), 100, 86, -16777216, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_bb2 = new ImageButton(this.leftPos + -47, this.topPos + -6, 100, 16,
				new WidgetSprites(ResourceLocation.parse("immersion_in_traffic_context:textures/screens/bb1.png"), ResourceLocation.parse("immersion_in_traffic_context:textures/screens/bb2.png")), e -> {
					int x = Itc4Screen.this.x;
					int y = Itc4Screen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new Itc4ButtonMessage(0, x, y, z));
						Itc4ButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_bb2);
	}
}