package com.ross.domain.woodcutting;

import com.ross.domain.Activity;
import com.ross.domain.player.Player;

public abstract class WoodcuttingActivity implements Activity {


    @Override
    public boolean playerHasRequirements() {
        return Player.woodcuttingLevel() >= levelRequired();
    }


    @Override
    public void applyProgress(Player player) {
        Player.addWoodcuttExp(100);
    }

    protected abstract int levelRequired();
}
