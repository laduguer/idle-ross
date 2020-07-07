package com.ross.ui.combat;

import com.ross.domain.combat.NPCId;
import com.ross.domain.combat.OngoingFightViewModel;
import com.ross.game.GenericValueUpdateListener;
import com.ross.ui.ImageHolder;
import com.ross.util.ColoredText;
import com.ross.util.RSAmountUtil;

import javax.swing.*;
import java.awt.*;

public class FightingActivitySpectatorPanel extends JPanel implements GenericValueUpdateListener<OngoingFightViewModel> {

    private JProgressBar progressBar;

    public FightingActivitySpectatorPanel(NPCId npc, CombatTabContentPanel parent) {
        setLayout(new BorderLayout());
        //add(new JLabel("Fighting " + npc.name()), BorderLayout.TO);
        JButton button = new JButton("Leave");
        button.addActionListener(e -> {
            parent.stopFighting();
        });
        add(button, BorderLayout.SOUTH);

        progressBar = new JProgressBar();
        add(progressBar, BorderLayout.NORTH);
        progressBar.setMinimum(0);
        progressBar.setMaximum(1);
        progressBar.setValue(1);
        progressBar.setForeground(Color.GREEN);
        progressBar.setBackground(Color.RED);

        JLabel jLabel = new JLabel();
        jLabel.setIcon(ImageHolder.npcIcon(npc));
        add(jLabel, BorderLayout.CENTER);

    }

    @Override
    public void updated(OngoingFightViewModel newValue) {
        progressBar.setMaximum(newValue.getMaxHp());
        progressBar.setValue(newValue.getCurrentHp());
    }
}
