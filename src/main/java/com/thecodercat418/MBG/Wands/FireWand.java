package com.thecodercat418.MBG.Wands;

import com.thecodercat418.MBG.RunningPlacement;
import com.thecodercat418.MBG.Spell;

public class FireWand extends Wand {
    public FireWand() {
        name = "Fire Wand";
        spells.clear();
        spells.add(new Spell("Fire Ball", 0, 2, 0, 2, RunningPlacement.AFTER_TURN, "-20", "-20","+0","+0"));
    }
}
