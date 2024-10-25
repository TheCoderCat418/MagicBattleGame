package com.thecodercat418.MBG;

import com.thecodercat418.MBG.Wands.Wand;


public class Spell {
    public String spellName;
    public int wandLevelNeeded;
    public int turnCooldown;
    public int lastsFor;
    public String damage;
    public DamageTypes damageType;

    public String defence;
    public DamageTypes protectionType;


    public Spell(String spellName, int wandLevelNeeded, int turnCooldown, int lastsFor, String damage, DamageTypes damageType, String defence, DamageTypes protectionType) {
        this.spellName = spellName;
        this.wandLevelNeeded = wandLevelNeeded;
        this.turnCooldown = turnCooldown;
        this.damage = damage;
        this.damageType = damageType;
        this.lastsFor = lastsFor;
        this.defence = defence;
        this.protectionType = protectionType;
    }
}
