package com.ross.domain.rewards;

import com.ross.domain.player.Player;
import com.ross.game.ItemId;

public class ItemReward implements Reward {

    private ItemId item;
    private int amount;

    @Override
    public void applyTo(Player player) {
        player.addItem(item, amount);
    }
}
