package com.thecodercat418.MBG.Wands;

import com.thecodercat418.MBG.DamageTypes;
import com.thecodercat418.MBG.Spell;

public class FireWand extends Wand{
    public FireWand(){
        name = "Fire Wand";
        spells.clear();
        spells.add(new Spell("Fire Ball", 0, 0, 1, "-20", DamageTypes.FIRE, "+0", DamageTypes.NOT_SET));
    }
}
