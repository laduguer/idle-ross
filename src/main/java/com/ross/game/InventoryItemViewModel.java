package com.ross.game;

public class InventoryItemViewModel {


    private int amount;
    private ItemId item;

    public InventoryItemViewModel(int amount, ItemId item) {
        this.amount = amount;
        this.item = item;
    }


    public ItemId getItem() {
        return item;
    }

    public int getAmount() {
        return amount;
    }
}
