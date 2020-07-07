package com.ross.ui.quests;

import com.ross.domain.quests.Quest;
import com.ross.game.Game;

import javax.swing.*;
import java.awt.*;

public class QuestTabContentPanel extends JPanel {
    public QuestTabContentPanel(Game game) {
        setLayout(new GridLayout(0, 1, 5, 5));
        for(Quest quest : Quest.values()){
            QuestPanel questPanel = new QuestPanel(game, quest);
            add(questPanel);
            game.setQuestProgressListener(quest, questPanel);
        }
    }
}
