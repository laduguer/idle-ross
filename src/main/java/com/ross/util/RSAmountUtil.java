package com.ross.util;

import java.awt.*;

public class RSAmountUtil {
    public static ColoredText amountToColoredText(int amount) {
        if(amount < 100000){
            return new ColoredText(amount + "", Color.YELLOW);
        }
        if(amount < 10000000){
            return new ColoredText(amount/1000 + "K", Color.WHITE);
        }

            return new ColoredText(amount/1000000 + "M", new Color(57, 245, 87));
    }
}
