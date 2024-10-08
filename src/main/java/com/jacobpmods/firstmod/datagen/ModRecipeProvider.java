package com.jacobpmods.firstmod.datagen;

import com.jacobpmods.firstmod.FirstMod;
import com.jacobpmods.firstmod.block.ModBlocks;
import com.jacobpmods.firstmod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.MinecartItem;
import net.minecraft.world.item.crafting.*;
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

        //Nexon Ore Smelting/Blasting Methods
        List<ItemLike> NEXON_SMELTABLES= List.of(ModItems.nexon.get()); //Can add other nexon items here that can be smelted.
        oreSmelting(pRecipeOutput, NEXON_SMELTABLES, RecipeCategory.MISC, ModItems.nexonheated.get(), 0.30f, 200, "nexon");
        oreBlasting(pRecipeOutput, NEXON_SMELTABLES, RecipeCategory.MISC, ModItems.nexonheated.get(), 0.30f, 100, "nexon");

        //Nexon Block Recipe
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.NEXON_BLOCK.get(), 1)
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.nexoningot.get())
                .unlockedBy(getHasName(ModItems.nexoningot.get()), has(ModItems.nexoningot.get())).save(pRecipeOutput);

        // 9 Nexon from Block Recipe
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.nexon.get(), 9)
                .requires(ModBlocks.NEXON_BLOCK.get())
                        .unlockedBy(getHasName(ModBlocks.NEXON_BLOCK.get()), has(ModBlocks.NEXON_BLOCK.get())).save(pRecipeOutput);

        //Nexon ingot Craft Recipe
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.nexoningot.get(), 1)
                .pattern("HHH")
                .pattern("HHH")
                .pattern("HHH")
                .define('H', ModItems.nexonheated.get())
                .unlockedBy(getHasName(ModItems.nexoningot.get()), has(ModItems.nexoningot.get())).save(pRecipeOutput);

        //Nexon Reinforced Ingot Craft Recipe
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.nexonreinforcedingot.get(), 1)
                .requires(ModItems.nexoningot.get(),1)
                .requires(Items.NETHERITE_INGOT, 1)
                .unlockedBy(getHasName(ModItems.nexoningot.get()), has(ModItems.nexoningot.get())).save(pRecipeOutput);

        //Nexon Pickaxe Craft Recipe
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.nexonpickaxe.get(), 1)
                .pattern("AAA")
                .pattern(" S ")
                .pattern(" S ")
                .define('A', ModItems.nexonreinforcedingot.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.nexonreinforcedingot.get()), has(ModItems.nexonreinforcedingot.get())).save(pRecipeOutput);

        //Speed apple
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.speedapple.get(), 1)
                .pattern("SSS")
                .pattern("SAS")
                .pattern("SSS")
                .define('A', Items.APPLE)
                .define('S', Items.SUGAR)
                .unlockedBy(getHasName(Items.APPLE), has(Items.APPLE)).save(pRecipeOutput);
    }
    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, FirstMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
