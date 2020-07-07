package com.ross.domain.requirements;

import com.ross.domain.player.Player;
import com.ross.domain.quests.Quest;

public class QuestRequirement implements Requirement {

    private Quest quest;

    public QuestRequirement(Quest quest) {
        this.quest = quest;
    }

    @Override
    public boolean isFullFilled(Player player) {
        return player.finishedQuest(quest);
    }
}
