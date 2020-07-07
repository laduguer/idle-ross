package com.ross.ui.quests;

import com.ross.domain.quests.Quest;
import com.ross.game.Game;
import com.ross.game.GenericValueUpdateListener;

import javax.swing.*;
import java.awt.*;

public class QuestPanel extends JPanel implements GenericValueUpdateListener<QuestProgressViewModel> {
    private final Game game;
    private final Quest quest;
    private JProgressBar progressBar;

    public QuestPanel(Game game, Quest quest) {
        this.game = game;
        this.quest = quest;
        setLayout(new GridLayout(1, 2, 5, 5));

        JLabel label = new JLabel();
        label.setText(quest.name());
        add(label);

        progressBar = new JProgressBar(0, 100);
        add(progressBar);

        add(startQuestButton());

    }

    private Component startQuestButton() {
        JButton startButton = new JButton("start quest");
        startButton.addActionListener(e -> {
            game.activateQuestActivity(quest);
        });
        return startButton;
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }


    @Override
    public void updated(QuestProgressViewModel newValue) {
        progressBar.setValue(newValue.getProgressPercentage());
        progressBar.setForeground(newValue.getColor());

    }
}
