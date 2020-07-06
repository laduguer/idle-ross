package com.ross.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExpTableTest {

    @Test
    public void beginAtLvl1(){
        assertEquals(1, ExpTable.lvlAt(0));
    }
    @Test
    public void notYetLvl2(){
        assertEquals(1, ExpTable.lvlAt(82));
    }
    @Test
    public void gotLvl2(){
        assertEquals(2, ExpTable.lvlAt(83));
    }


    @Test
    public void maxExpIs99(){
        assertEquals(99, ExpTable.lvlAt(200000000));
    }


    @Test
    public void beginAt0Exp(){
        assertEquals(0, ExpTable.expAt(1));
    }


    @Test
    public void lvl2Is83EXP(){
        assertEquals(83, ExpTable.expAt(2));
    }

}
