package com.bookmystay.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bookmystay.model.Service;

public class AddOnServiceManager {

    private Map<String, List<Service>> reservationServices;

    public AddOnServiceManager() {
        reservationServices = new HashMap<>();
    }

    // add service to reservation
    public void addService(String reservationId, Service service) {

        reservationServices.putIfAbsent(reservationId, new ArrayList<>());

        reservationServices.get(reservationId).add(service);

        System.out.println("Service added to reservation " + reservationId);
    }

    // show services for reservation
    public void showServices(String reservationId) {

        List<Service> services = reservationServices.get(reservationId);

        if(services == null) {

            System.out.println("No services attached.");
            return;
        }

        double total = 0;

        System.out.println("\nServices for Reservation " + reservationId);

        for(Service s : services) {

            System.out.println(s);

            total += s.getCost();
        }

        System.out.println("Total Add-On Cost: ₹" + total);
    }
}