package com.bookmystay.service;

import com.bookmystay.model.RoomInventory;
import java.util.Map;

public class SearchService {

    private RoomInventory inventory;

    public SearchService(RoomInventory inventory) {
        this.inventory = inventory;
    }

    // Display all available rooms
    public void showAvailableRooms() {

        System.out.println("\nAvailable Rooms:");

        for (Map.Entry<String, Integer> entry : inventory.getRoomCount().entrySet()) {

            String roomType = entry.getKey();
            int count = entry.getValue();

            if (count > 0) {

                double price = inventory.getRoomPrice().get(roomType);

                System.out.println(
                        "Room Type: " + roomType +
                        " | Available: " + count +
                        " | Price: " + price
                );
            }
        }
    }

    // Check availability of specific room
    public void checkRoom(String type) {

        if(inventory.getRoomCount().containsKey(type)) {

            int count = inventory.getRoomCount().get(type);

            if(count > 0) {

                double price = inventory.getRoomPrice().get(type);

                System.out.println(type + " room available.");
                System.out.println("Price per night: " + price);

            } else {

                System.out.println(type + " room currently unavailable.");
            }

        } else {

            System.out.println("Room type not found.");
        }
    }
}