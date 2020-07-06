package com.ross.domain.woodcutting;

import com.ross.domain.Activity;
import com.ross.domain.player.Player;
import com.ross.game.ItemId;
import com.ross.game.Skill;

public class SkillActivity implements Activity {

    private final Skill currentSkill;
    private final int expEach;
    private final int requiredLvl;
    private final ItemId itemId;


    public SkillActivity(Skill currentSkill, int expEach, int requiredLvl, ItemId itemId){
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
