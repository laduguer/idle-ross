package com.ross.domain.shops;

import com.ross.game.Game;
import com.ross.game.ItemId;

import java.util.ArrayList;
import java.util.List;

public class ShopController {


    private Game game;

    public ShopController(Game game) {
        this.game = game;
    }

    public ShopOverviewViewModel getAvailableShops() {
        List<ShopSummaryViewModel> shopSummaryModels = new ArrayList<>();

        shopSummaryModels.add(buildStore("bobx axxess", "Lumbridge"));
        shopSummaryModels.add(buildStore("General store", "Lumbridge"));


        return new ShopOverviewViewModel(shopSummaryModels);
    }

    private ShopSummaryViewModel buildStore(String name, String city) {
        return new ShopSummaryViewModel(name, city, true);
    }

    public ShopDetailViewModel getShopDetails(String name) {
        return ShopDetailViewModel.builder()
                .withItemPrice(ItemId.COPPER_ORE, 10)
                .withItemPrice(ItemId.TIN_ORE, 12)
                .build();
    }

    //a zo ni hé
    //Currency
    public void buyItem(ItemId item, Integer priceEach, int maxAmount) {
        int availableGP = game.player().availableGP();
        int buyAmount = Math.min(maxAmount, availableGP /priceEach);
        int totalPrice = buyAmount * priceEach;

        game.addItem(ItemId.COINS, -totalPrice);
        game.addItem(item, buyAmount);

    }
}
