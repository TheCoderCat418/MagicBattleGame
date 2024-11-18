package com.thecodercat418.MBG;

public class ShopItem {
    private Item item;
    private int price;
    private int quatity;

    public ShopItem(Item item, int price, int quatity) {
        this.item = item;
        this.price = price;
        this.quatity = quatity;
    }

    public Item getItem() {
        return item;
    }

    public int getPrice() {
        return price;
    }

    public int getQuatity() {
        return quatity;
    }

    public void itemTaken(){
        quatity--;
    }
}
