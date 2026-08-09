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

import net.mcreator.immersionintrafficcontext.world.inventory.Itc1Menu;
import net.mcreator.immersionintrafficcontext.network.Itc1ButtonMessage;
import net.mcreator.immersionintrafficcontext.init.ImmersionInTrafficContextModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class Itc1Screen extends AbstractContainerScreen<Itc1Menu> implements ImmersionInTrafficContextModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_bb1;
	private static final ResourceLocation BACKGROUND = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/itc_1.png");
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/itc2.png");

	public Itc1Screen(Itc1Menu container, Inventory inventory, Component text) {
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
		guiGraphics.blit(IMAGE_0, this.leftPos + -58, this.topPos + -14, 0, 0, 292, 184, 292, 184);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.immersion_in_traffic_context.itc_1.label_project_source_code"), 105, 28, -16777156, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.immersion_in_traffic_context.itc_1.label_httpsgithubcomyuxuangzsim"), 105, 41, -5585920, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.immersion_in_traffic_context.itc_1.label_itc_use_the_gnu_v3"), 107, 6, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.immersion_in_traffic_context.itc_1.label_open_source_license"), 107, 16, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.immersion_in_traffic_context.itc_1.label_yuxuangzsimmersionintrafficcon"), 105, 51, -5585920, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.immersion_in_traffic_context.itc_1.label_intrafficcontext"), 104, 61, -5585920, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.immersion_in_traffic_context.itc_1.label_donation_links"), 106, 74, -44758, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.immersion_in_traffic_context.itc_1.label_httpsifdiannetayuxuan_z100"), 106, 84, -12796644, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.immersion_in_traffic_context.itc_1.label_ayuxuan_z100t_itc"), 107, 93, -12796644, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.immersion_in_traffic_context.itc_1.label_back"), -37, 10, -16777156, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_bb1 = new ImageButton(this.leftPos + -42, this.topPos + 8, 100, 16,
				new WidgetSprites(ResourceLocation.parse("immersion_in_traffic_context:textures/screens/bb1.png"), ResourceLocation.parse("immersion_in_traffic_context:textures/screens/bb2.png")), e -> {
					int x = Itc1Screen.this.x;
					int y = Itc1Screen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new Itc1ButtonMessage(0, x, y, z));
						Itc1ButtonMessage.handleButtonAction(entity, 0, x, y, z);
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