package com.jacobpmods.firstmod.datagen;

import com.jacobpmods.firstmod.FirstMod;
import com.jacobpmods.firstmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, FirstMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.fireball.get());
        basicItem(ModItems.speedapple.get());

        basicItem(ModItems.nexon.get());
        basicItem(ModItems.nexonheated.get());
        basicItem(ModItems.nexoningot.get());
        basicItem(ModItems.nexonpickaxe.get());
        basicItem(ModItems.nexonreinforcedingot.get());

        handheldItem(ModItems.nexonpickaxe);
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "item/" + item.getId().getPath()));
    }
}
