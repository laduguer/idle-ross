package com.ross.domain.player;

import com.ross.domain.ExpTable;

public class Player {

    private static int wcExp = 0;


    public static int woodcuttingLevel() {
        return ExpTable.lvlAt(wcExp);

    }

    public static void addWoodcuttExp(int exp) {
        wcExp += exp;
    }
}
