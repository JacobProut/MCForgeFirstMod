package com.jacobpmods.firstmod.datagen;

import com.jacobpmods.firstmod.block.ModBlocks;
import com.jacobpmods.firstmod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.MinecartItem;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {

        List<ItemLike> NEXON_SMELTABLES= List.of(ModItems.nexon.get());
        oreSmelting(pRecipeOutput, NEXON_SMELTABLES, RecipeCategory.MISC, ModItems.nexonheated.get(), 0.30f, 200, "nexon");
        oreBlasting(pRecipeOutput, NEXON_SMELTABLES, RecipeCategory.MISC, ModItems.nexonheated.get(), 0.30f, 100, "nexon");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.NEXON_BLOCK.get(), 1)
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.nexoningot.get())
                .unlockedBy(getHasName(ModItems.nexoningot.get()), has(ModItems.nexoningot.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.nexon.get(), 9)
                .requires(ModBlocks.NEXON_BLOCK.get())
                        .unlockedBy(getHasName(ModBlocks.NEXON_BLOCK.get()), has(ModBlocks.NEXON_BLOCK.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.nexoningot.get(), 1)
                .pattern("HHH")
                .pattern("HHH")
                .pattern("HHH")
                .define('H', ModItems.nexonheated.get())
                .unlockedBy(getHasName(ModItems.nexoningot.get()), has(ModItems.nexoningot.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.nexonreinforcedingot.get(), 1)
                .requires(ModItems.nexoningot.get(),1)
                .requires(Items.NETHERITE_INGOT, 1)
                .unlockedBy(getHasName(ModItems.nexoningot.get()), has(ModItems.nexoningot.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.nexonpickaxe.get(), 1)
                .pattern("AAA")
                .pattern(" S ")
                .pattern(" S ")
                .define('A', ModItems.nexonreinforcedingot.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.nexonreinforcedingot.get()), has(ModItems.nexonreinforcedingot.get())).save(pRecipeOutput);




    }
}
