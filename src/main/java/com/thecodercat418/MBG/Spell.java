package com.thecodercat418.MBG;

public class Spell {
    public String spellName;
    public int manaNeeded;
    public int wandLevelNeeded;
    public int turnCooldown;
    public int lastsFor;
    public RunningPlacement runningPlacement;
    public String damage;
    public DamageTypes damageType;

    public String defence;
    public DamageTypes protectionType;

    public boolean direct = true;

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

}
