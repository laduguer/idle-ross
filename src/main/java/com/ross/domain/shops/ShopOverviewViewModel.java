package com.ross.domain.shops;

import java.util.List;

public class ShopOverviewViewModel {
    private List<ShopSummaryViewModel> shopSummaryModels;

    public ShopOverviewViewModel(List<ShopSummaryViewModel> shopSummaryModels) {
        this.shopSummaryModels = shopSummaryModels;
    }

    public List<ShopSummaryViewModel> getShopSummaryModels() {
        return shopSummaryModels;
    }
}
