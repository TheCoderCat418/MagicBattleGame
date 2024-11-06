package com.thecodercat418.MBG.Items;

import com.thecodercat418.MBG.SpellEffect;

import javafx.scene.image.Image;

public class Item {
    public String name;
    public SpellEffect effect;
    public Image image;

    public Item(String name, SpellEffect effect){
        this.name = name;
        this.effect = effect;
    }
    public Item(String name, SpellEffect effect, Image image){
        this.name = name;
        this.effect = effect;
        this.image = image;
    }
}
