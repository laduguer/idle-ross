package com.ross.domain.player;

import com.ross.domain.ExpTable;
import com.ross.domain.quests.Quest;
import com.ross.domain.quests.QuestHolder;
import com.ross.game.*;
import com.ross.ui.quests.QuestProgressViewModel;

import java.util.HashMap;

public class Player {

    static HashMap<Skill,Integer> skillTable = new HashMap<>();

    private Inventory inventory;
    private QuestHolder questHolder;

    public Player() {
        this.inventory = Inventory.withStartingItems();

        for (Skill skill: Skill.values()) {
            skillTable.put(skill, 0);
        }
        questHolder = new QuestHolder();
    }

    public int getLevel(Skill skill) {
        return ExpTable.lvlAt(skillTable.get(skill));
    }

    public void addExp(int exp, Skill skill) {
        skillTable.put(skill, ((skillTable.get(skill))+ exp));
    }

    public static double percentageToNextLvl(Skill skill) {

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

    public boolean finishedQuest(Quest quest) {
        return questHolder.isFinished(quest);
    }

    public void tickQuest(Quest quest) {
        questHolder.tick(quest);
    }

    public void addQuestProgressListener(Quest quest, GenericValueUpdateListener<QuestProgressViewModel> listener) {
        questHolder.addQuestProgressListener(quest, listener);
    }

    public int availableGP() {
        return inventory.availableGP();
    }
}
