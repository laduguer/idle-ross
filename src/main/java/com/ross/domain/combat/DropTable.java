package com.ross.domain.combat;

import com.ross.domain.player.Player;
import com.ross.game.ItemId;

import java.util.Random;

public class DropTable {


    public static void giveLoot(Player player, NPCId monsterId) {
        switch (monsterId) {
            case CHICKEN:
                player.addItem(ItemId.FEATHER, 3 + new Random().nextInt(4));
                return;
            case COW:
                player.addItem(ItemId.BONES, 1);
                player.addItem(ItemId.COWMEAT, 1);
                player.addItem(ItemId.COWHIDE, 1);
                return;
        }

        throw new RuntimeException("no loot configured for "+ monsterId);
    }
}
