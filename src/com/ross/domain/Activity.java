package com.ross.domain;

import com.ross.domain.player.Player;

public interface Activity {

    boolean playerHasRequirements(); //op hier een liijst van de requirements geven, die dan maar de player moeten als argument van een bool function binnennemen

    void applyProgress(Player player);
}
