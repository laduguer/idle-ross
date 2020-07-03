package com.ross.domain;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExpTableTest {

    @Test
    public void beginAtLvl1(){
        Assert.assertEquals(1, ExpTable.lvlAt(0));
    }
    @Test
    public void notYetLvl2(){
        Assert.assertEquals(1, ExpTable.lvlAt(82));
    }
    @Test
    public void gotLvl2(){
        Assert.assertEquals(2, ExpTable.lvlAt(83));
    }


    @Test
    public void maxExpIs99(){
        Assert.assertEquals(99, ExpTable.lvlAt(200000000));
    }


    @Test
    public void beginAt0Exp(){
        Assert.assertEquals(0, ExpTable.expAt(1));
    }


    @Test
    public void lvl2Is83EXP(){
        Assert.assertEquals(83, ExpTable.expAt(2));
    }

}