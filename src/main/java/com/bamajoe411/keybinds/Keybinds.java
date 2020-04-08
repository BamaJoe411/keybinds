package com.bamajoe411.keybinds;

import com.bamajoe411.keybinds.gui.gui;
import com.bamajoe411.keybinds.gui.screen;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.keybinding.FabricKeyBinding;
import net.fabricmc.fabric.api.client.keybinding.KeyBindingRegistry;
import net.fabricmc.fabric.api.event.client.ClientTickCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.InputUtil;
import net.minecraft.util.Identifier;
import org.lwjgl.glfw.GLFW;

import java.util.concurrent.atomic.AtomicBoolean;

public class Keybinds implements ModInitializer{
    private static FabricKeyBinding keyBinding;

    @Override
    public void onInitialize() {
        KeyBindingRegistry.INSTANCE.addCategory("Vanilla High");
        // gui_key
        FabricKeyBinding gui_key = FabricKeyBinding.Builder.create(
                new Identifier("keybinds", "menu"),
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_KP_7,
                "Vanilla High"
        ).build();
        KeyBindingRegistry.INSTANCE.register(gui_key);

        AtomicBoolean lock = new AtomicBoolean(false);
        ClientTickCallback.EVENT.register(e ->
        {
            if(gui_key.isPressed() && !lock.get()) {
                MinecraftClient.getInstance().openScreen(new screen(new gui()));
                lock.set(true);
            }
            if (!gui_key.isPressed()) { // Makes it so the command only executes once
                lock.set(false);

            }
        });

    }
}