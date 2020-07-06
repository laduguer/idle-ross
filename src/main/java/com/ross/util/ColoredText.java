package com.ross.util;

import java.awt.*;

public class ColoredText {

    private String text;
    private Color color;


    public ColoredText(String text, Color color) {
        this.text = text;
        this.color = color;
    }

    public String getText() {
        return text;
    }

    public Color getColor() {
        return color;
    }
}
