package com.bookmystay.service;

import java.util.ArrayList;
import java.util.List;

import com.bookmystay.model.Reservation;

public class BookingHistoryService {

    private List<Reservation> bookingHistory;

    public BookingHistoryService() {

        bookingHistory = new ArrayList<>();
    }

    // store confirmed reservation
    public void addReservation(Reservation r) {

        bookingHistory.add(r);

        System.out.println("Reservation stored in history.");
    }

    // show booking history
    public void showHistory() {

        if(bookingHistory.isEmpty()) {

            System.out.println("No booking history.");
            return;
        }

        System.out.println("\nBooking History:");

        for(Reservation r : bookingHistory) {

            System.out.println(
                    "Guest: " + r.getGuestName() +
                    " | Room: " + r.getRoomType()
            );
        }
    }

    // cancel reservation
    public void cancelReservation(String guestName) {

        boolean removed = bookingHistory.removeIf(
                r -> r.getGuestName().equalsIgnoreCase(guestName)
        );

        if(removed) {

            System.out.println("Reservation cancelled.");
        }
        else {

            System.out.println("Reservation not found.");
        }
    }

    // simple report
    public void generateReport() {

        System.out.println("\nTotal Reservations: " + bookingHistory.size());
    }
}