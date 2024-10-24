package com.thecodercat418.MBG.Wands;

import com.thecodercat418.MBG.Spell;

import java.util.ArrayList;

public abstract class Wand {
    public int meleeDamage = 0;
    public int wandLevel = 0;
    public String name;
    public ArrayList<Spell> spells = new ArrayList<>();

    public Wand(String name){
        this.name = name;
    }

    public Spell[] getSpells(){
        return spells.toArray(new Spell[spells.size()]);
    }

    public boolean upgradeWand(){
        wandLevel++;
        return true;
    }
}
