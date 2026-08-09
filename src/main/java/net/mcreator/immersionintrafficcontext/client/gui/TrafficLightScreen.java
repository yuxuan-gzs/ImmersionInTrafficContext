package net.mcreator.immersionintrafficcontext.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Checkbox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.Minecraft;

import net.mcreator.immersionintrafficcontext.world.inventory.TrafficLightMenu;
import net.mcreator.immersionintrafficcontext.procedures.YellProcedure;
import net.mcreator.immersionintrafficcontext.procedures.X0000x21Procedure;
import net.mcreator.immersionintrafficcontext.procedures.X0000x20Procedure;
import net.mcreator.immersionintrafficcontext.procedures.ShortcutProcedure;
import net.mcreator.immersionintrafficcontext.procedures.CustomProcedure;
import net.mcreator.immersionintrafficcontext.network.TrafficLightButtonMessage;
import net.mcreator.immersionintrafficcontext.init.ImmersionInTrafficContextModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class TrafficLightScreen extends AbstractContainerScreen<TrafficLightMenu> implements ImmersionInTrafficContextModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private EditBox lv;
	private EditBox red;
	private EditBox yell;
	private Checkbox yell_1;
	private Button button_last_30s;
	private Button button_first_30s;
	private Button button_custom;
	private Button button_empty;
	private Button button_empty1;
	private Button button_empty2;
	private Button button_empty3;
	private Button button_empty4;
	private Button button_empty5;
	private Button button_save_custom_settings;
	private static final ResourceLocation BACKGROUND = ResourceLocation.parse("immersion_in_traffic_context:textures/screens/traffic_light.png");

	public TrafficLightScreen(TrafficLightMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 168;
		this.imageHeight = 171;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		if (elementType == 0 && elementState instanceof String stringState) {
			if (name.equals("lv"))
				lv.setValue(stringState);
			else if (name.equals("red"))
				red.setValue(stringState);
			else if (name.equals("yell"))
				yell.setValue(stringState);
		}
		if (elementType == 1 && elementState instanceof Boolean logicState) {
			if (name.equals("yell_1")) {
				if (yell_1.selected() != logicState)
					yell_1.onPress();
			}
		}
		menuStateUpdateActive = false;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		lv.render(guiGraphics, mouseX, mouseY, partialTicks);
		red.render(guiGraphics, mouseX, mouseY, partialTicks);
		yell.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(BACKGROUND, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (lv.isFocused())
			return lv.keyPressed(key, b, c);
		if (red.isFocused())
			return red.keyPressed(key, b, c);
		if (yell.isFocused())
			return yell.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String lvValue = lv.getValue();
		String redValue = red.getValue();
		String yellValue = yell.getValue();
		super.resize(minecraft, width, height);
		lv.setValue(lvValue);
		red.setValue(redValue);
		yell.setValue(yellValue);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.immersion_in_traffic_context.traffic_light.label_select_time_period"), 32, 11, -16777216, false);
		if (X0000x20Procedure.execute(world, x, y, z))
			guiGraphics.drawString(this.font, Component.translatable("gui.immersion_in_traffic_context.traffic_light.label_empty"), 16, 54, -6750208, false);
		if (X0000x21Procedure.execute(world, x, y, z))
			guiGraphics.drawString(this.font, Component.translatable("gui.immersion_in_traffic_context.traffic_light.label_empty1"), 83, 54, -6750208, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.immersion_in_traffic_context.traffic_light.label_shortcut"), 8, 22, -16724992, false);
		if (ShortcutProcedure.execute(world, x, y, z))
			guiGraphics.drawString(this.font, Component.translatable("gui.immersion_in_traffic_context.traffic_light.label_empty2"), 53, 22, -16777063, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.immersion_in_traffic_context.traffic_light.label_custom"), 8, 65, -16724992, false);
		if (CustomProcedure.execute(world, x, y, z))
			guiGraphics.drawString(this.font, Component.translatable("gui.immersion_in_traffic_context.traffic_light.label_empty3"), 42, 66, -16777063, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.immersion_in_traffic_context.traffic_light.label_o"), 15, 90, -16724992, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.immersion_in_traffic_context.traffic_light.label_o1"), 15, 111, -3407872, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.immersion_in_traffic_context.traffic_light.label_o2"), 15, 131, -26368, false);
	}

	@Override
	public void init() {
		super.init();
		lv = new EditBox(this.font, this.leftPos + 46, this.topPos + 86, 76, 20, Component.translatable("gui.immersion_in_traffic_context.traffic_light.lv"));
		lv.setMaxLength(8192);
		lv.setResponder(content -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 0, "lv", content, false);
		});
		lv.setHint(Component.translatable("gui.immersion_in_traffic_context.traffic_light.lv"));
		this.addWidget(this.lv);
		red = new EditBox(this.font, this.leftPos + 46, this.topPos + 106, 76, 20, Component.translatable("gui.immersion_in_traffic_context.traffic_light.red"));
		red.setMaxLength(8192);
		red.setResponder(content -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 0, "red", content, false);
		});
		red.setHint(Component.translatable("gui.immersion_in_traffic_context.traffic_light.red"));
		this.addWidget(this.red);
		yell = new EditBox(this.font, this.leftPos + 46, this.topPos + 126, 57, 20, Component.translatable("gui.immersion_in_traffic_context.traffic_light.yell"));
		yell.setMaxLength(8192);
		yell.setResponder(content -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 0, "yell", content, false);
		});
		yell.setHint(Component.translatable("gui.immersion_in_traffic_context.traffic_light.yell"));
		this.addWidget(this.yell);
		button_last_30s = Button.builder(Component.translatable("gui.immersion_in_traffic_context.traffic_light.button_last_30s"), e -> {
			int x = TrafficLightScreen.this.x;
			int y = TrafficLightScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new TrafficLightButtonMessage(0, x, y, z));
				TrafficLightButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 87, this.topPos + 34, 63, 20).build();
		this.addRenderableWidget(button_last_30s);
		button_first_30s = Button.builder(Component.translatable("gui.immersion_in_traffic_context.traffic_light.button_first_30s"), e -> {
			int x = TrafficLightScreen.this.x;
			int y = TrafficLightScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new TrafficLightButtonMessage(1, x, y, z));
				TrafficLightButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 15, this.topPos + 34, 63, 20).build();
		this.addRenderableWidget(button_first_30s);
		button_custom = Button.builder(Component.translatable("gui.immersion_in_traffic_context.traffic_light.button_custom"), e -> {
			int x = TrafficLightScreen.this.x;
			int y = TrafficLightScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new TrafficLightButtonMessage(2, x, y, z));
				TrafficLightButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 88, this.topPos + 62, 55, 20).build();
		this.addRenderableWidget(button_custom);
		button_empty = Button.builder(Component.translatable("gui.immersion_in_traffic_context.traffic_light.button_empty"), e -> {
			int x = TrafficLightScreen.this.x;
			int y = TrafficLightScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new TrafficLightButtonMessage(3, x, y, z));
				TrafficLightButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}).bounds(this.leftPos + 25, this.topPos + 86, 21, 20).build();
		this.addRenderableWidget(button_empty);
		button_empty1 = Button.builder(Component.translatable("gui.immersion_in_traffic_context.traffic_light.button_empty1"), e -> {
			int x = TrafficLightScreen.this.x;
			int y = TrafficLightScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new TrafficLightButtonMessage(4, x, y, z));
				TrafficLightButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}).bounds(this.leftPos + 122, this.topPos + 86, 21, 20).build();
		this.addRenderableWidget(button_empty1);
		button_empty2 = Button.builder(Component.translatable("gui.immersion_in_traffic_context.traffic_light.button_empty2"), e -> {
			int x = TrafficLightScreen.this.x;
			int y = TrafficLightScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new TrafficLightButtonMessage(5, x, y, z));
				TrafficLightButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}).bounds(this.leftPos + 25, this.topPos + 106, 21, 20).build();
		this.addRenderableWidget(button_empty2);
		button_empty3 = Button.builder(Component.translatable("gui.immersion_in_traffic_context.traffic_light.button_empty3"), e -> {
			int x = TrafficLightScreen.this.x;
			int y = TrafficLightScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new TrafficLightButtonMessage(6, x, y, z));
				TrafficLightButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		}).bounds(this.leftPos + 122, this.topPos + 106, 21, 20).build();
		this.addRenderableWidget(button_empty3);
		button_empty4 = Button.builder(Component.translatable("gui.immersion_in_traffic_context.traffic_light.button_empty4"), e -> {
			int x = TrafficLightScreen.this.x;
			int y = TrafficLightScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new TrafficLightButtonMessage(7, x, y, z));
				TrafficLightButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		}).bounds(this.leftPos + 25, this.topPos + 126, 21, 20).build();
		this.addRenderableWidget(button_empty4);
		button_empty5 = Button.builder(Component.translatable("gui.immersion_in_traffic_context.traffic_light.button_empty5"), e -> {
			int x = TrafficLightScreen.this.x;
			int y = TrafficLightScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new TrafficLightButtonMessage(8, x, y, z));
				TrafficLightButtonMessage.handleButtonAction(entity, 8, x, y, z);
			}
		}).bounds(this.leftPos + 103, this.topPos + 126, 20, 20).build();
		this.addRenderableWidget(button_empty5);
		button_save_custom_settings = Button.builder(Component.translatable("gui.immersion_in_traffic_context.traffic_light.button_save_custom_settings"), e -> {
			int x = TrafficLightScreen.this.x;
			int y = TrafficLightScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new TrafficLightButtonMessage(9, x, y, z));
				TrafficLightButtonMessage.handleButtonAction(entity, 9, x, y, z);
			}
		}).bounds(this.leftPos + 15, this.topPos + 146, 128, 20).build();
		this.addRenderableWidget(button_save_custom_settings);
		boolean yell_1Selected = YellProcedure.execute(world, x, y, z);
		yell_1 = Checkbox.builder(Component.translatable("gui.immersion_in_traffic_context.traffic_light.yell_1"), this.font).pos(this.leftPos + 124, this.topPos + 127).onValueChange((checkbox, value) -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 1, "yell_1", value, false);
		}).selected(yell_1Selected).build();
		if (yell_1Selected)
			menu.sendMenuStateUpdate(entity, 1, "yell_1", true, false);
		this.addRenderableWidget(yell_1);
	}
}