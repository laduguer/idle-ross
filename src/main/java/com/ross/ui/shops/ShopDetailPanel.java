package com.ross.ui.shops;

import com.ross.domain.shops.ShopDetailViewModel;
import com.ross.game.ItemId;

import javax.swing.*;
import java.awt.*;

public class ShopDetailPanel extends JPanel {
    public ShopDetailPanel(ShopDetailViewModel shopDetails, ShopTabContentPanel parent) {
        JButton button = new JButton("Leave");
        button.addActionListener(e -> {
            parent.switchToOverview();
        });
        add(button);

        setLayout(new GridLayout(0,1,3,3));
        for(ItemId item : shopDetails.getItemsForSale()){
            add(new ShopItemPanel(item, shopDetails.getPrices().get(item), parent.getShopController()));


        }



    }
}
