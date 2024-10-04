package com.jacobpmods.firstmod.datagen;

import com.jacobpmods.firstmod.FirstMod;
import com.jacobpmods.firstmod.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

import static net.minecraft.tags.BlockTags.*;
import static net.minecraftforge.common.Tags.Blocks.NEEDS_NETHERITE_TOOL;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, FirstMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.NEXON_BLOCK.get())
                .add(ModBlocks.NEXON_ORE_BLOCK.get());

        tag(NEEDS_NETHERITE_TOOL)
                .add(ModBlocks.NEXON_ORE_BLOCK.get())
                .add(ModBlocks.NEXON_BLOCK.get())
                .addTag(NEEDS_NETHERITE_TOOL);

        tag(INCORRECT_FOR_DIAMOND_TOOL)
                .add(ModBlocks.NEXON_ORE_BLOCK.get())
                .add(ModBlocks.NEXON_BLOCK.get());

        tag(INCORRECT_FOR_IRON_TOOL)
                .add(ModBlocks.NEXON_ORE_BLOCK.get())
                .add(ModBlocks.NEXON_BLOCK.get());

        tag(INCORRECT_FOR_GOLD_TOOL)
                .add(ModBlocks.NEXON_ORE_BLOCK.get())
                .add(ModBlocks.NEXON_BLOCK.get());

        tag(INCORRECT_FOR_STONE_TOOL)
                .add(ModBlocks.NEXON_ORE_BLOCK.get())
                .add(ModBlocks.NEXON_BLOCK.get());

        tag(INCORRECT_FOR_WOODEN_TOOL)
                .add(ModBlocks.NEXON_ORE_BLOCK.get())
                .add(ModBlocks.NEXON_BLOCK.get());
    }
}