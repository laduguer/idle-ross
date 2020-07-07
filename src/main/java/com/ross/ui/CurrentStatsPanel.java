package com.ross.ui;

import com.ross.game.Game;
import com.ross.game.Skill;

import javax.swing.*;
import java.awt.*;

public class CurrentStatsPanel  extends JPanel {

    public CurrentStatsPanel(Game game) {
        for (Skill skill: Skill.values()) {
            add(new SkillPanel(skill, game.player()));
        }
        setLayout(new GridLayout(getComponentCount(), 1, 5, 5));
    }
}
