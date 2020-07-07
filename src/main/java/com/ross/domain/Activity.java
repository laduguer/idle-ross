package com.ross.domain;

import com.ross.domain.player.Player;

public interface Activity {

    boolean canStartActivity(Player player);

    void onTick(Player player);

}