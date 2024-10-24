package com.thecodercat418.MBG;

import com.thecodercat418.MBG.Items.Item;
import com.thecodercat418.MBG.Wands.Wand;


import java.util.ArrayList;

abstract class BaseCharacter{
    int health = 0;
    ArrayList<Item> items = new ArrayList<>();



    abstract void attack(BaseCharacter characterBeingAttacked);
}
