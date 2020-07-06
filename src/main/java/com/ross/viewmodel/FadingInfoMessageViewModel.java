package com.ross.viewmodel;

import java.awt.*;

public class FadingInfoMessageViewModel {

    public final String message;
    public final double lifeProgression; //percentage from birth to death
    private MessageType type;

    public FadingInfoMessageViewModel(String message, double lifeProgression, MessageType type) {
        this.message = message;
        this.lifeProgression = lifeProgression;
        this.type = type;
    }

    public Color color() {
        int alfa = 255-(int) (255 * lifeProgression);
        switch (type) {
            case Info:
                return new Color(17, 230, 30, alfa);
            case Warning:
                return new Color(230, 17, 30, alfa);
        }

        return new Color(50, 80, 60, alfa);
    }
}
