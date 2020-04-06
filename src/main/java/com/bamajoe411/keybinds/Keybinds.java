package com.bamajoe411.keybinds;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.keybinding.FabricKeyBinding;
import net.fabricmc.fabric.api.client.keybinding.KeyBindingRegistry;
import net.fabricmc.fabric.api.event.client.ClientTickCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.InputUtil;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import org.lwjgl.glfw.GLFW;

public class Keybinds implements ModInitializer{
    private static FabricKeyBinding keyBinding;

    @Override
    public void onInitialize() {
        KeyBindingRegistry.INSTANCE.addCategory("Vanilla High");
        // Home
        FabricKeyBinding home = FabricKeyBinding.Builder.create(
                new Identifier("keybinds", "home"),
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_EQUAL,
                "Vanilla High"
        ).build();
        KeyBindingRegistry.INSTANCE.register(home);

        // Spawn
        FabricKeyBinding spawn = FabricKeyBinding.Builder.create(
                new Identifier("keybinds", "spawn"),
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_MINUS,
                "Vanilla High"
        ).build();
        KeyBindingRegistry.INSTANCE.register(spawn);

        ClientTickCallback.EVENT.register(e ->
        {
            if(spawn.isPressed()) {
                MinecraftClient client = MinecraftClient.getInstance();
                client.player.sendChatMessage("/trigger cmd set 1");
                // System.out.println("Spawn Key Was Pressed");
            }

            if(home.isPressed()) {
                MinecraftClient client = MinecraftClient.getInstance();
                client.player.sendChatMessage("/trigger cmd set 3");
                // System.out.println("Home Key Was Pressed");
            }
        });

    }
}