package com.ross.game;

import com.ross.domain.Activity;
import com.ross.domain.player.Player;

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
            currentActivity.applyProgress(player);
        }
    }

    public void setCurrentActivity(Activity activity) {
        if(activity.playerHasRequirements()) {
            currentActivity = activity;
            infoHolder.addInfo("started activity");
        }else{
            infoHolder.addWarning("pipo, uw level is ni hoog genoeg om da te doen");
        }
    }

    public InfoHolder infoHolder() {
        return infoHolder;
    }

    public Inventory inventory() {
        return player.inventory();
    }
}
