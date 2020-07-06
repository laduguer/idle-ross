package com.ross.ui;

import com.ross.domain.Activity;
import com.ross.domain.woodcutting.SkillActivity;
import com.ross.game.Game;
import com.ross.game.ItemId;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ActivitySelectorPanel extends JPanel {

    public ActivitySelectorPanel(Game game) {

        add(createActivityButton(game, "Chop normal trees", new SkillActivity("woodcutting", 25, 1, ItemId.NORMAL_LOGS)));
        add(createActivityButton(game, "Chop oak trees", new SkillActivity("woodcutting", 37, 15, ItemId.OAK_LOGS)));
        add(createActivityButton(game, "Chop willow trees", new SkillActivity("woodcutting", 67, 30, ItemId.WILLOW_LOGS)));
        add(createActivityButton(game, "Mine Copper", new SkillActivity("mining", 17, 1, ItemId.COPPER_ORE)));
        add(createActivityButton(game, "Mine Tin", new SkillActivity("mining", 17, 1, ItemId.TIN_ORE)));
        add(createActivityButton(game, "Mine Iron", new SkillActivity("mining", 35, 15, ItemId.IRON_ORE)));
        add(createActivityButton(game, "Fish Shrimps", new SkillActivity("fishing", 5, 1, ItemId.SHRIMPS)));
        add(createActivityButton(game, "Fish Trout", new SkillActivity("fishing", 50, 27, ItemId.TROUT)));
        add(createActivityButton(game, "Fish Salmon", new SkillActivity("fishing", 70, 54, ItemId.SALMON)));

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
