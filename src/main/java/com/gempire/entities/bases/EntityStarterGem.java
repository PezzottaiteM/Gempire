package com.gempire.entities.bases;

import com.gempire.entities.abilities.AbilityZilch;
import com.gempire.entities.abilities.base.Ability;
import com.gempire.util.PaletteType;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

import java.util.ArrayList;

public abstract class EntityStarterGem extends EntityGem {

    public EntityStarterGem(EntityType<? extends PathfinderMob> type, Level worldIn) {
        super(type, worldIn);
    }

    @Override
    public int generatePaletteColor(PaletteType type) {
        if(type == PaletteType.HAIR){
            return getSkinColor();
        }
        return super.generatePaletteColor(type);
    }

    @Override
    public SoundEvent getInstrument()
    {
        return SoundEvents.NOTE_BLOCK_XYLOPHONE.get();
    }
    public int generateHairVariant(){
        return this.random.nextInt(3);
    }

    public int generateOutfitColor(){
        return this.random.nextInt(16);
    }

    public int generateInsigniaColor(){
        return this.random.nextInt(16);
    }

    public int generateAbilitySlots() {
        return 1;
    }

    public ArrayList<Ability> definiteAbilities(){
        ArrayList<Ability> arrayList = new ArrayList<>();
        arrayList.add(new AbilityZilch());
        return arrayList;
    }

    public boolean canChangeInsigniaColorByDefault(){
        return true;
    }

    @Override
    public int generateSkinColorVariant() {
        return 0;
    }

    public boolean canChangeUniformColorByDefault() {
        return true;
    }

    public boolean hasSkinColorVariant(){
        return false;
    }

    @Override
    public byte EmotionThreshold() {
        return 10;
    }

    public int generateOutfitVariant(){
        return this.random.nextInt(4);
    }
    public int generateInsigniaVariant(){
        return this.getOutfitVariant();
    }

    public int generateRebelInsigniaVariant(){
        return this.getRebelOutfitVariant();
    }

    @Override
    public boolean generateIsEmotional() {
        return false;
    }

    @Override
    public int generateSkinVariant() {
        return 0;
    }

    @Override
    public int generateHardness() {
        return 3;
    }

    @Override
    public int exitHoleSize() {
        return 0;
    }
}
