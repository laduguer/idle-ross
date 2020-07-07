package com.ross.ui.quests;

import java.awt.*;

public class QuestProgressViewModel {
    private final int progressPercentage;
    private final Color color;

    public QuestProgressViewModel(int progressPercentage, Color color) {

        this.progressPercentage = progressPercentage;
        this.color = color;
    }

    public int getProgressPercentage() {
        return progressPercentage;
    }

    public Color getColor() {
        return color;
    }
}
