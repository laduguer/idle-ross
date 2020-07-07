package com.ross.domain.combat;

public class OngoingFightViewModel {
    private final int maxHp;
    private final int currentHp;

    public OngoingFightViewModel(int maxHp, int currentHp) {

        this.maxHp = maxHp;
        this.currentHp = currentHp;
    }


    public int getMaxHp() {
        return maxHp;
    }

    public int getCurrentHp() {
        return currentHp;
    }
}
