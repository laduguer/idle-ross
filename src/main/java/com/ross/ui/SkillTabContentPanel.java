package com.ross.ui;

import com.ross.game.Game;

import javax.swing.*;
import java.awt.*;

public class SkillTabContentPanel extends JPanel {
    public SkillTabContentPanel(Game game) {
        setLayout(new BorderLayout(2, 2));
        add(new CurrentStatsPanel(game), BorderLayout.CENTER);
        add(new ActivitySelectorPanel(game), BorderLayout.EAST);
    }
}
