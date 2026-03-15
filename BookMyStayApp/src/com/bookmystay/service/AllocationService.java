package com.bookmystay.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import com.bookmystay.model.Reservation;
import com.bookmystay.model.RoomInventory;

public class AllocationService {

    private HashMap<String, Set<String>> allocatedRooms;
    private Set<String> bookedRoomIds;

    private RoomInventory inventory;

    public AllocationService(RoomInventory inventory) {

        this.inventory = inventory;

        allocatedRooms = new HashMap<>();
        bookedRoomIds = new HashSet<>();
    }

    // confirm reservation and allocate room
    public void allocateRoom(Reservation r) {

        String roomType = r.getRoomType();

        if(!inventory.getRoomCount().containsKey(roomType)) {

            System.out.println("Invalid room type.");
            return;
        }

        int available = inventory.getRoomCount().get(roomType);

        if(available <= 0) {

            System.out.println("No rooms available for " + roomType);
            return;
        }

        // generate room id
        String roomId = roomType + "-" + System.currentTimeMillis();

        if(bookedRoomIds.contains(roomId)) {

            System.out.println("Room already booked.");
            return;
        }

        bookedRoomIds.add(roomId);

        allocatedRooms.putIfAbsent(roomType, new HashSet<>());

        allocatedRooms.get(roomType).add(roomId);

        inventory.getRoomCount().put(roomType, available - 1);

        System.out.println("Reservation Confirmed!");
        System.out.println("Guest: " + r.getGuestName());
        System.out.println("Room Allocated: " + roomId);
    }

    // show allocated rooms
    public void showAllocations() {

        System.out.println("\nAllocated Rooms:");

        for(String type : allocatedRooms.keySet()) {

            System.out.println(type + " -> " + allocatedRooms.get(type));
        }
    }
}