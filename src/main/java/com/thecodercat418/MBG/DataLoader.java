package com.thecodercat418.MBG;

import java.util.ArrayList;

public class DataLoader {
    public static ArrayList<ShopItem> getAllShopItemPosibilies(){
        ArrayList<ShopItem> list = new ArrayList<>();
        list.add(new ShopItem(getAllItemPosibilities().get(0), 20, 4));
        list.add(new ShopItem(getAllItemPosibilities().get(1), 20, 4));
        list.add(new ShopItem(getAllItemPosibilities().get(2), 50, 2));
        list.add(new ShopItem(getAllItemPosibilities().get(3), 10, 7));
        list.add(new ShopItem(getAllItemPosibilities().get(4), 15, 5));
        return list;
    }

    // public static ArrayList<ShopItem> getRandomShopItems(int numberOfDiffrentItems, int maxItemsPerStack, int maxTotalItems, int luck){
    //     ArrayList<ShopItem> list = new ArrayList<>();

    //     return list;
    // }

    public static ArrayList<MagicCharacter> getAllMagicCharacters(){
        ArrayList<MagicCharacter> list = new ArrayList<>();
        list.add(new MagicCharacter("Mana Man",100, 10, 15, 5));
        list.add(new MagicCharacter("The Rocker",50, 100, 10, 2));
        list.add(new MagicCharacter("Healthy Man",200, 0, 10, 2));
        list.add(new MagicCharacter("Trickle Charge",100, 10, 30, 1));
        list.add(new MagicCharacter("The Default",100, 20, 10, 3));
        return list;
    }

    public static ArrayList<Wand> getAllWandPosiblities(){
        ArrayList<Wand> list = new ArrayList<>();
        ArrayList<Spell> fireWandSpells = new ArrayList<>();
        fireWandSpells.add(new Spell("Campfire", 2, 0, 2, 0, RunningPlacement.AFTER_ATTACK, "-10", "+0", "+0", "+0"));
        fireWandSpells.add(new Spell("Fire Ball", 3, 0, 3, 0, RunningPlacement.AFTER_ATTACK, "-20", "+0", "+0", "+0"));
        fireWandSpells.add(new Spell("Gates of hell", 7, 0, 4, 0, RunningPlacement.AFTER_ATTACK, "-30", "+0", "+0", "+0"));
        list.add(new Wand(0, "Fire Wand", fireWandSpells));

        ArrayList<Spell> WaterWand = new ArrayList<>();
        WaterWand.add(new Spell("Fountain", 1, 0, 1, 0, RunningPlacement.AFTER_ATTACK, "-5", "+0", "+0", "+0"));
        WaterWand.add(new Spell("Geyser", 4, 0, 2, 0, RunningPlacement.AFTER_ATTACK, "-20", "+0", "+0", "+0"));
        WaterWand.add(new Spell("Tsunami", 8, 0, 5, 0, RunningPlacement.AFTER_ATTACK, "-40", "+0", "+0", "+0"));
        list.add(new Wand(0, "Water Wand", WaterWand));

        ArrayList<Spell> earthWand = new ArrayList<>();
        earthWand.add(new Spell("Pebble", 1, 0, 0, 0, RunningPlacement.AFTER_ATTACK, "-5", "+0", "+0", "+0"));
        earthWand.add(new Spell("Bolder", 3, 0, 0, 0, RunningPlacement.AFTER_ATTACK, "-15", "+0", "+0", "+0"));
        earthWand.add(new Spell("Land-Slide", 6, 0, 0, 0, RunningPlacement.AFTER_ATTACK, "-30", "+0", "+0", "+0"));
        list.add(new Wand(0, "Earth Wand", earthWand));

        return list;
    }

    public static ArrayList<Item> getAllItemPosibilities(){
        ArrayList<Item> list = new ArrayList<>();
        list.add(new Item("Health Poition", new SpellEffect(new Spell("ITEM_HEALTH_POITION", 0, 0, 0, 3, RunningPlacement.AFTER_ATTACK, "+20", "+10", "+0", "+0"), RunningPlacement.AFTER_ATTACK), ""));
        list.add(new Item("Defence Poition", new SpellEffect(new Spell("ITEM_DEFENCE_POITION", 0, 0, 0, 3, RunningPlacement.AFTER_ATTACK, "+0", "+0", "+20", "+10"), RunningPlacement.AFTER_ATTACK), ""));
        list.add(new Item("The Strawberry Shortcake", new SpellEffect(new Spell("ITEM_HEALTH_POITION", 0, 0, 0, 0, RunningPlacement.AFTER_ATTACK, "+40", "+0", "+0", "+0"), RunningPlacement.AFTER_ATTACK), ""));
        list.add(new Item("The Cupcake", new SpellEffect(new Spell("ITEM_HEALTH_POITION", 0, 0, 0, 0, RunningPlacement.AFTER_ATTACK, "+10", "+0", "+0", "+0"), RunningPlacement.AFTER_ATTACK), ""));
        list.add(new Item("Rock Shield", new SpellEffect(new Spell("ITEM_DEFENCE_POITION", 0, 0, 0, 0, RunningPlacement.AFTER_ATTACK, "+0", "+0", "+20", "+0"), RunningPlacement.AFTER_ATTACK), ""));
        return list;
    }
}
