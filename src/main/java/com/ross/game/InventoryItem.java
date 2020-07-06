package com.ross.game;

public class InventoryItem {


    private int amount;
    private ItemId item;

    public InventoryItem(int amount, ItemId item) {
        this.amount = amount;
        this.item = item;
    }

    public void plusAmount(int diff){
        amount+= diff;
    }

    public ItemId getItem() {
        return item;
    }

    public int getAmount() {
        return amount;
    }
}
