package com.ross.domain.woodcutting;

public class ChopWillowTrees extends WoodcuttingActivity {
    @Override
    protected int expPerTick() {
        return 120;
    }

    @Override
    protected int levelRequired() {
        return 30;
    }

}
