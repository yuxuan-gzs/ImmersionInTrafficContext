package net.mcreator.immersionintrafficcontext.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.Minecraft;

import net.mcreator.immersionintrafficcontext.world.inventory.ITCMenu;
import net.mcreator.immersionintrafficcontext.procedures.Ci2Procedure;
import net.mcreator.immersionintrafficcontext.procedures.Ci1Procedure;
import net.mcreator.immersionintrafficcontext.init.ImmersionInTrafficContextModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class ITCScreen extends AbstractContainerScreen<ITCMenu> implements ImmersionInTrafficContextModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private EditBox pagination;
	private ImageButton imagebutton_bb1;

	public ITCScreen(ITCMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 146;
		this.imageHeight = 184;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		if (elementType == 0 && elementState instanceof String stringState) {
			if (name.equals("pagination"))
				pagination.setValue(stringState);
		}
		menuStateUpdateActive = false;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/itc.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		pagination.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		if (Ci2Procedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("immersion_in_traffic_context:textures/screens/itc2.png"), this.leftPos + -67, this.topPos + 0, 0, 0, 292, 184, 292, 184);
		}
		if (Ci1Procedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("immersion_in_traffic_context:textures/screens/itc1.png"), this.leftPos + 0, this.topPos + 0, 0, 0, 146, 184, 146, 184);
		}
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (pagination.isFocused())
			return pagination.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String paginationValue = pagination.getValue();
		super.resize(minecraft, width, height);
		pagination.setValue(paginationValue);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		if (Ci1Procedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.immersion_in_traffic_context.itc.label_immersion_in_traffic_context"), 20, 10, -16777216, false);
		if (Ci1Procedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.immersion_in_traffic_context.itc.label_context"), 54, 21, -16777216, false);
		if (Ci1Procedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.immersion_in_traffic_context.itc.label_crafting_recipe"), 45, 42, -16777172, false);
	}

	@Override
	public void init() {
		super.init();
		pagination = new EditBox(this.font, this.leftPos + 244, this.topPos + 191, 38, 18, Component.translatable("gui.immersion_in_traffic_context.itc.pagination"));
		pagination.setMaxLength(8192);
		pagination.setResponder(content -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 0, "pagination", content, false);
		});
		pagination.setHint(Component.translatable("gui.immersion_in_traffic_context.itc.pagination"));
		this.addWidget(this.pagination);
		imagebutton_bb1 = new ImageButton(this.leftPos + 38, this.topPos + 39, 100, 16,
				new WidgetSprites(ResourceLocation.parse("immersion_in_traffic_context:textures/screens/bb1.png"), ResourceLocation.parse("immersion_in_traffic_context:textures/screens/bb2.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = ITCScreen.this.x;
				int y = ITCScreen.this.y;
				if (Ci1Procedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_bb1);
	}
}