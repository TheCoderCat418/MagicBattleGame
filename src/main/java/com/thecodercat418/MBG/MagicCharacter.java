package com.thecodercat418.MBG;

import com.thecodercat418.MBG.Wands.Wand;

import java.util.ArrayList;

public class MagicCharacter extends BaseCharacter {
    private int mana;
    private int maxMana = 10;
    private int manaGain = 1;
    private ArrayList<Wand> wands = new ArrayList<>();
    private Wand currentWand;
    

    public MagicCharacter() {
        super("You");
    }

    public boolean addWand(Wand wand) {
        for (Wand wand2 : wands) {
            // upcast? then downcast?
            if (wand.getName().equals(wand2.getName())) {
                return false;
            }
        }
        wands.add(wand);
        currentWand = wand;
        return true;
    }

    public boolean equipWand(Wand wand) {
        for (Wand wand2 : wands) {
            if (wand.equals(wand2)) {
                currentWand = wand;
                return true;
            }
        }
        return false;
    }

    public Wand getCurrentWand() {
        return currentWand;
    }

    public int castSpell(String spellName, BaseCharacter victim) {
        Spell currentSpell = null;
        for (Spell spell : currentWand.getSpells()) {
            if (spell.getSpellName().equals(spellName)) {
                currentSpell = spell;
            }
        }
        if (currentSpell == null) {
            return -2;
        }
        if (mana - currentSpell.getManaNeeded() < 0) {
            return -1;
        }
        currentWand.castSpell(victim, currentSpell);
        if (currentSpell.getLastsFor() > 0 || currentSpell.getTurnCooldown() > 0) {
            addSpellEffect(new SpellEffect(currentSpell, currentSpell.getRunningPlacement()));
        }
        mana = mana - currentSpell.getManaNeeded();
        return 1;
    }

    public SpellEffect getSpellEffectFromSpell(Spell spell) {
        for (SpellEffect sp : getSpellEffects()) {
            if (sp.originalSpell.equals(spell)) {
                return sp;
            }
        }
        return null;
    }

    public int getMana() {
        return mana;
    }

    @Override
    public void BEFORE_TURN(boolean attacker) {
        mana += manaGain;
        if(mana>maxMana){
            mana = maxMana;
        }
    }
}
