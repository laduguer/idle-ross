package com.ross.ui;

import com.ross.game.ItemId;

import javax.swing.*;
import java.net.URL;

public class ImageHolder {
    public static Icon inventoryIcon(ItemId item) {
        URL imageURL = getResource(item.name());
        if (imageURL == null) {
            imageURL = getResource("unknown");
        }
        return new ImageIcon(imageURL);
    }

    private static URL getResource(String name) {
        return ImageHolder.class.getClassLoader().getResource("icons/" + name + ".png");
    }
}
