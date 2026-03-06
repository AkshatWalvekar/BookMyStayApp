package com.bookmystay.service;

import com.bookmystay.model.RoomInventory;

public class InventoryService {

    private RoomInventory inventory;

    public InventoryService() {
        inventory = new RoomInventory();
    }

    // Add room type
    public void addRoomType(String type, int count, double price) {

        inventory.getRoomCount().put(type, count);
        inventory.getRoomPrice().put(type, price);

        System.out.println(type + " room added successfully!");
    }

    // Update room count
    public void updateRoomCount(String type, int newCount) {

        if(inventory.getRoomCount().containsKey(type)) {

            inventory.getRoomCount().put(type, newCount);
            System.out.println("Room count updated.");

        } else {
            System.out.println("Room type not found.");
        }
    }

    // Update price
    public void updateRoomPrice(String type, double price) {

        if(inventory.getRoomPrice().containsKey(type)) {

            inventory.getRoomPrice().put(type, price);
            System.out.println("Room price updated.");

        } else {
            System.out.println("Room type not found.");
        }
    }

    // Display inventory
    public void showInventory() {

        System.out.println("\nRoom Inventory:");

        for(String type : inventory.getRoomCount().keySet()) {

            int count = inventory.getRoomCount().get(type);
            double price = inventory.getRoomPrice().get(type);

            System.out.println(type + " -> Available: " + count + " Price: " + price);
        }
    }
}