package com.thecodercat418.MBG;

import com.thecodercat418.MBG.Items.Item;
import com.thecodercat418.MBG.Wands.Wand;


import java.util.ArrayList;

public class BaseCharacter{
    private int health = 100;
    private int defence = 0;
    private boolean dead = false;
    ArrayList<Item> items = new ArrayList<>();

    public void modifyHealth(String healthModifier){
        if(healthModifier.charAt(0) == '-'){
            health -= Integer.parseInt(healthModifier.substring(1));
        }

        if(health<=0){
            dead = true;
        }
    }

    public int getHealth(){
        return health;
    }


}
