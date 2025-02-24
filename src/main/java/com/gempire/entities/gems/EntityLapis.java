package com.gempire.entities.gems;

import com.gempire.config.GempireServerConfigs;
import com.gempire.config.GempireServerConfigs;
import com.gempire.entities.abilities.*;
import com.gempire.entities.abilities.base.Ability;
import com.gempire.entities.ai.*;
import com.gempire.entities.bases.EntityFlyingVehicleGem;
import com.gempire.entities.bases.EntityGem;
import com.gempire.entities.other.EntityAbomination;
import com.gempire.entities.other.EntityCrawler;
import com.gempire.entities.other.EntityShambler;
import com.gempire.util.GemPlacements;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.FlyingAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.phys.Vec3;

import java.util.ArrayList;

public class EntityLapis extends EntityFlyingVehicleGem implements FlyingAnimal {

    public static EntityDataAccessor<Boolean> TERRAFORMING = SynchedEntityData.<Boolean>defineId(EntityGem.class, EntityDataSerializers.BOOLEAN);

    public EntityLapis(EntityType<? extends PathfinderMob> type, Level worldIn) {
        super(type, worldIn);
        this.entityData.define(EntityLapis.TERRAFORMING, false);
    }

    public static AttributeSupplier.Builder registerAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 35.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.3D)
                .add(Attributes.ATTACK_DAMAGE, 2.0D)
                .add(Attributes.ATTACK_SPEED, 1.0D);
    }

    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(9, new FloatGoal(this));
        this.goalSelector.addGoal(6, new PanicGoal(this, 1.1D));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 4.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(7, new EntityAIFollowAssigned(this, 1.0D));
        this.goalSelector.addGoal(7, new EntityAIWander(this, 1.0D));
        this.goalSelector.addGoal(4, new EntityAIExitHole(this, 1.0D));
        this.goalSelector.addGoal(7, new EntityAIStay(this, 1.0D));
        this.goalSelector.addGoal(7, new EntityAIFollowOwner(this, 1.0D));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, EntityGem.class, 1, false, false, this::checkRebel));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, EntityAbomination.class, 1, false, false, this::checkNotSludged));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, EntityShambler.class, 1, false, false, this::checkNotSludged));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, EntityCrawler.class, 1, false, false, this::checkNotSludged));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Mob.class, 1, false, false, (p_234199_0_) -> p_234199_0_.getClassification(true) == MobCategory.MONSTER));
        this.targetSelector.addGoal(1, new OwnerHurtByTargetGemGoal(this));
        this.targetSelector.addGoal(2, new OwnerHurtTargetGemGoal(this));
        this.goalSelector.addGoal(1, new EntityAISludged(this, 0.6));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, EntityGem.class, 1, false, false, this::checkBothSludged));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, 1, false, false, this::checkSludged));
