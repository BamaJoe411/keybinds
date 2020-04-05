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
        keyBinding = FabricKeyBinding.Builder.create(
                new Identifier("sleepers","key"),
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_EQUAL,
                "Vanilla High"
        ).build();
        KeyBindingRegistry.INSTANCE.register(keyBinding);

        ClientTickCallback.EVENT.register(e ->
        {
            if(keyBinding.isPressed()) {
                World world = MinecraftClient.getInstance().world;

                //ClientPlayerEntity player = new ClientPlayerEntity(MinecraftClient.getInstance(), world);

                System.out.println("the key was pressed!");
            }
        });

    }
}