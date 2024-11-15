package com.thecodercat418.MBG;

public class SpellEffect {
    private Spell originalSpell;
    private int remainingCooldown;
    private RunningPlacement runningPlacement;
    private int turnCooldown;
    private int runFor;

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

    public boolean hasEffect() {
        return runFor > 0;
    }

    public Spell getOriginalSpell() {
        return originalSpell;
    }

    public int getRemainingCooldown() {
        return remainingCooldown;
    }

    public RunningPlacement getRunningPlacement() {
        return runningPlacement;
    }

    public int getTurnCooldown() {
        return turnCooldown;
    }

    public int getRunFor() {
        return runFor;
    }
}
