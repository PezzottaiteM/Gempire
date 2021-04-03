package com.gempire.init;

import com.gempire.Gempire;
import com.gempire.blocks.DrainedBlock;
import com.gempire.blocks.GemSeedBlock;
import com.gempire.blocks.TankBlock;
import net.minecraft.block.Block;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Gempire.MODID);

    /*public static RegistryObject<FlowingFluidBlock> TEST_FLUID_BLOCK = BLOCKS.register("test_fluid_block", () ->
                    new FlowingFluidBlock(ModFluids.TEST_FLUID, Block.Properties.create(Material.WATER).doesNotBlockMovement().hardnessAndResistance(100.0F).noDrops()));
*/
    public static RegistryObject<FlowingFluidBlock> PINK_ESSENCE_BLOCK = BLOCKS.register("pink_essence_block", () ->
            new FlowingFluidBlock(ModFluids.PINK_ESSENCE, Block.Properties.create(Material.WATER).doesNotBlockMovement().hardnessAndResistance(100.0F).noDrops()));

    public static RegistryObject<FlowingFluidBlock> BLUE_ESSENCE_BLOCK = BLOCKS.register("blue_essence_block", () ->
            new FlowingFluidBlock(ModFluids.BLUE_ESSENCE, Block.Properties.create(Material.WATER).doesNotBlockMovement().hardnessAndResistance(100.0F).noDrops()));

    public static RegistryObject<FlowingFluidBlock> YELLOW_ESSENCE_BLOCK = BLOCKS.register("yellow_essence_block", () ->
            new FlowingFluidBlock(ModFluids.YELLOW_ESSENCE, Block.Properties.create(Material.WATER).doesNotBlockMovement().hardnessAndResistance(100.0F).noDrops()));

    public static RegistryObject<FlowingFluidBlock> WHITE_ESSENCE_BLOCK = BLOCKS.register("white_essence_block", () ->
            new FlowingFluidBlock(ModFluids.WHITE_ESSENCE, Block.Properties.create(Material.WATER).doesNotBlockMovement().hardnessAndResistance(100.0F).noDrops()));

    public static final RegistryObject<Block> GEM_SEED_BLOCK = BLOCKS.register("gem_seed_block", () ->
            new GemSeedBlock(Block.Properties
                    .create(Material.IRON)
                    .hardnessAndResistance(5.0f, 6.0f)
                    .sound(SoundType.STONE)
                    .harvestLevel(1)
                    .harvestTool(ToolType.PICKAXE)
            )
    );

    public static final RegistryObject<Block> DRAINED_BLUE_SOIL = BLOCKS.register("drained_blue_soil", () ->
            new DrainedBlock(Block.Properties
                    .create(Material.EARTH)
                    .hardnessAndResistance(10f, 10f)
                    .sound(SoundType.GROUND)
                    .harvestLevel(1)
                    .harvestTool(ToolType.SHOVEL)
            )
    );

    public static final RegistryObject<Block> DRAINED_BLUE_STONE = BLOCKS.register("drained_blue_stone", () ->
            new DrainedBlock(Block.Properties
                    .create(Material.IRON)
                    .hardnessAndResistance(10f, 10f)
                    .sound(SoundType.STONE)
                    .harvestLevel(1)
                    .harvestTool(ToolType.PICKAXE)
            )
    );

    public static final RegistryObject<Block> DRAINED_BLUE_STONE_2 = BLOCKS.register("drained_blue_stone_2", () ->
            new DrainedBlock(Block.Properties
                    .create(Material.IRON)
                    .hardnessAndResistance(10f, 10f)
                    .sound(SoundType.STONE)
                    .harvestLevel(1)
                    .harvestTool(ToolType.PICKAXE)
            )
    );

    public static final RegistryObject<Block> DRAINED_BANDED_BLUE_STONE = BLOCKS.register("drained_blue_stone_bands", () ->
            new DrainedBlock(Block.Properties
                    .create(Material.IRON)
                    .hardnessAndResistance(10f, 10f)
                    .sound(SoundType.STONE)
                    .harvestLevel(1)
                    .harvestTool(ToolType.PICKAXE)
            )
    );

    public static final RegistryObject<Block> DRAINED_GREY_SOIL = BLOCKS.register("drained_grey_soil", () ->
            new DrainedBlock(Block.Properties
                    .create(Material.EARTH)
                    .hardnessAndResistance(10f, 10f)
                    .sound(SoundType.GROUND)
                    .harvestLevel(1)
                    .harvestTool(ToolType.SHOVEL)
            )
    );

    public static final RegistryObject<Block> DRAINED_GREY_STONE = BLOCKS.register("drained_grey_stone", () ->
            new DrainedBlock(Block.Properties
                    .create(Material.IRON)
                    .hardnessAndResistance(10f, 10f)
                    .sound(SoundType.STONE)
                    .harvestLevel(1)
                    .harvestTool(ToolType.PICKAXE)
            )
    );

    public static final RegistryObject<Block> DRAINED_GREY_STONE_2 = BLOCKS.register("drained_grey_stone_2", () ->
            new DrainedBlock(Block.Properties
                    .create(Material.IRON)
                    .hardnessAndResistance(10f, 10f)
                    .sound(SoundType.STONE)
                    .harvestLevel(1)
                    .harvestTool(ToolType.PICKAXE)
            )
    );

    public static final RegistryObject<Block> DRAINED_BANDED_GREY_STONE = BLOCKS.register("drained_grey_stone_bands", () ->
            new DrainedBlock(Block.Properties
                    .create(Material.IRON)
                    .hardnessAndResistance(10f, 10f)
                    .sound(SoundType.STONE)
                    .harvestLevel(1)
                    .harvestTool(ToolType.PICKAXE)
            )
    );

    public static final RegistryObject<Block> DRAINED_PURPLE_SOIL = BLOCKS.register("drained_purple_soil", () ->
            new DrainedBlock(Block.Properties
                    .create(Material.EARTH)
                    .hardnessAndResistance(10f, 10f)
                    .sound(SoundType.GROUND)
                    .harvestLevel(1)
                    .harvestTool(ToolType.SHOVEL)
            )
    );

    public static final RegistryObject<Block> DRAINED_PURPLE_STONE = BLOCKS.register("drained_purple_stone", () ->
            new DrainedBlock(Block.Properties
                    .create(Material.IRON)
                    .hardnessAndResistance(10f, 10f)
                    .sound(SoundType.STONE)
                    .harvestLevel(1)
                    .harvestTool(ToolType.PICKAXE)
            )
    );

    public static final RegistryObject<Block> DRAINED_PURPLE_STONE_2 = BLOCKS.register("drained_purple_stone_2", () ->
            new DrainedBlock(Block.Properties
                    .create(Material.IRON)
                    .hardnessAndResistance(10f, 10f)
                    .sound(SoundType.STONE)
                    .harvestLevel(1)
                    .harvestTool(ToolType.PICKAXE)
            )
    );

    public static final RegistryObject<Block> DRAINED_BANDED_PURPLE_STONE = BLOCKS.register("drained_purple_stone_bands", () ->
            new DrainedBlock(Block.Properties
                    .create(Material.IRON)
                    .hardnessAndResistance(10f, 10f)
                    .sound(SoundType.STONE)
                    .harvestLevel(1)
                    .harvestTool(ToolType.PICKAXE)
            )
    );

    public static final RegistryObject<Block> DRAINED_RED_SAND = BLOCKS.register("drained_red_sand", () ->
            new DrainedBlock(Block.Properties
                    .create(Material.SAND)
                    .hardnessAndResistance(10f, 10f)
                    .sound(SoundType.SAND)
                    .harvestLevel(1)
                    .harvestTool(ToolType.SHOVEL)
            )
    );

    public static final RegistryObject<Block> DRAINED_RED_STONE = BLOCKS.register("drained_red_stone", () ->
            new DrainedBlock(Block.Properties
                    .create(Material.IRON)
                    .hardnessAndResistance(10f, 10f)
                    .sound(SoundType.STONE)
                    .harvestLevel(1)
                    .harvestTool(ToolType.PICKAXE)
            )
    );

    public static final RegistryObject<Block> DRAINED_RED_STONE_2 = BLOCKS.register("drained_red_stone_2", () ->
            new DrainedBlock(Block.Properties
                    .create(Material.IRON)
                    .hardnessAndResistance(10f, 10f)
                    .sound(SoundType.STONE)
                    .harvestLevel(1)
                    .harvestTool(ToolType.PICKAXE)
            )
    );

    public static final RegistryObject<Block> DRAINED_BANDED_RED_STONE = BLOCKS.register("drained_red_stone_bands", () ->
            new DrainedBlock(Block.Properties
                    .create(Material.IRON)
                    .hardnessAndResistance(10f, 10f)
                    .sound(SoundType.STONE)
                    .harvestLevel(1)
                    .harvestTool(ToolType.PICKAXE)
            )
    );

    public static final RegistryObject<Block> DRAINED_SAND = BLOCKS.register("drained_sand", () ->
            new DrainedBlock(Block.Properties
                    .create(Material.SAND)
                    .hardnessAndResistance(10f, 10f)
                    .sound(SoundType.SAND)
                    .harvestLevel(1)
                    .harvestTool(ToolType.SHOVEL)
            )
    );

    public static final RegistryObject<Block> DRAINED_YELLOW_STONE = BLOCKS.register("drained_red_stone", () ->
            new DrainedBlock(Block.Properties
                    .create(Material.IRON)
                    .hardnessAndResistance(10f, 10f)
                    .sound(SoundType.STONE)
                    .harvestLevel(1)
                    .harvestTool(ToolType.PICKAXE)
            )
    );

    public static final RegistryObject<Block> DRAINED_YELLOW_STONE_2 = BLOCKS.register("drained_yellow_stone_2", () ->
            new DrainedBlock(Block.Properties
                    .create(Material.IRON)
                    .hardnessAndResistance(10f, 10f)
                    .sound(SoundType.STONE)
                    .harvestLevel(1)
                    .harvestTool(ToolType.PICKAXE)
            )
    );

    public static final RegistryObject<Block> DRAINED_BANDED_YELLOW_STONE = BLOCKS.register("drained_yellow_stone_bands", () ->
            new DrainedBlock(Block.Properties
                    .create(Material.IRON)
                    .hardnessAndResistance(10f, 10f)
                    .sound(SoundType.STONE)
                    .harvestLevel(1)
                    .harvestTool(ToolType.PICKAXE)
            )
    );

    /*public static final RegistryObject<Block> TEST_CONTAINER_BLOCK = BLOCKS.register("test_container_block", () ->
            new GUITestBlock(Block.Properties
                    .create(Material.IRON)
                    .hardnessAndResistance(5.0f, 6.0f)
                    .sound(SoundType.STONE)
                    .harvestLevel(1)
                    .harvestTool(ToolType.PICKAXE)
            )
    );*/

    public static final RegistryObject<Block> TANK_BLOCK = BLOCKS.register("tank_block", () ->
            new TankBlock(Block.Properties
                    .create(Material.IRON)
                    .hardnessAndResistance(5.0f, 6.0f)
                    .sound(SoundType.GLASS)
                    .harvestLevel(1)
                    .harvestTool(ToolType.PICKAXE)
            )
    );
}
