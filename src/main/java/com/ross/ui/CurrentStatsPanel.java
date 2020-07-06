package com.ross.ui;

import com.ross.game.Skill;

import javax.swing.*;
import java.awt.*;

public class CurrentStatsPanel  extends JPanel {

    public CurrentStatsPanel() {
        for (Skill skill: Skill.values()) {
            add(new SkillPanel(skill));
        }
        setLayout(new GridLayout(getComponentCount(), 1, 5, 5));
    }
}
