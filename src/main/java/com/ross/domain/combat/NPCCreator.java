package com.ross.domain.combat;

public class NPCCreator {
    public static NPC createFor(NPCId monsterId) {
        switch (monsterId){
            case CHICKEN:
                return new NPC(3) ;
            case COW:
                return  new NPC(8);

        }
        throw new RuntimeException("no monster info for id " + monsterId.name());
    }
}
