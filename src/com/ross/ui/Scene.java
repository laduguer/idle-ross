package com.ross.ui;

import com.ross.game.Game;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Scene extends JPanel {

    private List<Skill> skills;

    public Scene(Game game) {

        setLayout(new GridLayout(1,2));

       add(new CurrentStatsPanel(game));
       add(new ActivitySelectorPanel(game));
    }

}
