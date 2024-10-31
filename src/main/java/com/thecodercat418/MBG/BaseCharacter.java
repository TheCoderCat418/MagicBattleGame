package com.thecodercat418.MBG;

import com.thecodercat418.MBG.Items.Item;

import java.util.ArrayList;

public class BaseCharacter{
    private int maxHealth = 100;
    private int health = 100;
    private int defence = 0;
    private float defenceProtection = 0.5f;
    private boolean dead = false;
    private String name;
    ArrayList<Item> items = new ArrayList<>();

    public BaseCharacter(String name, int health, int defence){
        this.health = health;
        this.name = name;
        this.defence = defence;
    }
    public BaseCharacter(String name){
        this.name = name;
    }
    public void modifyHealth(String healthModifier){
        if(healthModifier.charAt(0) == '-' && !dead){
            int damageToTake = Integer.parseInt(healthModifier.substring(1));
            int maxProtection = Integer.parseInt(healthModifier.substring(1)) * defenceProtection;
            int protected = 0;
            if(damageToTake-maxProtection)
            
            
            if(defence-maxProtection<0)
        }

        if(health<=0){
            dead = true;
            health = 0;
        }
    }

    public int getHealth(){
        return health;
    }

    public String getName(){
        return name;
    }

    public int getMaxHealth(){
        return maxHealth;
    }

    public void finishTurn(){
        //passive healing
    }
    public void startTurn(){
        //passive healing
    }


}
