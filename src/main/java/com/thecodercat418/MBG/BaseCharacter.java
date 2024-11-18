package com.thecodercat418.MBG;

import java.util.ArrayList;

public class BaseCharacter {
    private int maxHealth = 100;
    private int health = maxHealth;
    private int defence = 0;
    private boolean dead = false;
    private String name;
    private int coins = 100;
    private ArrayList<SpellEffect> spellEffects = new ArrayList<>();
    ArrayList<Item> items = new ArrayList<>();
    public boolean usedItem = false;

    public BaseCharacter(String name, int health, int defence) {
        this.health = health;
        this.name = name;
        this.defence = defence;
    }

    public BaseCharacter(String name) {
        this.name = name;
    }

    public void modifyHealth(String healthModifier) {
        // Defence modifiers ... mainly from SpellEffects
        if (healthModifier.charAt(0) == '-' && !dead) {
            if (defence >= Integer.parseInt(healthModifier.substring(1))) {
                defence -= Integer.parseInt(healthModifier.substring(1));
            } else {
                health = health - Integer.parseInt(healthModifier.substring(1)) + defence;
                defence = 0;
            }
        }else if(healthModifier.charAt(0) == '+' && !dead){
            health += Integer.parseInt(healthModifier.substring(1));
        }

        if (health <= 0) {
            dead = true;
            health = 0;
        }
    }

    public void proccessSpell(Spell spell) {
        // Defence Proccess
        modifyHealth(spell.getDamage());
        // Damage Proccess

    }

    public void runningPlacementUpdate(RunningPlacement rp) {

    }

    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void BEFORE_TURN(boolean attacker) {
        // passive healing
    }

    public void BEFORE_ATTACK(boolean attacker) {

    }

    public void AFTER_ATTACK(boolean attacker) {

    }

    public void AFTER_TURN(boolean attacker) {
        if (!attacker) {
            return;
        }
        for (int i = spellEffects.size() - 1; i >= 0; i--) {
            proccessSpell(spellEffects.get(i).getOriginalSpell());
            spellEffects.get(i).turn();
            if (spellEffects.get(i).isDead()) {
                spellEffects.remove(i);
            }
        }
    }

    public void addSpellEffect(SpellEffect se) {
        spellEffects.add(se);
    }

    public ArrayList<SpellEffect> getSpellEffects() {
        return spellEffects;
    }

    public int getCoins() {
        return coins;
    }

    public void changeCoins(int change) {
        coins = coins + change;
        if (coins < 0) {
            coins = 0;
        }
    }
}
