package com.thecodercat418.MBG.Wands;

import com.thecodercat418.MBG.BaseCharacter;
import com.thecodercat418.MBG.Spell;

import java.util.ArrayList;

public class Wand {
    protected int wandLevel = 0;
    protected String name;
    protected ArrayList<Spell> spells = new ArrayList<>();

    protected Wand(){

    }

    public Spell[] getSpells(){
        return spells.toArray(new Spell[spells.size()]);
    }

    public void castSpell(BaseCharacter characterToAttack, Spell spellToCast){
        characterToAttack.modifyHealth(spellToCast.damage);
    }

    public String getName(){
        return name;
    }
}
