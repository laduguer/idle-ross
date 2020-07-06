package com.ross.ui;

import com.ross.domain.player.Player;
import com.ross.game.Game;
import com.ross.game.Skill;

import javax.swing.*;
import java.awt.*;

public class SkillPanel extends JPanel {

    public static final Font HELVETICA_14 = new Font("Helvetica", Font.PLAIN, 14);
    public static final Font HELVETICA_25 = new Font("Helvetica", Font.PLAIN, 25);
    private final Skill skill;


    public SkillPanel(Skill skill) {
        this.skill = skill;

        setLayout(new GridLayout(1, 2, 5, 5));


        DrawingArea canvas = new DrawingArea();
        canvas.setVisible(true);
        add(canvas);


    }

    public class DrawingArea extends JPanel {

        public DrawingArea() {
            setLayout(new GridLayout(1, 1, 0, 0));
            repaint();
        }

        void draw(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;

            int assumeMaxWidthIs = this.getWidth() - 50;

            int width = 0;

                width = (int) (assumeMaxWidthIs * Player.percentageToNextLvl(skill));


            g2d.setColor(Color.ORANGE);
            g2d.fillRect(0, 0, width, 50);
            RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.setRenderingHints(rh);
            g2d.setColor(Color.BLACK);

            drawLabel(getX() + 5, getHeight() / 2 + HELVETICA_14.getSize() / 2, g2d);
            drawLevel(getWidth() - 50, getHeight() / 2 + HELVETICA_25.getSize() / 2, g2d);
        }

        private void drawLabel(int x, int y, Graphics2D g2d) {
            g2d.setFont(HELVETICA_14);
            g2d.drawString(skill.getDisplayName(), x, y);
        }

        private void drawLevel(int x, int y, Graphics2D g2d) {
            g2d.setFont(HELVETICA_25);
                g2d.drawString(String.valueOf(Player.getLevel(skill)), x, y);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            draw(g);
        }
    }
}
