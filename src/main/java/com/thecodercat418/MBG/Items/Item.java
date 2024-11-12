package com.thecodercat418.MBG.Items;

import com.thecodercat418.MBG.SpellEffect;

import javafx.scene.image.Image;

public class Item {
    public String name;
    public SpellEffect effect;
    public Image image;
    public String description;

    public Item(String name, SpellEffect effect, String description){
        this.name = name;
        this.effect = effect;
        this.description = description;
    }
    public Item(String name, SpellEffect effect, String description, Image image){
        this.name = name;
        this.effect = effect;
        this.image = image;
        this.description = description;
    }
}
