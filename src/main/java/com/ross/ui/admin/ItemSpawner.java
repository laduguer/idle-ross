package com.ross.ui.admin;

import com.ross.game.Game;
import com.ross.game.ItemId;

import javax.swing.*;
import java.awt.*;

public class ItemSpawner extends JPanel {

    private JTextField itemName;
    private Game game;


    public ItemSpawner(Game game) {
        this.game = game;
        add(new JLabel("Spawnhack"));
        itemName = new JTextField();
        itemName.setPreferredSize(new Dimension(100, 20));
        add(itemName);

        add(spawnButton(1, "1"));
        add(spawnButton(1000, "1K"));
        add(spawnButton(1000000, "1M"));
        updateUI();
    }

    private JButton spawnButton(int amount, String text) {
        JButton button = new JButton(text);
        button.addActionListener(e -> {

            ItemId itemId = ItemId.valueOf(itemName.getText());


            game.addItem(itemId, amount);
            updateUI();
        });
        return button;
    }
}
