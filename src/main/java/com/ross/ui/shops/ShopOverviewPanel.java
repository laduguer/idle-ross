package com.ross.ui.shops;

import com.ross.domain.shops.ShopOverviewViewModel;

import javax.swing.*;
import java.awt.*;

public class ShopOverviewPanel extends JPanel {

    private final ShopTabContentPanel parent;

    public ShopOverviewPanel(ShopOverviewViewModel availableShops, ShopTabContentPanel parent) {
        this.parent = parent;
        setLayout(new GridLayout(0, 1, 5, 5));

        availableShops.getShopSummaryModels().forEach(shopModel -> {
            add(new ShopSummanyPanel(shopModel, this));
        });


    }


    public void openShop(String name) {
        parent.openShop(name);
    }
}
