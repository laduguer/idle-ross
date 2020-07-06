package com.ross.ui;

import com.ross.game.Game;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Scene extends JPanel {

    public Scene(Game game) {
        setLayout(new BorderLayout(2, 2));

        JTabbedPane jTabbedPane = new JTabbedPane();
        jTabbedPane.addTab("Skills", new SkillTabContentPanel(game));
        jTabbedPane.addTab("Quests", new QuestTabContentPanel(game));
        add(jTabbedPane, BorderLayout.CENTER);

        JPanel bottom = new JPanel();
        bottom.setLayout(new BorderLayout(2, 2));
        bottom.add(new InfoPanel(game.infoHolder()), BorderLayout.CENTER);
        bottom.add(new InventoryPanel(game.inventory()), BorderLayout.EAST);

        add(bottom, BorderLayout.SOUTH);
    }

}
