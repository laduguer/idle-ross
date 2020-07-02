package com.ross.ui;

import com.ross.game.Game;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Scene extends JPanel {

    private List<Skill> skills;

    public Scene(Game game) {
        skills = new ArrayList<>();
        skills.add(new Skill("Attack", game));
        skills.add(new Skill("Strength", game));
        skills.add(new Skill("Defence", game));
        skills.add(new Skill("Ranged", game));
        skills.add(new Skill("Prayer", game));
        skills.add(new Skill("Magic", game));
        skills.add(new Skill("Constitution", game));
        skills.add(new Skill("Crafting", game));
        skills.add(new Skill("Mining", game));
        skills.add(new Skill("Smithing", game));
        skills.add(new Skill("Fishing", game));
        skills.add(new Skill("Cooking", game));
        skills.add(new Skill("Firemaking", game));
        skills.add(new Skill("Woodcutting", game));
        skills.add(new Skill("Runecrafting", game));
        skills.add(new Skill("Dungeoneering", game));
        skills.add(new Skill("Fletching", game));

        setLayout(new GridLayout(skills.size(),1,5,5));

        for (int i = 0; i < skills.size(); i++) {
            add(skills.get(i));
        }
    }

}
