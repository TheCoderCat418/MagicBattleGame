package com.thecodercat418.MBG;

import javafx.scene.image.Image;

public class Item {
    private String name;
    private SpellEffect effect;
    private Image image;
    private String description;

    public Item(String name, SpellEffect effect, String description) {
        this.name = name;
        this.effect = effect;
        this.description = description;
    }

    public Item(String name, SpellEffect effect, String description, Image image) {
        this.name = name;
        this.effect = effect;
        this.image = image;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public SpellEffect getEffect() {
        return effect;
    }

    public Image getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }
}
