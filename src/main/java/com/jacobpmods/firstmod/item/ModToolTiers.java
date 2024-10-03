package com.jacobpmods.firstmod.item;

import com.jacobpmods.firstmod.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModToolTiers {
    public static final Tier NEXON = new ForgeTier(3000, 11, 5f, 15,
            ModTags.Blocks.NEEDS_NEXON_TOOL, () -> Ingredient.of(ModItems.nexon.get()),
            ModTags.Blocks.INCORRECT_FOR_NEXON_TOOL);
}
