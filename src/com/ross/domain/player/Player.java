package com.ross.domain.player;

import com.ross.domain.ExpTable;
import com.ross.game.Inventory;
import com.ross.game.ItemId;
import com.ross.ui.Skill;

import java.util.HashMap;

public class Player {

    static HashMap<String,String> skillTable = new HashMap<>();

    private Inventory inventory;


    public Player() {
        this.inventory = Inventory.withStartingItems();
        skillTable.put("woodcutting", "0");
        skillTable.put("mining", "0");
        skillTable.put("fishing", "0");
        skillTable.put("attack", "0");
        skillTable.put("strength", "0");
        skillTable.put("defence", "0");
        skillTable.put("ranged", "0");
        skillTable.put("prayer", "0");
        skillTable.put("magic", "0");
        skillTable.put("constitution", "0");
        skillTable.put("crafting", "0");
        skillTable.put("smithing", "0");
        skillTable.put("cooking", "0");
        skillTable.put("firemaking", "0");
        skillTable.put("runecrafting", "0");
        skillTable.put("dungeoneering", "0");
        skillTable.put("fletching", "0");

    }

    public static int getLevel(String skillName) {
        return ExpTable.lvlAt(Integer.parseInt(skillTable.get(skillName)));
    }

    public void addExp(int exp, String skillName) {
        skillTable.put(skillName, String.valueOf((Integer.parseInt(skillTable.get(skillName))) + exp));
    }

    public static double percentageToNextLvl(String skillName) {

        int currentLvl = ExpTable.lvlAt(Integer.parseInt(skillTable.get(skillName)));
        int skillExp = Integer.parseInt(skillTable.get(skillName));
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
