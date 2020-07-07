package com.ross.domain.combat;

public class MonsterSummaryViewModel {

    private NPCId monster;
    private int level;
    private boolean unlocked;

    public MonsterSummaryViewModel(NPCId monster, int level, boolean unlocked) {
        this.monster = monster;
        this.level = level;
        this.unlocked = unlocked;
    }

    public NPCId getMonster() {
        return monster;
    }

    public int getLevel() {
        return level;
    }

    public boolean isUnlocked() {
        return unlocked;
    }
}
