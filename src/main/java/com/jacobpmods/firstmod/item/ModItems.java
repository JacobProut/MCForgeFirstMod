package com.jacobpmods.firstmod.item;

import com.jacobpmods.firstmod.FirstMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FirstMod.MOD_ID);

    public static final RegistryObject<Item> speedapple = ITEMS.register("speedapple", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> fireball = ITEMS.register("throwablefireball", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> nexon = ITEMS.register("nexon", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> nexoningot = ITEMS.register("nexoningot", () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
