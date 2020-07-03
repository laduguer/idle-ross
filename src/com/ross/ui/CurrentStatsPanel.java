package com.ross.ui;

import com.ross.game.Game;
import com.sun.deploy.jardiff.JarDiffPatcher;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CurrentStatsPanel  extends JPanel {

    public CurrentStatsPanel(Game game) {

        add(new Skill("Attack", game));
        add(new Skill("Strength", game));
        add(new Skill("Defence", game));
        add(new Skill("Ranged", game));
        add(new Skill("Prayer", game));
        add(new Skill("Magic", game));
        add(new Skill("Constitution", game));
        add(new Skill("Crafting", game));
        add(new Skill("Mining", game));
        add(new Skill("Smithing", game));
        add(new Skill("Fishing", game));
        add(new Skill("Cooking", game));
        add(new Skill("Firemaking", game));
        add(new Skill("Woodcutting", game));
        add(new Skill("Runecrafting", game));
        add(new Skill("Dungeoneering", game));
        add(new Skill("Fletching", game));

        setLayout(new GridLayout(getComponentCount(), 1, 5, 5));

    }
}
