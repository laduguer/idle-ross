package com.ross.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Inventory {

    private final List<GenericUpdateListener> listeners = new ArrayList<>();
    private final List<InventoryItem> items = new ArrayList<>();


    public static Inventory withStartingItems() {
        Inventory inventory = new Inventory();
        inventory.addItems(ItemId.COINS, 100000);
        return inventory;
    }

    public void addListener(GenericUpdateListener listener) {
        this.listeners.add(listener);
        listener.updated();
    }

    public void addItems(ItemId item, int count) {
        Optional<InventoryItem> inventoryItem = find(item);
        if (inventoryItem.isPresent()) {
            inventoryItem.get().plusAmount(count);
        } else {
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

    public int availableGP() {
        return items.stream()
                .filter(item -> item.getItem() == ItemId.COINS)
                .map(InventoryItem::getAmount)
                .findFirst().orElse(0);
    }
}
