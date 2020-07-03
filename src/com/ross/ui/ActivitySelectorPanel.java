package com.ross.ui;

import com.ross.domain.Activity;
import com.ross.domain.woodcutting.ChopOakTrees;
import com.ross.domain.woodcutting.ChopWillowTrees;
import com.ross.domain.woodcutting.ChoppingTrees;
import com.ross.game.Game;

import javax.swing.*;
import java.awt.*;

public class ActivitySelectorPanel extends JPanel {

    public ActivitySelectorPanel(Game game) {

        add(createActivityButton(game, "Chop normal trees", new ChoppingTrees()));
        add(createActivityButton(game, "Chop oak trees", new ChopOakTrees()));
        add(createActivityButton(game, "Chop willow trees", new ChopWillowTrees()));

        setLayout(new GridLayout(getComponentCount(), 1, 5, 5));

    }


    private JButton createActivityButton(Game game, String desciption, Activity activity) {
        JButton button = new JButton(desciption);
        button.addActionListener(e -> {
            game.setCurrentActivity(activity);
            updateUI();
        });
        button.setVisible(true);
        return button;
    }
}
