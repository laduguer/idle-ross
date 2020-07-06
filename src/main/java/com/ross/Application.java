package com.ross;

import com.ross.game.Game;
import com.ross.ui.admin.AdminFrame;
import com.ross.ui.Scene;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class Application extends JFrame {

    private static Thread tickThread;
    private Game game;
    private static AtomicBoolean tickSleep = new AtomicBoolean(true);

    public Application() {

        game = initGame();
        initUI(game);
        initAdminUI(game);
    }

    private void initAdminUI(Game game) {
        new AdminFrame(this, game, tickSleep).init();
    }

    private Game initGame() {
        return new Game();
    }


    private void tickGame() {
        game.tick();
        EventQueue.invokeLater(() -> {
            repaint();
        });
    }

    private void initUI(Game game) {
        add(new Scene(game));
        setSize(1024, 768);
        setTitle("ROSS");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Application ex = new Application();
            ex.setVisible(true);
            tickThread = new Thread(() -> {
                while (true) {
                    if (tickSleep.get()) {
                        try {
                            Thread.sleep(600);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    ex.tickGame();
                }
            });
            tickThread.start();
        });
    }


}
