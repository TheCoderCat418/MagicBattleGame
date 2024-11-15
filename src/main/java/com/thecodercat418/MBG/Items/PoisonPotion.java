package com.thecodercat418.MBG.Items;

import com.thecodercat418.MBG.RunningPlacement;
import com.thecodercat418.MBG.Spell;
import com.thecodercat418.MBG.SpellEffect;

public class PoisonPotion extends Item  {
    public PoisonPotion(){
        super("Posion Potion", new SpellEffect(new Spell("Poison Potion Effect", -1, 0, 5, 5, RunningPlacement.AFTER_TURN, "-5", "-5", "+0", "+0"), RunningPlacement.AFTER_TURN), "Poisons you");
    }
}
