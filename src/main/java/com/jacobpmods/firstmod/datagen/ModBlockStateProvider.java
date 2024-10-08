package com.jacobpmods.firstmod.datagen;

import com.jacobpmods.firstmod.FirstMod;
import com.jacobpmods.firstmod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, FirstMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.NEXON_BLOCK);
        blockWithItem(ModBlocks.NEXON_ORE_BLOCK);
        //blockWithItem(ModBlocks.GHOSTLY_GRASS_BLOCK);
        simpleBlock(ModBlocks.GHOSTLY_GRASS_BLOCK.get(), models().cubeAll("ghostly_grass_block",
                modLoc("block/ghostly_grass_block"))); // Ensure the texture exists


    }


    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

}
