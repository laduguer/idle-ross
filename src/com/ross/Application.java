package com.ross;

import com.ross.game.Game;
import com.ross.ui.Scene;

import javax.swing.*;
import java.awt.*;

public class Application extends JFrame {

   private Game game;
    public Application() {

        game = initGame();
        initUI(game);
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
            new Thread(() -> {
                while (true) {
                    try {
                        Thread.sleep(600);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ex.tickGame();
                }
            }).start();
        });
    }


}
