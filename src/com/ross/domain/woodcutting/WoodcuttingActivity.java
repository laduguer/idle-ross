package com.ross.domain.woodcutting;

import com.ross.domain.Activity;
import com.ross.domain.player.Player;
import com.ross.game.ItemId;

public abstract class WoodcuttingActivity implements Activity {


    @Override
    public boolean playerHasRequirements() {
        return Player.woodcuttingLevel() >= levelRequired();
    }


    @Override
    public void applyProgress(Player player) {
        player.addWoodcuttExp(expPerTick());
        player.addItem(ItemId.NORMAL_LOGS);
    }

    protected abstract int expPerTick();

    protected abstract int levelRequired();
}
