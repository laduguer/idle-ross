package com.ross.ui.shops;

import com.ross.domain.shops.ShopSummaryViewModel;

import javax.swing.*;
import java.awt.*;

public class ShopSummanyPanel extends JPanel {
    public ShopSummanyPanel(ShopSummaryViewModel shopModel, ShopOverviewPanel parent) {

        setLayout(new FlowLayout());

        add(new JLabel(shopModel.getName()));
        add(new JLabel(shopModel.getCity()));
        JButton openButton = new JButton("Open");
        openButton.addActionListener(e -> {
            parent.openShop(shopModel.getName());
        });
        add(openButton);
    }
}
