package com.thecodercat418.MBG.Wands;

import com.thecodercat418.MBG.DamageTypes;
import com.thecodercat418.MBG.RunningPlacement;
import com.thecodercat418.MBG.Spell;

public class FireWand extends Wand {
    public FireWand() {
        name = "Fire Wand";
        spells.clear();
        spells.add(new Spell("Fire Ball", 0, 2, 0, "-20", DamageTypes.FIRE, "+0", DamageTypes.NOT_SET, 2,
                RunningPlacement.AFTER_TURN));
    }
}
