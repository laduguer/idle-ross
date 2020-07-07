package com.ross.domain.combat;

public class NPC {




    int maxHp;
    int currentHp;


    public NPC(int maxHp) {
        this.maxHp = maxHp;
        this.currentHp = maxHp;
    }

    public boolean dead() {
        return currentHp <=0;
    }

    public void takeDamage(int dmg) {
        currentHp -= dmg;
    }
}
