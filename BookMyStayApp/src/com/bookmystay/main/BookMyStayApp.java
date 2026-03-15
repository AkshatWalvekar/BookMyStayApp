package com.bookmystay.main;

import java.util.Scanner;

import com.bookmystay.service.InventoryService;
import com.bookmystay.service.SearchService;
import com.bookmystay.service.BookingQueueService;
import com.bookmystay.service.AllocationService;
import com.bookmystay.model.Reservation;
import com.bookmystay.service.AddOnServiceManager;
import com.bookmystay.model.Service;

public class BookMyStayApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        InventoryService inventoryService = new InventoryService();

        SearchService searchService =
                new SearchService(inventoryService.getInventory());

        BookingQueueService bookingService = new BookingQueueService();
        
        AllocationService allocationService =
                new AllocationService(inventoryService.getInventory());
        
        AddOnServiceManager serviceManager = new AddOnServiceManager();

        while(true) {

            System.out.println("\n--- BookMyStay System ---");
            System.out.println("1 Add Room Type");
            System.out.println("2 Update Room Count");
            System.out.println("3 Update Room Price");
            System.out.println("4 Show Inventory");
            System.out.println("5 Search Available Rooms");
            System.out.println("6 Check Specific Room");
            System.out.println("7 Add Booking Request");
            System.out.println("8 Process Booking");
            System.out.println("9 Show Booking Queue");
            System.out.println("10 Confirm Reservation & Allocate Room");
            System.out.println("11 Show Allocated Rooms");
            System.out.println("12 Add Add-On Service");
            System.out.println("13 Show Reservation Service");
            System.out.println("14 Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {
            	
            	//Add room type
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

                //Check specific room
                case 6:
                    System.out.print("Enter room type: ");
                    type = sc.nextLine();

                    searchService.checkRoom(type);
                    break;

                //Add Booking request
                case 7:

                    System.out.print("Guest Name: ");
                    String name = sc.nextLine();

                    System.out.print("Room Type: ");
                    type = sc.nextLine();

                    bookingService.addBooking(name, type);
                    break;

                //Process Booking
                case 8:
                    bookingService.processBooking();
                    break;

                //Show booking queue
                case 9:
                    bookingService.showQueue();
                    break;
                
                //To confirm reservation and allocate rooms
                case 10:

                    Reservation r = bookingService.getNextReservation();

                    if(r == null) {

                        System.out.println("No booking requests.");
                    }
                    else {

                        allocationService.allocateRoom(r);
                    }

                    break;
                 
                //to show allocated rooms
                case 11:

                    allocationService.showAllocations();
                    break;

                //AddOn services
                case 12:

                    System.out.print("Enter Reservation ID: ");
                    String resId = sc.nextLine();

                    System.out.println("1 Breakfast (500)");
                    System.out.println("2 Spa (1500)");
                    System.out.println("3 Airport Pickup (800)");

                    int serviceChoice = sc.nextInt();
                    sc.nextLine();

                    if(serviceChoice == 1) {
                        serviceManager.addService(resId,
                                new Service("Breakfast",500));
                    }

                    else if(serviceChoice == 2) {
                        serviceManager.addService(resId,
                                new Service("Spa",1500));
                    }

                    else if(serviceChoice == 3) {
                        serviceManager.addService(resId,
                                new Service("Airport Pickup",800));
                    }

                    break;

                //Show Reservation Service
                case 13:

                    System.out.print("Enter Reservation ID: ");
                    resId = sc.nextLine();

                    serviceManager.showServices(resId);

                    break;

                    
                //Exit...
                case 14:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}