package com.ross.domain.shops;

public class ShopSummaryViewModel {

    private String name;
    private String city;
    private boolean unlocked;


    public ShopSummaryViewModel(String name, String city, boolean unlocked) {
        this.name = name;
        this.city = city;
        this.unlocked = unlocked;
    }


    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public boolean isUnlocked() {
        return unlocked;
    }
}
