package com.thecodercat418.MBG;

public class Spell {
    private String spellName;
    private int manaNeeded;
    private int wandLevelNeeded;
    private int turnCooldown;
    private int lastsFor;
    private RunningPlacement runningPlacement;
    private String damage;
    private DamageTypes damageType;

    private String defence;
    private DamageTypes protectionType;

    private boolean direct = true;

    public Spell(String spellName, int wandLevelNeeded, int turnCooldown, int lastsFor, String damage,
            DamageTypes damageType, String defence, DamageTypes protectionType, int manaNeeded,
            RunningPlacement runningPlacement) {
        this.spellName = spellName;
        this.wandLevelNeeded = wandLevelNeeded;
        this.turnCooldown = turnCooldown;
        this.damage = damage;
        this.damageType = damageType;
        this.lastsFor = lastsFor;
        this.defence = defence;
        this.protectionType = protectionType;
        this.manaNeeded = manaNeeded;
        this.runningPlacement = runningPlacement;
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

    public DamageTypes getDamageType() {
        return damageType;
    }

    public String getDefence() {
        return defence;
    }

    public DamageTypes getProtectionType() {
        return protectionType;
    }

    public boolean isDirect() {
        return direct;
    }
}
