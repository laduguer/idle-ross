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

    public static double woodcuttPercentageToNextLvl() {
        int currentLvl = ExpTable.lvlAt(wcExp);
        int startExpOfLvl = ExpTable.expAt(currentLvl);
        int startExpOfNextLvl = ExpTable.expAt(currentLvl+1);

        int diff = startExpOfNextLvl - startExpOfLvl;
        int progress = wcExp - startExpOfLvl;
        return ((double)progress) / (double)diff;


    }
}
