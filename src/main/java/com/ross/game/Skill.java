package com.ross.game;

public enum Skill {
    ATTACK,
    DEFENCE,
    STRENGTH,
    RANGED,
    PRAYER,
    MAGIC,
    CONSTITUTION,
    CRAFTING,
    MINING,
    SMITHING,
    FISHING,
    COOKING,
    FIREMAKING,
    WOODCUTTING,
    RUNECRAFTING,
    DUNGEONEERING,
    FLETCHING;

    public String getDisplayName() {
        return capitalize(this.name());
    }

    public static String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }
}
