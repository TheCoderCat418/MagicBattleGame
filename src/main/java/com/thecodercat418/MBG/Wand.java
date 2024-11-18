package com.thecodercat418.MBG;

import java.util.ArrayList;

public class Wand {
    protected int maxLevel = 3;
    protected int level = 0;
    protected String name;
    protected ArrayList<Spell> spells = new ArrayList<>();

    protected Wand(){}

    public Wand(int maxLevel, String name, ArrayList<Spell> spells) {
        this.maxLevel = maxLevel;
        this.name = name;
        this.spells = spells;
    }

    public Spell[] getSpells() {
        return spells.toArray(new Spell[spells.size()]);
    }

    public void castSpell(BaseCharacter characterToAttack, Spell spellToCast) {
        characterToAttack.modifyHealth(spellToCast.getDamage());
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public Spell findSpellByName(String nameOfSpell) {
        for (Spell spell : getSpells()) {
            if (spell.getSpellName().equals(nameOfSpell)) {
                return spell;
            }
        }
        return null;
    }
}
