package com.ross.domain.combat;

import com.ross.domain.shops.ShopOverviewViewModel;
import com.ross.game.Game;
import com.ross.ui.combat.MonsterOverviewPanel;

import java.util.ArrayList;
import java.util.List;

public class CombatController {


    private Game game;

    public CombatController(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    public MonsterOverviewViewModel getMonstersViewModel() {

        List<MonsterSummaryViewModel> monsterSummaryViewModels = new ArrayList<>();
        monsterSummaryViewModels.add(monster(NPCId.CHICKEN, 3));
        monsterSummaryViewModels.add(monster(NPCId.COW, 8));
        return new MonsterOverviewViewModel(monsterSummaryViewModels);



    }

    private MonsterSummaryViewModel monster(NPCId monster, int lvl) {
        return new MonsterSummaryViewModel(monster, lvl, true);
    }
}
