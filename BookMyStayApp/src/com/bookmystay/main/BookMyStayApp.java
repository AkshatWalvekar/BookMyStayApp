package com.bookmystay.main;

import java.util.Scanner;
import com.bookmystay.service.InventoryService;
import com.bookmystay.service.SearchService;

public class BookMyStayApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        InventoryService inventoryService = new InventoryService();

        SearchService searchService =
                new SearchService(inventoryService.getInventory());

        while(true) {

            System.out.println("\n--- BookMyStay System ---");
            System.out.println("1 Add Room Type");
            System.out.println("2 Update Room Count");
            System.out.println("3 Update Room Price");
            System.out.println("4 Show Inventory");
            System.out.println("5 Search Available Rooms");
            System.out.println("6 Check Specific Room");
            System.out.println("7 Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {

                //add room type
                case 1:

                    System.out.print("Room type: ");
                    String type = sc.nextLine();

                    System.out.print("Count: ");
                    int count = sc.nextInt();

                    System.out.print("Price: ");
                    double price = sc.nextDouble();

                    inventoryService.addRoomType(type, count, price);
                    break;

                //Update room count
                case 2:

                    System.out.print("Room type: ");
                    type = sc.nextLine();

                    System.out.print("New count: ");
                    count = sc.nextInt();

                    inventoryService.updateRoomCount(type, count);
                    break;

                //Update room price
                case 3:

                    System.out.print("Room type: ");
                    type = sc.nextLine();

                    System.out.print("New price: ");
                    price = sc.nextDouble();

                    inventoryService.updateRoomPrice(type, price);
                    break;

                //show inventory
                case 4:

                    inventoryService.showInventory();
                    break;

                //search available rooms
                case 5:

                    searchService.showAvailableRooms();
                    break;

                //check specific room
                case 6:

                    System.out.print("Enter room type: ");
                    type = sc.nextLine();

                    searchService.checkRoom(type);
                    break;
                
               //exiting
                case 7:

                    System.out.println("Exiting...");
                    System.exit(0);

                default:

                    System.out.println("Invalid choice");
            }
        }
    }
}