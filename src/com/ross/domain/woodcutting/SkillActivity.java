package com.ross.domain.woodcutting;

import com.ross.domain.Activity;
import com.ross.domain.player.Player;
import com.ross.game.ItemId;

public class SkillActivity implements Activity {

    private String currentSkillName;
    private int expEach;
    private int requiredLvl;
    private ItemId itemId;


    public SkillActivity(String currentSkillName, int expEach, int requiredLvl, ItemId itemId){
        this.currentSkillName = currentSkillName;
        this.expEach = expEach;
        this.requiredLvl = requiredLvl;
        this.itemId = itemId;
    }

    @Override
    public boolean playerHasRequirements() {
        return Player.getLevel(currentSkillName) >= levelRequired();
    }


    @Override
    public void applyProgress(Player player) {
            player.addExp(expEach, currentSkillName);
            if(itemId != null) {
                player.addItem(itemId);
            }
    }

    protected int levelRequired(){
        return requiredLvl;
    }

}
