package com.thecodercat418.MBG;

public class SpellEffect {
    public Spell originalSpell;
    public int remainingCooldown;
    public RunningPlacement runningPlacement;
    public int turnCooldown;
    public int runFor;

    public SpellEffect(Spell spell, RunningPlacement rp) {
        originalSpell = spell;
        spell.setDirect(false);
        turnCooldown = spell.getTurnCooldown();
        remainingCooldown = turnCooldown;
        runningPlacement = rp;
        this.runFor = spell.getLastsFor();
    }

    public boolean isDead() {
        return remainingCooldown <= 0 && runFor <= 0;
    }

    public void turn() {
        remainingCooldown--;
        runFor--;
    }

    public Spell getSpell() {
        return originalSpell;
    }

    public boolean hasEffect() {
        return runFor > 0;
    }

}
