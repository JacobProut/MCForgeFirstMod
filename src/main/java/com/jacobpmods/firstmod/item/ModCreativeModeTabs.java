package com.jacobpmods.firstmod.item;

import com.jacobpmods.firstmod.FirstMod;
import com.jacobpmods.firstmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FirstMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> JACOBS_MODDED_ITEMS_TAB = CREATIVE_MODE_TABS.register("jacobs_modded_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.speedapple.get()))
                    .title(Component.translatable("Jacobs Modded Items")).displayItems((itemDisplayParameters, output) -> {
                       output.accept(ModItems.speedapple.get());
                       output.accept(ModItems.fireball.get());
                       output.accept(ModItems.nexon.get());
                       output.accept(ModItems.nexonheated.get());
                       output.accept(ModItems.nexoningot.get());
                       output.accept(ModItems.nexonreinforcedingot.get());
                       output.accept(ModBlocks.NEXON_BLOCK.get());
                       output.accept(ModBlocks.NEXON_ORE_BLOCK.get());
                       output.accept(ModItems.nexonpickaxe.get());
                       output.accept(ModItems.nexonhoe.get());
                       output.accept(ModItems.nexonshovel.get());
                       output.accept(ModItems.nexonsword.get());
                       output.accept(ModItems.nexonaxe.get());



                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
