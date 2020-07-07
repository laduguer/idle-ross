package com.ross.domain.quests;

import com.ross.game.GenericValueUpdateListener;
import com.ross.ui.quests.QuestProgressViewModel;

import java.awt.*;

public class QuestProgress {

    private long durationInTick;
    private long ticksCompleted;

    private int lastReportedPercentage;


    public QuestProgress(long durationInTick) {
        this.durationInTick = durationInTick;
    }

    public void tick(GenericValueUpdateListener<QuestProgressViewModel> genericUpdateListener) {
        ticksCompleted++;

        int percentageCompleted = (int) ((100 * ticksCompleted) / durationInTick);
        if(lastReportedPercentage != percentageCompleted){
            lastReportedPercentage = percentageCompleted;
            genericUpdateListener.updated(toViewModel());
        }
    }

    private QuestProgressViewModel toViewModel() {
        return new QuestProgressViewModel(lastReportedPercentage, progressColor());
    }

    private Color progressColor() {
        return isFinished() ? Color.GREEN : Color.ORANGE;
    }

    public boolean isFinished() {
        return  ticksCompleted >= durationInTick;
    }
}
