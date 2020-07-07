package com.ross.ui;

import com.ross.domain.combat.NPCId;
import com.ross.game.ItemId;

import javax.swing.*;
import java.net.URL;

public class ImageHolder {
    public static Icon inventoryIcon(ItemId item) {
        return getIconFromFolder(item.name(), "icons");
    }

    public static Icon npcIcon(NPCId name) {
        return getIconFromFolder(name.name(), "npcs");
    }

    private static Icon getIconFromFolder(String name, String folderName) {
        URL imageURL = getResource(folderName + "/" + name);
        if (imageURL == null) {
            imageURL = getResource(folderName + "/" + "unknown");
        }
        return new ImageIcon(imageURL);
    }

    private static URL getResource(String name) {
        return ImageHolder.class.getClassLoader().getResource(name + ".png");
    }


}
