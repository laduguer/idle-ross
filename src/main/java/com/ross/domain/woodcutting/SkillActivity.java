package com.ross.domain.woodcutting;

import com.ross.domain.Activity;
import com.ross.domain.player.Player;
import com.ross.game.ItemId;
import com.ross.game.Skills;

public class SkillActivity implements Activity {

    private Skills currentSkill;
    private int expEach;
    private int requiredLvl;
    private ItemId itemId;


    public SkillActivity(Skills currentSkill, int expEach, int requiredLvl, ItemId itemId){
        this.currentSkill = currentSkill;
        this.expEach = expEach;
        this.requiredLvl = requiredLvl;
        this.itemId = itemId;
    }

    @Override
    public boolean playerHasRequirements() {
        return Player.getLevel(currentSkill) >= levelRequired();
    }


    @Override
    public void applyProgress(Player player) {
            player.addExp(expEach, currentSkill);
            if(itemId != null) {
                player.addItem(itemId);
            }
    }

    protected int levelRequired(){
        return requiredLvl;
    }

}
