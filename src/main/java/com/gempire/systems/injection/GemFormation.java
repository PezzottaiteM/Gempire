package com.gempire.systems.injection;

import com.gempire.entities.bases.EntityGem;
import com.gempire.entities.gems.EntityRuby;
import com.gempire.entities.gems.EntitySapphire;
import com.gempire.entities.gems.starter.EntityPebble;
import com.gempire.init.ModEntities;
import net.minecraft.block.AirBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import net.minecraftforge.fml.RegistryObject;
import org.objectweb.asm.tree.ModuleExportNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.zip.CRC32;

public class GemFormation {
    public World world;
    public BlockPos pos;
    public BlockPos volumeToCheck;
    public static String[] POSSIBLE_GEMS = new String[]{
        "ruby", "sapphire", "pebble", "mica", "shale"
    };

    public GemFormation(World world, BlockPos pos, BlockPos volumeToCheck){
        this.world = world;
        this.pos = pos;
        this.volumeToCheck = volumeToCheck;
    }

    public void SpawnGem(){
        RegistryObject<EntityType<EntityPebble>> gemm = ModEntities.PEBBLE;
        EntityGem gem = gemm.get().create(this.world);
        String gemtoform = this.EvaluateCruxes();
        int variant = 0;
        if(gemtoform == "sapphire"){
            variant = this.world.rand.nextInt(16);
            while(variant == 14){
                variant = this.world.rand.nextInt(16);
            }
        }
        try {
            gemm = (RegistryObject<EntityType<EntityPebble>>) ModEntities.class.getField(gemtoform.toUpperCase()).get(null);
            gem = gemm.get().create(this.world);
            if(gemtoform == "sapphire"){
                gem.setSkinVariantOnInitialSpawn = false;
                gem.initalSkinVariant = variant;
            }
            gem.setUniqueId(MathHelper.getRandomUUID(this.world.rand));
        }
        catch (Exception e){
            e.printStackTrace();
        }
        try{
            gem.onInitialSpawn((IServerWorld) this.world, this.world.getDifficultyForLocation(this.pos), SpawnReason.TRIGGERED, null, null);
            gem.setOwned(false, UUID.randomUUID());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        gem.setPosition(this.pos.getX(), this.pos.getY(), this.pos.getZ());
        gem.setHealth(gem.getMaxHealth());
        this.world.addEntity(gem);
    }

    public static ArrayList<Block> getBlocksInVolume(World domhain, BlockPos position, BlockPos volume){
        ArrayList<Block> blocksInVolume = new ArrayList<>();
        for(int z = -1; z < 2; z++){
            for(int y = -1; y < 2; y++){
                for(int x = -1; x < 2; x++){
                    Block block = domhain.getBlockState(position.add(new BlockPos(x, y, z))).getBlock();
                    if(block.getBlock() instanceof AirBlock){
                        continue;
                    }
                    else{
                        blocksInVolume.add(block);
                    }
                }
            }
        }
        return blocksInVolume;
    }

    public String EvaluateCruxes(){
        //INPUT: List of gems and their cruxes as well as crux temperatures and depth preferences, list of blocks to check
        HashMap<String, ArrayList<Crux>> GEM_CRUXES = ModEntities.CRUXTOGEM;
        ArrayList<Block> BLOCKS_TO_CHECK = GemFormation.getBlocksInVolume(this.world, this.pos, this.volumeToCheck);
        String[] GEMS = GemFormation.POSSIBLE_GEMS;
        float BLOCK_TEMPERATURE = this.world.getBiome(this.pos).getTemperature(this.pos);

        //Create an object to store the gems and their weights once the cruxes have been evaluated
        HashMap<String, Float> WEIGHTS_OF_GEMS = new HashMap<>();

        //Create an object to store the total weight
        float totalWeight = 0;

        //Loop through every gem
        for(String gem : GEMS){
            float gemWeight = 0;
            //GEM_CRUXES.get(gem) is an ArrayList of Cruxes
            if(GEM_CRUXES.get(gem) != null) for (Crux crux : GEM_CRUXES.get(gem)){
                //Do some math to multiply the gem weight by the inverse of the difference in biome temperature to preferred temperature
                float temperatureDifference = crux.temperature - BLOCK_TEMPERATURE == 0 ? 1 : Math.abs(crux.temperature - BLOCK_TEMPERATURE);
                for(Block block : BLOCKS_TO_CHECK){
                    //Then for every crux, calculate the total weight of crux that matches every block in the volume for every gem
                    //Example: if there are three stone in the volume, the total weight will be 3 stone times however many gems there are that have stone as a crux, and so forth
                    if(block != crux.block) {
                        continue;
                    }
                    else{
                        totalWeight += crux.weight;
                        gemWeight += crux.weight * (1 - temperatureDifference);
                    }
                }
            }
            //Once the total weight has been obtained, store the individual weights of every gem in a hashmap.
            WEIGHTS_OF_GEMS.put(gem, gemWeight);
            //DEBUG FEATURES
            System.out.println(gem + " weight: " + gemWeight);
        }
        //DEBUG FEATURES
        System.out.println("Total Weight: " + totalWeight);
        //Finally, do a weighted chance selection using the total weight and the individual weights.
        String returnGem = "";
        double lowestR = 100000000;
        String lowestRGem = "";
        for(String gem : GemFormation.POSSIBLE_GEMS){
            double r = Math.random() * totalWeight;
            r -= WEIGHTS_OF_GEMS.get(gem);
            if(WEIGHTS_OF_GEMS.get(gem) < 12){
                r = 1000000;
            }
            if(r < lowestR){
                lowestR = r;
                lowestRGem = gem;
            }
            returnGem = gem;
            //DEBUG FEATURES
            System.out.println("R for " + gem + " equals: " + r);
            if(r > 0 && gem == GemFormation.POSSIBLE_GEMS[GemFormation.POSSIBLE_GEMS.length - 1]){
                returnGem = lowestRGem;
                break;
            }
            if(r<=0) break;
        }
        //OUTPUT: A gem
        return returnGem;



        /*float biomeTemperature = this.world.getBiome(this.pos).getTemperature(this.pos);
        ArrayList<Block> blocksInVolume = new ArrayList<>();
        for(int z = 0; z < this.volumeToCheck.getZ(); z++){
            for(int y = 0; y < this.volumeToCheck.getY(); y++){
                for(int x = 0; x < this.volumeToCheck.getX(); x++){
                    Block block = this.world.getBlockState(new BlockPos(-(int)Math.floor(x/2), -(int)Math.floor(y/2), -(int)Math.floor(z/2)).add(this.pos)).getBlock();
                    if(block instanceof AirBlock){
                        continue;
                    }
                    blocksInVolume.add(block);
                }
            }
        }
        HashMap<String, Float> weights = new HashMap<>();
        float totalWeight = 0;
        for(String gem : GemFormation.POSSIBLE_GEMS){
            float gemWeight = 0;
            if(ModEntities.CRUXTOGEM.containsKey(gem)) {
                for (int i = 0; i < ModEntities.CRUXTOGEM.get(gem).size(); i++) {
                    Crux crux = null;
                    if (ModEntities.CRUXTOGEM.get(gem).get(i) != null) {
                        crux = ModEntities.CRUXTOGEM.get(gem).get(i);
                    }
                    totalWeight += crux.weight;
                    for (Block block : blocksInVolume) {
                        if (block == crux.block) {
                            gemWeight += crux.weight;
                        }
                    }
                }
            }
            System.out.println(gem + ": " + gemWeight);
            weights.put(gem, gemWeight);
        }
        System.out.println("Total Weight: " + totalWeight);
        String returnGem = "";
        for(String gem : GemFormation.POSSIBLE_GEMS){
            double r = Math.random() * totalWeight;
            r -= weights.get(gem);
            returnGem = gem;
            if(r<=0) break;
        }
        return returnGem;*/
    }
}
