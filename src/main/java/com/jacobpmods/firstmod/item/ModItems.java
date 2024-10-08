package com.jacobpmods.firstmod.item;

import com.jacobpmods.firstmod.FirstMod;
import com.jacobpmods.firstmod.item.custom.food.speedapple;
import com.jacobpmods.firstmod.item.custom.tools.NexonAxe;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FirstMod.MOD_ID);

    public static final RegistryObject<Item> speedapple = ITEMS.register("speedapple", () -> new speedapple(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.3F).build())));
    public static final RegistryObject<Item> fireball = ITEMS.register("throwablefireball", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> nexon = ITEMS.register("nexon", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> nexoningot = ITEMS.register("nexoningot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> nexonheated = ITEMS.register("nexonheated", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> nexonreinforcedingot = ITEMS.register("nexonreinforcedingot", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> nexonpickaxe = ITEMS.register("nexonpickaxe",
            () -> new PickaxeItem(ModToolTiers.NEXON, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.NEXON,1.0F, -2.8F))));

    public static final RegistryObject<Item> nexonshovel = ITEMS.register("nexonshovel",
            () -> new ShovelItem(ModToolTiers.NEXON, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.NEXON,1.5F, -3.0F))));

    public static final RegistryObject<Item> nexonhoe = ITEMS.register("nexonhoe",
            () -> new HoeItem(ModToolTiers.NEXON, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.NEXON,0, -3.0F))));

    public static final RegistryObject<Item> nexonsword = ITEMS.register("nexonsword",
            () -> new SwordItem(ModToolTiers.NEXON, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.NEXON,3, -2.4F))));

    public static final RegistryObject<Item> nexonaxe = ITEMS.register("nexonaxe",
            () -> new NexonAxe(ModToolTiers.NEXON, new Item.Properties()
                    .attributes(NexonAxe.createAttributes(ModToolTiers.NEXON,6, -3.2F))));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
        System.out.println("ModItems registered: " + nexonpickaxe.getId());
    }

}
