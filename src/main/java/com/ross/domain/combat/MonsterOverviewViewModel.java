package com.ross.domain.combat;

import java.util.List;

public class MonsterOverviewViewModel {
    private List<MonsterSummaryViewModel> monsterSummaryModels;

    public MonsterOverviewViewModel(List<MonsterSummaryViewModel> monsterSummaryModels) {
        this.monsterSummaryModels = monsterSummaryModels;
    }

    public List<MonsterSummaryViewModel> getMonsters() {
        return monsterSummaryModels;
    }
}
