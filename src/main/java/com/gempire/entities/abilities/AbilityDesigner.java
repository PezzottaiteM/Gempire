package com.gempire.entities.abilities;

import com.gempire.entities.abilities.base.Ability;
import com.gempire.entities.abilities.interfaces.ICraftingAbility;
import com.gempire.init.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Items;

public class AbilityDesigner extends Ability implements ICraftingAbility {
    public AbilityDesigner(){
        super("designer", 5);
    }

    @Override
    public int recipeAmount() {
        return 1;
    }
    @Override
    public void setup() {
        input.add(Items.STONE);
        output.add(ModItems.PEDISTAL.get());
        holder.inputList = input;
        holder.outputList = output;
        input2.add(Items.AIR);
        holder.input2List = input2;
    }
    @Override
    public Component getName() {
        return Component.translatable("ability.gempire.designer");
    }
}
