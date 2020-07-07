package com.ross.domain.quests;

import com.ross.domain.Activity;
import com.ross.domain.player.Player;
import com.ross.domain.requirements.QuestRequirement;
import com.ross.domain.requirements.Requirement;
import com.ross.domain.rewards.ExpReward;
import com.ross.domain.rewards.Reward;
import com.ross.game.InfoHolder;
import com.ross.game.Skill;

import java.util.ArrayList;
import java.util.List;

public class QuestingActivity implements Activity {

    //bleh, niet content mee.... Quest moet geen enum zijn denk ik.
    private List<Requirement> startReguirements;
    private List<Reward> rewards;
    private Quest quest;

    private QuestingActivity(List<Requirement> startReguirements, List<Reward> rewards, Quest quest) {
        this.startReguirements = startReguirements;
        this.rewards = rewards;
        this.quest = quest;
    }

    public static Builder builder(Quest quest) {
        return new Builder(quest);
    }


    @Override
    public boolean canStartActivity(Player player) {
        return startReguirements.stream().allMatch(req -> req.isFullFilled(player));
    }

    @Override
    public void onTick(Player player) {
        if (!player.finishedQuest(quest)) {
            player.tickQuest(quest);
            if (player.finishedQuest(quest)) {

                rewards.forEach(reward -> reward.applyTo(player));
            }
        }

    }

    public static class Builder {
        private List<Requirement> startReguirements = new ArrayList<>();
        private List<Reward> rewards = new ArrayList<>();
        private Quest quest;
        private int ticks;


        private Builder(Quest quest) {

            this.quest = quest;
        }

        public Builder withExpReward(int exp, Skill skill) {
            rewards.add(new ExpReward(skill, exp));
            return this;
        }

        public QuestingActivity build() {
            return new QuestingActivity(startReguirements, rewards, quest);
        }

        public Builder withQuestRequirement(Quest dependency) {
            startReguirements.add(new QuestRequirement(dependency));
            return this;
        }

        public Builder withDuration(int ticks) {
            this.ticks = ticks;
            return this;
        }
    }

}
