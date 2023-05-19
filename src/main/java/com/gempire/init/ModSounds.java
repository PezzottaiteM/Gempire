package com.gempire.init;

import com.gempire.Gempire;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Gempire.MODID);

    public static final RegistryObject<SoundEvent> INJECT = SOUNDS.register("inject", () -> new SoundEvent(new ResourceLocation(Gempire.MODID, "inject")));
    public static final RegistryObject<SoundEvent> POOF = SOUNDS.register("poof", () -> new SoundEvent(new ResourceLocation(Gempire.MODID, "poof")));
    public static final RegistryObject<SoundEvent> WHISTLE = SOUNDS.register("whistle", () -> new SoundEvent(new ResourceLocation(Gempire.MODID, "whistle")));

    public static final RegistryObject<SoundEvent> CRAWLER_HURT = SOUNDS.register("crawler_hurt", () -> new SoundEvent(new ResourceLocation(Gempire.MODID, "crawler_hurt")));

    public static final RegistryObject<SoundEvent> CRAWLER_ATTACK = SOUNDS.register("crawler_attack", () -> new SoundEvent(new ResourceLocation(Gempire.MODID, "crawler_attack")));

    public static final RegistryObject<SoundEvent> CRAWLER_DEATH = SOUNDS.register("crawler_death", () -> new SoundEvent(new ResourceLocation(Gempire.MODID, "crawler_death")));

    public static final RegistryObject<SoundEvent> CRAWLER_LIVING = SOUNDS.register("crawler_living", () -> new SoundEvent(new ResourceLocation(Gempire.MODID, "crawler_living")));
    public static final RegistryObject<SoundEvent> SHAMBLER_HURT = SOUNDS.register("shambler_hurt", () -> new SoundEvent(new ResourceLocation(Gempire.MODID, "shambler_hurt")));

    public static final RegistryObject<SoundEvent> SHAMBLER_ATTACK = SOUNDS.register("shambler_attack", () -> new SoundEvent(new ResourceLocation(Gempire.MODID, "shambler_attack")));

    public static final RegistryObject<SoundEvent> SHAMBLER_DEATH = SOUNDS.register("shambler_death", () -> new SoundEvent(new ResourceLocation(Gempire.MODID, "shambler_death")));

    public static final RegistryObject<SoundEvent> SHAMBLER_LIVING = SOUNDS.register("shambler_living", () -> new SoundEvent(new ResourceLocation(Gempire.MODID, "shambler_living")));
    public static final RegistryObject<SoundEvent> ABOMINATION_HURT = SOUNDS.register("abomination_hurt", () -> new SoundEvent(new ResourceLocation(Gempire.MODID, "abomination_hurt")));

    public static final RegistryObject<SoundEvent> ABOMINATION_ATTACK = SOUNDS.register("abomination_attack", () -> new SoundEvent(new ResourceLocation(Gempire.MODID, "abomination_attack")));

    public static final RegistryObject<SoundEvent> ABOMINATION_DEATH = SOUNDS.register("abomination_death", () -> new SoundEvent(new ResourceLocation(Gempire.MODID, "abomination_death")));

    public static final RegistryObject<SoundEvent> ABOMINATION_LIVING = SOUNDS.register("abomination_living", () -> new SoundEvent(new ResourceLocation(Gempire.MODID, "abomination_living")));


}
