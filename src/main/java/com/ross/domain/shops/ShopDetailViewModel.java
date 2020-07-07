package com.ross.domain.shops;

import com.ross.game.ItemId;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopDetailViewModel {


    private List<ItemId> itemsForSale;
    private Map<ItemId, Integer> prices;

    private ShopDetailViewModel(List<ItemId> itemsForSale, Map<ItemId, Integer> prices) {
        this.itemsForSale = itemsForSale;
        this.prices = prices;
    }

    public List<ItemId> getItemsForSale() {
        return itemsForSale;
    }

    public Map<ItemId, Integer> getPrices() {
        return prices;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private List<ItemId> itemsForSale = new ArrayList<>();
        private Map<ItemId, Integer> prices = new HashMap<>();

        private Builder() {

        }

        public Builder withItemPrice(ItemId item, int price) {
            itemsForSale.add(item);
            prices.put(item, price);
            return this;
        }

        public ShopDetailViewModel build() {
            return new ShopDetailViewModel(itemsForSale, prices);
        }
    }
}
