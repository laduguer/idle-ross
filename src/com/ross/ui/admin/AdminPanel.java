package com.ross.ui.admin;

import com.ross.game.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.atomic.AtomicBoolean;

public class AdminPanel extends JPanel {


    private final Game game;
    private final AtomicBoolean tickSleep;

    public AdminPanel(Game game, AtomicBoolean tickSleep) {
        this.game = game;
        this.tickSleep = tickSleep;

        setLayout(new GridLayout(10,1,2,2));

        add(new TimeSkipper(tickSleep));
        add(new ItemSpawner(game));
    }



}
