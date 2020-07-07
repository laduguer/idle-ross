package com.ross.ui;

import com.ross.domain.combat.CombatController;
import com.ross.domain.shops.ShopController;
import com.ross.game.Game;
import com.ross.ui.combat.CombatTabContentPanel;
import com.ross.ui.quests.QuestTabContentPanel;
import com.ross.ui.shops.ShopTabContentPanel;

import javax.swing.*;
import java.awt.*;

public class Scene extends JPanel {

    public Scene(Game game) {
        setLayout(new BorderLayout(2, 2));

        JTabbedPane jTabbedPane = new JTabbedPane();
        jTabbedPane.addTab("Skills", new SkillTabContentPanel(game));
        jTabbedPane.addTab("Quests", new QuestTabContentPanel(game));
        jTabbedPane.addTab("Shops", new ShopTabContentPanel(new ShopController(game)));
        jTabbedPane.addTab("Combat", new CombatTabContentPanel(new CombatController(game)));
        add(jTabbedPane, BorderLayout.CENTER);

        JPanel bottom = new JPanel();
        bottom.setLayout(new BorderLayout(2, 2));
        bottom.add(new InfoPanel(game.infoHolder()), BorderLayout.CENTER);
        bottom.add(new InventoryPanel(game.inventory()), BorderLayout.EAST);

        add(bottom, BorderLayout.SOUTH);
    }

}
