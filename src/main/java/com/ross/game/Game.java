package com.ross.game;

import com.ross.domain.Activity;
import com.ross.domain.player.Player;
import com.ross.domain.quests.Quest;
import com.ross.ui.quests.QuestProgressViewModel;

public class Game {


    private Player player;
    private Activity currentActivity;
    private InfoHolder infoHolder;


    public Game() {
        player = new Player();
        infoHolder = new InfoHolder();
    }

    public void addItem(ItemId item, int amount){
        player.addItem(item, amount);
    }

    public void tick() {
        infoHolder.tick();
        if(currentActivity != null){
            currentActivity.onTick(player);
        }
    }

    public void setCurrentActivity(Activity activity) {
        if(activity.canStartActivity(player)) {
            currentActivity = activity;
            //activity.onStart(player);
            infoHolder.addInfo("started activity");
        }else{
            infoHolder.addWarning("pipo, uw level is ni hoog genoeg om da te doen (refactor mij naar startValidationResult)");
        }
    }

    public InfoHolder infoHolder() {
        return infoHolder;
    }

    public Inventory inventory() {
        return player.inventory();
    }

    public Player player() {
        return player;
    }

    public void activateQuestActivity(Quest quest) {
        setCurrentActivity(QuestActivities.forQuest(quest));
    }

    public void setQuestProgressListener(Quest quest, GenericValueUpdateListener<QuestProgressViewModel> listener) {
        player.addQuestProgressListener(quest, listener);
    }

    public void clearActivity() {
        this.currentActivity = null;
    }
}
