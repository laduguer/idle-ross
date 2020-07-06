package com.ross.ui.admin;

import com.ross.game.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.atomic.AtomicBoolean;

public class AdminFrame extends JDialog {
    private Game game;
    private AtomicBoolean tickSleep;

    public AdminFrame(JFrame parent, Game game, AtomicBoolean tickSleep) {
        super(parent);
        this.game = game;
        this.tickSleep = tickSleep;
    }

    public void init() {
        setMinimumSize(new Dimension(200, 300));
        setTitle("ROSS- Admint");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        add(new AdminPanel(game, tickSleep));

        setVisible(true);
        pack();
    }


}
