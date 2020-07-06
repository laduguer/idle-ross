package com.ross.domain.player;

import com.ross.domain.ExpTable;
import com.ross.game.Inventory;
import com.ross.game.ItemId;
import com.ross.game.Skills;

import java.util.HashMap;

public class Player {

    static HashMap<Skills,Integer> skillTable = new HashMap<>();

    private Inventory inventory;


    public Player() {
        this.inventory = Inventory.withStartingItems();

        for (Skills skill: Skills.values()) {
            skillTable.put(skill, 0);
        }
    }

    public static int getLevel(Skills skill) {
        return ExpTable.lvlAt(skillTable.get(skill));
    }

    public void addExp(int exp, Skills skill) {
        skillTable.put(skill, ((skillTable.get(skill))+ exp));
    }

    public static double percentageToNextLvl(Skills skill) {

        int currentLvl = ExpTable.lvlAt(skillTable.get(skill));
        int skillExp = skillTable.get(skill);
        int startExpOfLvl = ExpTable.expAt(currentLvl);
        int startExpOfNextLvl = ExpTable.expAt(currentLvl+1);

        int diff = startExpOfNextLvl - startExpOfLvl;
        int progress = skillExp - startExpOfLvl;
        return ((double)progress) / (double)diff;
    }

    public void addItem(ItemId item) {
        this.addItem(item, 1);
    }

    public Inventory inventory() {
        return inventory;
    }

    public void addItem(ItemId item, int amount) {
        inventory.addItems(item, amount);
    }
}
