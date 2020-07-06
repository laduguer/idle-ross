package com.ross.domain.rewards;

import com.ross.domain.player.Player;
import com.ross.game.Skill;

public class ExpReward  implements  Reward{

    private Skill skill;
    private int exp;

    public ExpReward(Skill skill, int exp) {
        this.skill = skill;
        this.exp = exp;
    }

    @Override
    public void applyTo(Player player) {
        player.addExp(exp, skill);
    }
}
