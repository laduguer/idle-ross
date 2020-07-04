package com.ross.domain.player;

import com.ross.domain.ExpTable;
import com.ross.game.Inventory;
import com.ross.game.ItemId;

public class Player {

    private static int wcExp = 0;
    private Inventory inventory;


    public Player() {
        this.inventory = Inventory.withStartingItems();
    }

    public static int woodcuttingLevel() {
        return ExpTable.lvlAt(wcExp);

    }

    public void addWoodcuttExp(int exp) {
        wcExp += exp;
    }

    public static double woodcuttPercentageToNextLvl() {
        int currentLvl = ExpTable.lvlAt(wcExp);
        int startExpOfLvl = ExpTable.expAt(currentLvl);
        int startExpOfNextLvl = ExpTable.expAt(currentLvl+1);

        int diff = startExpOfNextLvl - startExpOfLvl;
        int progress = wcExp - startExpOfLvl;
        return ((double)progress) / (double)diff;


    }

    public  void addItem(ItemId item) {
        inventory.addItems(item, 1);
    }

    public Inventory inventory() {
        return inventory;
    }
}
