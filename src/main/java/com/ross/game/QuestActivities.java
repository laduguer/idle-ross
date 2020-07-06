package com.ross.game;

import com.ross.domain.Activity;
import com.ross.domain.quests.Quest;
import com.ross.domain.quests.QuestingActivity;

import java.util.HashMap;
import java.util.Map;

import static com.ross.domain.quests.Quest.COOKS_ASS;
import static com.ross.domain.quests.Quest.COOKS_ASS_2;
import static com.ross.game.Skill.COOKING;

public class QuestActivities {


    static final Map<Quest, QuestingActivity> cache;

    static{
        cache = new HashMap<>();
        cache.put(COOKS_ASS, QuestingActivity.builder(COOKS_ASS)
                .withExpReward(200, COOKING).build());
        cache.put(COOKS_ASS_2, QuestingActivity.builder(COOKS_ASS_2)
                .withQuestRequirement(COOKS_ASS)
                .withExpReward(20000, COOKING)
                .build());
    }

    public static Activity forQuest(Quest quest) {
        return cache.get(quest);
    }
}
