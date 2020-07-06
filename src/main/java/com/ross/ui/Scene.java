package com.ross.ui;

import com.ross.game.Game;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Scene extends JPanel {

    private List<SkillPanel> skillPanels;

    public Scene(Game game) {
        setLayout(new BorderLayout(2, 2));


        add(new CurrentStatsPanel(game), BorderLayout.CENTER);
        add(new ActivitySelectorPanel(game), BorderLayout.EAST);

        JPanel bottom = new JPanel();
        bottom.setLayout(new BorderLayout(2, 2));
        bottom.add(new InfoPanel(game.infoHolder()), BorderLayout.CENTER);
        bottom.add(new InventoryPanel(game.inventory()), BorderLayout.EAST);

        add(bottom, BorderLayout.SOUTH);
    }

}
