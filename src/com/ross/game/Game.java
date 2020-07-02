package com.ross.game;

import com.ross.domain.Activity;
import com.ross.domain.player.Player;
import com.ross.domain.woodcutting.ChoppingTrees;

public class Game {


    private Player player;
    private Activity currentActivity;


    public Game() {
        player = new Player();
    }


    public void tick() {
        if(currentActivity != null){
            currentActivity.applyProgress(player);
        }
    }

    public void setCurrentActivity(Activity activity) {
        currentActivity = activity;
    }
}
