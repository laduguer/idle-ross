package com.ross.ui.admin;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.atomic.AtomicBoolean;

public class TimeSkipper extends JPanel {
    public TimeSkipper(AtomicBoolean tickSleep) {
        JButton fastForwardButton = new JButton("fast forward");
        fastForwardButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                tickSleep.set(false);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                tickSleep.set(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        add(fastForwardButton);
    }
}
