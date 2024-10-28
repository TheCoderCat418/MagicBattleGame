package com.thecodercat418.MBG;

import com.thecodercat418.MBG.Wands.Wand;

import java.util.ArrayList;

public class MagicCharacter extends BaseCharacter{
    private int mana;
    private ArrayList<Wand> wands = new ArrayList<>();
    private Wand currentWand;

    public MagicCharacter(){

    }

    public boolean addWand(Wand wand){
        for(Wand wand2 : wands){
            if(wand.getName().equals(wand2.getName())){
                return false;
            }
        }
        wands.add(wand);
        currentWand = wand;
        return true;
    }

    public boolean equipWand(Wand wand){
        for(Wand wand2 : wands){
            if(wand.equals(wand2)){
                currentWand = wand;
                return true;
            }
        }
        return false;
    }

    public Wand getCurrentWand(){
        return currentWand;
    }
    public void castSpell(String spellName, BaseCharacter victim){
        for(Spell spell : currentWand.getSpells()){
            if(spell.spellName.equals(spellName)){
                currentWand.castSpell(victim, spell);
            }
        }
        
    }
}
