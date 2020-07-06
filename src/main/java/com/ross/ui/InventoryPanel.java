package com.ross.ui;

import com.ross.game.GenericUpdateListener;
import com.ross.game.Inventory;
import com.ross.game.InventoryItemViewModel;
import com.ross.util.ColoredText;
import com.ross.util.RSAmountUtil;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class InventoryPanel extends JScrollPane implements GenericUpdateListener {

    private Inventory inventory;
    private JPanel panel = new JPanel();


    public InventoryPanel(Inventory inventory) {
        this.inventory = inventory;

       // setLayout(new ScrollPaneLayout());
        //setLayout(new GridLayout(0, 8, 2, 2));
        setPreferredSize(new Dimension(200, 200));
        inventory.addListener(this);
        setBackground(Color.GREEN);



        setViewportView(panel);
        panel.setVisible(true);
        panel.setLayout(new GridLayout(4, 8, 2,2));
        panel.setBackground(Color.DARK_GRAY);
        panel.setSize(new Dimension(200,200));
        setVisible(true);
    }


    @Override
    public void updated() {
        List<InventoryItemViewModel> items = inventory.items();
        panel.removeAll();
        items.forEach(
                item -> {
                    JLabel jLabel = new JLabel();
                    ColoredText amountText = RSAmountUtil.amountToColoredText(item.getAmount());
                    jLabel.setText(amountText.getText());
                    jLabel.setForeground(amountText.getColor());
                    jLabel.setIcon(ImageHolder.inventoryIcon(item.getItem()));
                    panel.add(jLabel);
                }
        );
        updateUI();


    }
}
