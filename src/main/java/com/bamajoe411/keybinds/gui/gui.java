package com.bamajoe411.keybinds.gui;

import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WButton;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WLabel;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.LiteralText;

public class gui extends LightweightGuiDescription {
    public gui() {
        WGridPanel root = new WGridPanel();
        setRootPanel(root);
        root.setSize(126, 32);

        WLabel homeLabel = new WLabel("Vanilla High Teleports:", 1);
        root.add(homeLabel, 0, 0);

        WButton homeButton = new WButton(new LiteralText("Home"));
        root.add(homeButton, 4, 1, 2, 1);
        homeButton.setOnClick(() -> {
            MinecraftClient.getInstance().player.sendChatMessage("/trigger cmd set 3");
            MinecraftClient.getInstance().openScreen(null);
        });

        WButton spawnButton = new WButton(new LiteralText("Spawn"));
        root.add(spawnButton, 1, 1, 2, 1);
        spawnButton.setOnClick(() -> {
            MinecraftClient.getInstance().player.sendChatMessage("/trigger cmd set 1");
            MinecraftClient.getInstance().openScreen(null);
        });
    }
}
