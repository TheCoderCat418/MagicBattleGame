package com.thecodercat418.MBG.Wands;

import java.util.ArrayList;

public class FireWand extends Wand{
    private ArrayList<WandLevel> wandLevels = new ArrayList<>();
    public FireWand(){
        super("Fire Wand");
        System.out.println(name);
    }
}
