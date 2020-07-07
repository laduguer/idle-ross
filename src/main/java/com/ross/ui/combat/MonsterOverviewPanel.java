package com.ross.ui.combat;

import com.ross.domain.combat.MonsterOverviewViewModel;
import com.ross.ui.shops.ShopTabContentPanel;

import javax.swing.*;
import java.awt.*;

public class MonsterOverviewPanel extends JPanel {

    private final CombatTabContentPanel parent;

    public MonsterOverviewPanel(MonsterOverviewViewModel availableMonsters, CombatTabContentPanel parent) {
        this.parent = parent;
        setLayout(new GridLayout(0, 1, 5, 5));

        availableMonsters.getMonsters().forEach(monsterModel -> {
            JButton button = new JButton("Fight " + monsterModel.getMonster() + "(lvl " + monsterModel.getLevel() + ")");

            button.addActionListener(e-> {
                parent.startFighting(monsterModel.getMonster());
            });


            add(button);
        });


    }


}
