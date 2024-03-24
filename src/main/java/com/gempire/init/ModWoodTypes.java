package com.gempire.init;

import com.gempire.Gempire;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public class ModWoodTypes {

    public static final WoodType DISTANT = WoodType.register(new WoodType(Gempire.MODID + ":distant", BlockSetType.OAK));
    public static final WoodType CRYSTAL = WoodType.register(new WoodType(Gempire.MODID + ":crystal", BlockSetType.OAK));
    public static final WoodType KALEIDOSCOPE = WoodType.register(new WoodType(Gempire.MODID + ":kaleidoscope", BlockSetType.OAK));
}
