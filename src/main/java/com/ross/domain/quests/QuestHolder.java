package com.ross.domain.quests;

import com.ross.game.GenericValueUpdateListener;
import com.ross.ui.QuestProgressViewModel;

import java.util.HashMap;
import java.util.Map;


public class QuestHolder {


    private Map<Quest, QuestProgress> questStatusses = new HashMap<>();
    private Map<Quest, GenericValueUpdateListener<QuestProgressViewModel>> listeners = new HashMap<>();


    public QuestHolder() {
        for(Quest quest: Quest.values()){
            questStatusses.put(quest, new QuestProgress(75));
        }
    }

    public boolean isFinished(Quest quest) {
        return questStatusses.get(quest).isFinished();
    }

    public void tick(Quest quest) {
        questStatusses.get(quest).tick(listeners.get(quest));
    }

    public void addQuestProgressListener(Quest quest, GenericValueUpdateListener<QuestProgressViewModel> listener) {
        listeners.put(quest, listener);
    }
}
