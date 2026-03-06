package com.bookmystay.model;

import java.util.HashMap;

public class RoomInventory {

    private HashMap<String, Integer> roomCount;
    private HashMap<String, Double> roomPrice;

    public RoomInventory() {
        roomCount = new HashMap<>();
        roomPrice = new HashMap<>();
    }

    public HashMap<String, Integer> getRoomCount() {
        return roomCount;
    }

    public HashMap<String, Double> getRoomPrice() {
        return roomPrice;
    }
}
