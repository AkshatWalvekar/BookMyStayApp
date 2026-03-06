package com.bookmystay.main;

import java.util.Scanner;
import com.bookmystay.service.InventoryService;

public class BookMyStayApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        InventoryService service = new InventoryService();

        while(true) {

            System.out.println("\n--- BookMyStay Inventory System ---");
            System.out.println("1 Add Room Type");
            System.out.println("2 Update Room Count");
            System.out.println("3 Update Room Price");
            System.out.println("4 Show Inventory");
            System.out.println("5 Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {

                case 1:
                    System.out.print("Enter room type: ");
                    String type = sc.nextLine();

                    System.out.print("Enter count: ");
                    int count = sc.nextInt();

                    System.out.print("Enter price: ");
                    double price = sc.nextDouble();

                    service.addRoomType(type, count, price);
                    break;

                case 2:
                    System.out.print("Enter room type: ");
                    type = sc.nextLine();

                    System.out.print("Enter new count: ");
                    count = sc.nextInt();

                    service.updateRoomCount(type, count);
                    break;

                case 3:
                    System.out.print("Enter room type: ");
                    type = sc.nextLine();

                    System.out.print("Enter new price: ");
                    price = sc.nextDouble();

                    service.updateRoomPrice(type, price);
                    break;

                case 4:
                    service.showInventory();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
