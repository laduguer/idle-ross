package com.ross.domain.woodcutting;

public class ChopOakTrees extends WoodcuttingActivity {
    @Override
    protected int expPerTick() {
        return 50;
    }

    @Override
    protected int levelRequired() {
        return 15;
    }

}
