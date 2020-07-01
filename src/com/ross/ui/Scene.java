package com.ross.ui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Scene extends JPanel {

    private List<Skill> skills;

    public Scene() {
        skills = new ArrayList<>();
        skills.add(new Skill("Attack"));
        skills.add(new Skill("Strength"));
        skills.add(new Skill("Defence"));
        skills.add(new Skill("Ranged"));
        skills.add(new Skill("Prayer"));
        skills.add(new Skill("Magic"));
        skills.add(new Skill("Constitution"));
        skills.add(new Skill("Crafting"));
        skills.add(new Skill("Mining"));
        skills.add(new Skill("Smithing"));
        skills.add(new Skill("Fishing"));
        skills.add(new Skill("Cooking"));
        skills.add(new Skill("Firemaking"));
        skills.add(new Skill("Woodcutting"));
        skills.add(new Skill("Runecrafting"));
        skills.add(new Skill("Dungeoneering"));
        skills.add(new Skill("Fletching"));

        setLayout(new GridLayout(skills.size(),1,5,5));

        for (int i = 0; i < skills.size(); i++) {
            add(skills.get(i));
        }
    }

}
