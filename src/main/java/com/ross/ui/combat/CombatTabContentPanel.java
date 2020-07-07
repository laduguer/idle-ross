package com.ross.ui.combat;

import com.ross.domain.combat.CombatController;
import com.ross.domain.combat.FightingActivity;
import com.ross.domain.combat.NPCId;

import javax.swing.*;
import java.awt.*;

public class CombatTabContentPanel extends JPanel {

    private CombatController combatController;

    public CombatTabContentPanel(CombatController combatController) {

        this.combatController = combatController;
        initialLayout();
    }


    public CombatController getCombatController() {
        return combatController;
    }

    public void startFighting(NPCId monster) {
        removeAll();
        setLayout(new GridLayout(0, 1, 5, 5));
        FightingActivitySpectatorPanel fightPanel = new FightingActivitySpectatorPanel(monster, this);
        add(fightPanel);

        FightingActivity fightingActivity = new FightingActivity(monster);
        combatController.getGame().setCurrentActivity(fightingActivity);

        fightingActivity.setUpdatesListener(fightPanel);


    }

    public void stopFighting(){
        initialLayout();
        getCombatController().getGame().clearActivity();
    }

    private void initialLayout() {
        removeAll();
        setLayout(new GridLayout(0, 1, 5, 5));
        MonsterOverviewPanel shopOverview = new MonsterOverviewPanel(combatController.getMonstersViewModel(), this);
        add(shopOverview);
    }

}
