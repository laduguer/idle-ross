package com.ross.ui.shops;

import com.ross.domain.shops.ShopController;

import javax.swing.*;
import java.awt.*;

public class ShopTabContentPanel extends JPanel {

    private ShopController shopController;

    public ShopTabContentPanel(ShopController shopController) {

        this.shopController = shopController;
        switchToOverview();
    }


    public ShopController getShopController() {
        return shopController;
    }

    public void openShop(String name) {

        removeAll();
        setLayout(new GridLayout(0, 1, 5, 5));
        ShopDetailPanel shopDetailPanel = new ShopDetailPanel(shopController.getShopDetails(name), this);
        add(shopDetailPanel);


    }

    public void switchToOverview(){
        removeAll();
        setLayout(new GridLayout(0, 1, 5, 5));
        ShopOverviewPanel shopOverview = new ShopOverviewPanel(shopController.getAvailableShops(), this);
        add(shopOverview);
    }

}
