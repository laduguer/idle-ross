package com.ross.domain.requirements;

import com.ross.domain.player.Player;

public interface Requirement {


    boolean isFullFilled(Player player);
}
