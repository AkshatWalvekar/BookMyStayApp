package com.bookmystay.service;

import java.util.LinkedList;
import java.util.Queue;

import com.bookmystay.model.Reservation;

public class BookingQueueService {

    private Queue<Reservation> bookingQueue;

    public BookingQueueService() {

        bookingQueue = new LinkedList<>();
    }

    // Add booking request
    public void addBooking(String guestName, String roomType) {

        Reservation r = new Reservation(guestName, roomType);

        bookingQueue.offer(r);

        System.out.println("Booking request added to queue.");
    }

    // Process booking
    public void processBooking() {

        if(bookingQueue.isEmpty()) {

            System.out.println("No booking requests.");
            return;
        }

        Reservation r = bookingQueue.poll();

        System.out.println("Processing booking...");
        System.out.println("Guest: " + r.getGuestName());
        System.out.println("Room Type: " + r.getRoomType());
    }

    // Show queue
    public void showQueue() {

        if(bookingQueue.isEmpty()) {

            System.out.println("Queue empty.");
            return;
        }

        System.out.println("\nBooking Queue:");

        for(Reservation r : bookingQueue) {

            System.out.println(
                    r.getGuestName() + " -> " + r.getRoomType()
            );
        }
    }
    
    //to return next reservation without printing
    public Reservation getNextReservation() {

        if(bookingQueue.isEmpty()) {
            return null;
        }

        return bookingQueue.poll();
    }
}