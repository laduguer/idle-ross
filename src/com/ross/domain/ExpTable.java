package com.ross.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ExpTable {

    private static List<Integer> lvlUpExps;

    static {
        lvlUpExps = new ArrayList<>();
        lvlUpExps.add(0);
        lvlUpExps.add(83);
        lvlUpExps.add(8740);
        lvlUpExps.add(111945);
        lvlUpExps.add(9730);
        lvlUpExps.add(123660);
        lvlUpExps.add(1475581);
        lvlUpExps.add(174);
        lvlUpExps.add(10824);
        lvlUpExps.add(136594);
        lvlUpExps.add(1629200);
        lvlUpExps.add(276);
        lvlUpExps.add(12031);
        lvlUpExps.add(150872);
        lvlUpExps.add(1798808);
        lvlUpExps.add(388);
        lvlUpExps.add(13363);
        lvlUpExps.add(166636);
        lvlUpExps.add(1986068);
        lvlUpExps.add(512);
        lvlUpExps.add(14833);
        lvlUpExps.add(184040);
        lvlUpExps.add(2192818);
        lvlUpExps.add(650);
        lvlUpExps.add(16456);
        lvlUpExps.add(203254);
        lvlUpExps.add(2421087);
        lvlUpExps.add(801);
        lvlUpExps.add(18247);
        lvlUpExps.add(224466);
        lvlUpExps.add(2673114);
        lvlUpExps.add(969);
        lvlUpExps.add(20224);
        lvlUpExps.add(247886);
        lvlUpExps.add(2951373);
        lvlUpExps.add(1154);
        lvlUpExps.add(22406);
        lvlUpExps.add(273742);
        lvlUpExps.add(3258594);
        lvlUpExps.add(1358);
        lvlUpExps.add(24815);
        lvlUpExps.add(302288);
        lvlUpExps.add(3597792);
        lvlUpExps.add(1584);
        lvlUpExps.add(27473);
        lvlUpExps.add(333804);
        lvlUpExps.add(3972294);
        lvlUpExps.add(1833);
        lvlUpExps.add(30408);
        lvlUpExps.add(368599);
        lvlUpExps.add(4385776);
        lvlUpExps.add(2107);
        lvlUpExps.add(33648);
        lvlUpExps.add(407015);
        lvlUpExps.add(4842295);
        lvlUpExps.add(2411);
        lvlUpExps.add(37224);
        lvlUpExps.add(449428);
        lvlUpExps.add(5346332);
        lvlUpExps.add(2746);
        lvlUpExps.add(41171);
        lvlUpExps.add(496254);
        lvlUpExps.add(5902831);
        lvlUpExps.add(3115);
        lvlUpExps.add(45529);
        lvlUpExps.add(547953);
        lvlUpExps.add(6517253);
        lvlUpExps.add(3523);
        lvlUpExps.add(50339);
        lvlUpExps.add(605032);
        lvlUpExps.add(7195629);
        lvlUpExps.add(3973);
        lvlUpExps.add(55649);
        lvlUpExps.add(668051);
        lvlUpExps.add(7944614);
        lvlUpExps.add(4470);
        lvlUpExps.add(61512);
        lvlUpExps.add(737627);
        lvlUpExps.add(8771558);
        lvlUpExps.add(5018);
        lvlUpExps.add(103383);
        lvlUpExps.add(67983);
        lvlUpExps.add(814445);
        lvlUpExps.add(9684577);
        lvlUpExps.add(5624);
        lvlUpExps.add(75127);
        lvlUpExps.add(899257);
        lvlUpExps.add(10692629);
        lvlUpExps.add(6291);
        lvlUpExps.add(83014);
        lvlUpExps.add(992895);
        lvlUpExps.add(11805606);
        lvlUpExps.add(7028);
        lvlUpExps.add(91721);
        lvlUpExps.add(1096278);
        lvlUpExps.add(13034431);
        lvlUpExps.add(7842);
        lvlUpExps.add(101333);
        lvlUpExps.add(1210421);
        lvlUpExps.sort(Comparator.naturalOrder());
    }


    public static int lvlAt(int exp){
               return (int) lvlUpExps.stream().filter(lvlExp -> exp >= lvlExp)
                .count();
    }


    public static int expAt(int level) {
        return lvlUpExps.get(level -1);
    }
}