this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, EntityGem.class, 6.0F, 1.0D, 1.2D, this::checkElseSludged));
        this.goalSelector.addGoal(1, new EntityAITerraform(this, 1.0D));
   }


    @Override
    public void aiStep() {
        super.aiStep();
        Vec3 vec = this.getDeltaMovement();
        if (!this.onGround() && vec.y < 0.0D && !this.isElytraFlying()) {
            this.setDeltaMovement(vec.multiply(1.0D, 0.6D, 1.0D)); // lower the gravity to 0.6
            this.flying = true;
        }
    }

    @Override
    public Float baseXScale() {
        return .9F;
    }

    @Override
    public Float baseYScale() {
        return .95F;
    }

    @Override
    public Float baseZScale() {
        return .9F;
    }
    @Override
    public SoundEvent getInstrument()
    {
        return SoundEvents.NOTE_BLOCK_HARP.get();
    }
    @Override
    public int generateSkinVariant() {
        return 0;
    }

    @Override
    public boolean hasWings() {
        return true;
    }

    public boolean requiresHydrationToFly() {
        return true;
    }

    @Override
    public int generateWingVariant()  {
        return this.random.nextInt(6);
    }

    @Override
    public GemPlacements[] getPlacements() {
        return new GemPlacements[] {
                GemPlacements.TOP_OF_HEAD, GemPlacements.FOREHEAD, GemPlacements.BACK_OF_HEAD, GemPlacements.LEFT_EYE, GemPlacements.RIGHT_EYE, GemPlacements.NOSE, GemPlacements.LEFT_CHEEK, GemPlacements.RIGHT_CHEEK, GemPlacements.LEFT_EAR, GemPlacements.RIGHT_EAR,
                GemPlacements.CHEST, GemPlacements.BACK, GemPlacements.BELLY, GemPlacements.LEFT_SHOULDER, GemPlacements.RIGHT_SHOULDER, GemPlacements.LEFT_HAND, GemPlacements.RIGHT_HAND, GemPlacements.LEFT_PALM, GemPlacements.RIGHT_PALM, GemPlacements.LEFT_THIGH,
                GemPlacements.RIGHT_THIGH, GemPlacements.LEFT_ANKLE, GemPlacements.RIGHT_ANKLE };
    }

    @Override
    public int generateHairVariant() {
        return this.random.nextInt(5);
    }

    @Override
    public int generateInsigniaColor() {
        return 11;
    }

    @Override
    public int generateOutfitColor() {
        return 11;
    }

    @Override
    public boolean hasOutfitPlacementVariant() {
        return false;
    }

    @Override
    public int[] outfitPlacementVariants() {
        return new int[]{
                11, 17
        };
    }
    @Override
    public boolean getIsCut()
    {
        return false;
    }
    public ArrayList<Ability> possibleAbilities(){
        ArrayList<Ability> arrayList = new ArrayList<>();
        arrayList.add(new AbilityZilch());
        arrayList.add(new AbilityHydration());
        arrayList.add(new AbilityTank());
        arrayList.add(new AbilityBeefcake());
        arrayList.add(new AbilityPowerhouse());
        arrayList.add(new AbilityUnhinged());
        arrayList.add(new AbilityBerserker());
        return arrayList;
    }

    public ArrayList<Ability> definiteAbilities(){
        ArrayList<Ability> arrayList = new ArrayList<>();
        arrayList.add(new AbilityHydrokinesis());
        arrayList.add(new AbilityVehicle());
        return arrayList;
    }

    public int generateSkinColorVariant() {
        return 0;
    }

    @Override
    public boolean generateIsEmotional() {
        return GempireServerConfigs.OUTBURSTS.get();
    }

    @Override
    public byte EmotionThreshold() {
        return 10;
    }

    public boolean canChangeUniformColorByDefault() {
        return true;
    }

    public boolean canChangeInsigniaColorByDefault(){
        return true;
    }

    public boolean canOpenInventoryByDefault() {
        return !this.isRideable();
    }

    @Override
    public boolean fireImmune(){
        return false;
    }

    public boolean hasSkinColorVariant(){
        return false;
    }

    public int generateOutfitVariant(){
        return this.random.nextInt(5);
    }

    public int generateInsigniaVariant(){
            return this.getOutfitVariant();
    }

    public int generateRebelInsigniaVariant() {
        return this.getRebelOutfitVariant();
    }

    @Override
    public int generateVisorVariant() {
        return this.random.nextInt(9);
    }

    public boolean isFocused() {
        return true;
    }

    @Override
    public int baseFocus() {
        return 7;
    }

    public int generateHardness() {
        return 5;
    }



    @Override
    public int getColor() {
        return 11;
    }

    @Override
    public int exitHoleSize() {
        return 3;
    }


    public void setTerraforming(boolean value) {
        this.entityData.set(EntityLapis.TERRAFORMING, value);
    }

    public boolean isTerraforming() {
        return this.entityData.get(EntityLapis.TERRAFORMING);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        tag.putBoolean("terraforming", isTerraforming());
        super.addAdditionalSaveData(tag);
    }

    @Override
    public void load(CompoundTag tag) {
        setTerraforming(tag.getBoolean("terraforming"));
        super.load(tag);
    }
}
