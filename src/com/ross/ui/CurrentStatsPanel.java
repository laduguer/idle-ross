package com.ross.ui;

import com.ross.game.Game;
import com.ross.game.Skills;

import javax.swing.*;
import java.awt.*;

public class CurrentStatsPanel  extends JPanel {

    public CurrentStatsPanel(Game game) {

        for (Skills skill: Skills.values()) {
            add(new SkillPanel(skill, game));
        }

        setLayout(new GridLayout(getComponentCount(), 1, 5, 5));

    }
}
