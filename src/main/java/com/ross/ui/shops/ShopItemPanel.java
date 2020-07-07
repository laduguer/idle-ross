package com.ross.ui.shops;

import com.ross.domain.shops.ShopController;
import com.ross.game.ItemId;
import com.ross.ui.ImageHolder;
import com.ross.util.ColoredText;
import com.ross.util.RSAmountUtil;

import javax.swing.*;

public class ShopItemPanel extends JPanel {
    public ShopItemPanel(ItemId item, Integer price, ShopController shopController) {

        JLabel jLabel = new JLabel();
        ColoredText amountText = RSAmountUtil.amountToColoredText(price);
        jLabel.setText(amountText.getText());
        jLabel.setForeground(amountText.getColor());
        jLabel.setIcon(ImageHolder.inventoryIcon(item));
        add(jLabel);

        addBuyButton(item, price, shopController, 1);
        addBuyButton(item, price, shopController, 10);
        addBuyButton(item, price, shopController, 100);
        addBuyButton(item, price, shopController, 1000);
        addBuyButton(item, price, shopController, 1000000);


    }

    private void addBuyButton(ItemId item, Integer price, ShopController shopController, int maxAmount) {
        JButton buyButton = new JButton("Buy " +maxAmount);
        buyButton.addActionListener(e->{
            shopController.buyItem(item, price, maxAmount);
        });

        add(buyButton);
    }
}
