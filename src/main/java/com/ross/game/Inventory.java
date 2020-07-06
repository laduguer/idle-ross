package com.ross.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Inventory {
    private List<GenericUpdateListener> listeners = new ArrayList<>();


    private List<InventoryItem> items = new ArrayList<>();


    public static Inventory withStartingItems() {
        return new Inventory();
    }

    public void addListener(GenericUpdateListener listener) {
        this.listeners.add(listener);
    }

    public void addItems(ItemId item, int count) {
        Optional<InventoryItem> inventoryItem = find(item);
        if(inventoryItem.isPresent()){
            inventoryItem.get().plusAmount(count);
        }else{
            items.add(new InventoryItem(count, item));

        }
        notifyListener();
    }

    private void notifyListener() {
        listeners.forEach(GenericUpdateListener::updated);

    }

    private Optional<InventoryItem> find(ItemId item) {
        return items.stream()
                .filter(ii -> ii.getItem() == item)
                .findFirst();

    }


    public List<InventoryItemViewModel> items() {
        return items.stream()
                .map(item -> new InventoryItemViewModel(item.getAmount(), item.getItem()))
                .collect(Collectors.toList());


    }
}
