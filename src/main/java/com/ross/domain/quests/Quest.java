package com.ross.domain.quests;

public enum Quest {
    COOKS_ASS,
    COOKS_ASS_2;

    private String getDisplayName() {
        return capitalize(this.name());
    }

    public static String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }
}
