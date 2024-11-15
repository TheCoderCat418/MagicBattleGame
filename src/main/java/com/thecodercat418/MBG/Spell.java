package com.thecodercat418.MBG;

public class Spell {
    private String spellName;
    private int manaNeeded;
    private int wandLevelNeeded;
    private int turnCooldown;
    private int lastsFor;
    private RunningPlacement runningPlacement;
    private String damage;
    private String SEDamage;
    private String defence;
    private String SEDefence;

    private boolean direct = true;

    public Spell(String spellName, int manaNeeded, int wandLevelNeeded, int turnCooldown, int lastsFor,
            RunningPlacement runningPlacement, String damage, String SEDamage, String defence, String SEDefence) {
        this.spellName = spellName;
        this.manaNeeded = manaNeeded;
        this.wandLevelNeeded = wandLevelNeeded;
        this.turnCooldown = turnCooldown;
        this.lastsFor = lastsFor;
        this.runningPlacement = runningPlacement;
        this.damage = damage;
        this.SEDamage = SEDamage;
        this.defence = defence;
        this.SEDefence = SEDefence;
    }

    public void setDirect(boolean direct) {
        this.direct = direct;
    }

    public String getSpellName() {
        return spellName;
    }

    public int getManaNeeded() {
        return manaNeeded;
    }

    public int getWandLevelNeeded() {
        return wandLevelNeeded;
    }

    public int getTurnCooldown() {
        return turnCooldown;
    }

    public int getLastsFor() {
        return lastsFor;
    }

    public RunningPlacement getRunningPlacement() {
        return runningPlacement;
    }

    public String getDamage() {
        return damage;
    }

    public String getDefence() {
        return defence;
    }

    public String getSEDamage() {
        return SEDamage;
    }

    public String getSEDefence() {
        return SEDefence;
    }

    public boolean isDirect() {
        return direct;
    }
}
