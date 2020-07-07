package com.ross.domain.combat;

import com.ross.domain.Activity;
import com.ross.domain.player.Player;
import com.ross.game.GenericValueUpdateListener;
import com.ross.game.ItemId;
import com.ross.game.Skill;
import com.ross.ui.combat.FightingActivitySpectatorPanel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FightingActivity implements Activity {


    private NPCId monsterId;
    private NPC currentEnemy;
    private List<GenericValueUpdateListener<OngoingFightViewModel>> listeners = new ArrayList<>();

    public FightingActivity(NPCId monsterId) {
        this.monsterId = monsterId;
        spawnMonster();
    }

    private void spawnMonster() {
        currentEnemy = NPCCreator.createFor(monsterId);
    }

    @Override
    public boolean canStartActivity(Player player) {
        return true;
    }


    int weaponSpeedInTicks = 3;
    int tickCount;

    @Override
    public void onTick(Player player) {
        tickCount ++;
        tickCount = tickCount%weaponSpeedInTicks;
        if(tickCount == 0){
            handleAttack(player, currentEnemy);
            if(currentEnemy.dead()){
                giveLoot(player, monsterId);
                spawnMonster();
            }
            notifyListeners();
        }


    }

    private void notifyListeners() {

        OngoingFightViewModel model = buildModel(currentEnemy);
        listeners.forEach(listener -> listener.updated(model));
    }

    private OngoingFightViewModel buildModel(NPC currentEnemy) {
        return new OngoingFightViewModel(currentEnemy.maxHp, currentEnemy.currentHp);
    }

    private void handleAttack(Player player, NPC currentEnemy) {
        int dmg = determinedamage(player, currentEnemy);
        currentEnemy.takeDamage(dmg);
        player.addExp(dmg*4, Skill.STRENGTH);
        player.addExp(dmg*2, Skill.HITPOINTS);


    }

    private int determinedamage(Player player, NPC currentEnemy) {
        return Math.min(currentEnemy.currentHp, 1+new Random().nextInt(player.getLevel(Skill.STRENGTH)));
    }

    private void giveLoot(Player player, NPCId monsterId) {
        DropTable.giveLoot(player, monsterId);

    }

    public void setUpdatesListener(GenericValueUpdateListener<OngoingFightViewModel> listener) {
        listeners.add(listener);
    }
}
