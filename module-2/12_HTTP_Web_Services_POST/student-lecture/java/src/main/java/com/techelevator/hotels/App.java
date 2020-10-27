package com.techelevator.hotels;

import com.techelevator.hotels.models.Hotel;
import com.techelevator.hotels.models.Reservation;
import com.techelevator.hotels.services.ConsoleService;
import com.techelevator.hotels.services.HotelService;

public class App {

    private static final String API_BASE_URL = "http://localhost:3000/";
    private final ConsoleService consoleService = new ConsoleService();
    private final HotelService hotelService = new HotelService(API_BASE_URL);

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    private void run() {
        int menuSelection = 999;
        while (menuSelection != 0) {
            menuSelection = consoleService.printMainMenu();
            if(menuSelection == 1) {
                handleListHotels();
            } else if(menuSelection == 2) {
                handleListReservations();
            } else if(menuSelection == 3) {
                handleAddReservation();
            } else if(menuSelection == 4) {
                handleUpdateReservation();
            } else if(menuSelection == 5) {
                handleDeleteReservation();
            }
            else if (menuSelection != 0) {
                // anything else is not valid
                System.out.println("Invalid Selection");
            }
        }
        System.out.println("Goodbye!");
    }

    private void handleListHotels() {
        // List all hotels
        Hotel[] hotels = hotelService.listHotels();
        if( hotels != null ){
            consoleService.printHotels(hotels);
        }
    }

    private void handleListReservations() {
        // List Reservations for hotel
        Hotel[] hotels = hotelService.listHotels();
        if( hotels != null ) {
            int hotelId = consoleService.promptForHotel(hotels, "List Reservations");
            if(hotelId !=0) {
                Reservation[] reservations = hotelService.listReservationsByHotel(hotelId);
                if( reservations != null ) {
                    consoleService.printReservations(reservations,hotelId);
                }
            }
        }
    }

    private void handleAddReservation() {
        // Create new reservation for a given hotel
        String newReservationString = consoleService.promptForReservationData();
        Reservation reservation = hotelService.addReservation(newReservationString);
        // if unsuccessful
        if(reservation == null){
            System.out.println("Invalid Reservation. Please enter the Hotel Id, Full Name, Checkin Date, Checkout Date and Guests");
        }
    }

    private void handleUpdateReservation() {
        Reservation[] reservations = hotelService.listReservations();
        if( reservations != null ) {
            int reservationId = consoleService.promptForReservation(reservations, "Update Reservation");
            Reservation existingReservation = hotelService.getReservation(reservationId);
            if( existingReservation != null ) {
                String csv = "" + reservationId + ",";
                csv += consoleService.promptForReservationData();
                Reservation reservation = hotelService.updateReservation(csv);
                if(reservation == null){
                    System.out.println("Invalid Reservation. Hotel Id, Full Name, Checkin Date, Checkout Date, Guests");
                }
            }
        }
    }

    private void handleDeleteReservation() {
        Reservation[] reservations = hotelService.listReservations();
        if( reservations != null ) {
            int reservationId = consoleService.promptForReservation(reservations, "Delete Reservation");
            hotelService.deleteReservation(reservationId);
        }
    }

}
