package com.techelevator.hotels;

import com.techelevator.hotels.models.Hotel;
import com.techelevator.hotels.models.Reservation;
import com.techelevator.hotels.services.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.ResourceAccessException;

import java.util.Map;

public class App {

    private static final String API_BASE_URL = "http://localhost:8080/";

    private ConsoleService consoleService = new ConsoleService();
    private HotelService hotelService = new HotelService(API_BASE_URL);
    private AuthenticationService authenticationService = new AuthenticationService(API_BASE_URL);

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    private void run() {
        int menuSelection = -1;
        while (menuSelection != 0) {
            menuSelection = consoleService.printMainMenu();
            try {
                if (menuSelection == 1) {
                    consoleService.printHotels(hotelService.listHotels());
                } else if (menuSelection == 2) {
                    handleListReservations();
                } else if (menuSelection == 3) {
                    handleCreateReservation();
                } else if (menuSelection == 4) {
                    handleUpdateReservation();
                } else if (menuSelection == 5) {
                    handleDeleteReservation();
                } else if (menuSelection == 6) {
                    handleLogin();
                } else if (menuSelection != 0) {
                    System.out.println("Invalid Selection");
                }
            } catch (HotelServiceException ex) {
                consoleService.printError(ex.getMessage());
                consoleService.next();
            }
        }
    }

    private void handleListReservations() throws HotelServiceException {
        int hotelId = consoleService.promptForHotel(hotelService.listHotels(), "List Reservations");
        if (hotelId != 0) {
            consoleService.printReservations(hotelService.listReservationsByHotel(hotelId), hotelId);
        }
    }

    private void handleCreateReservation() throws HotelServiceException {
        String newReservationString = consoleService.promptForReservationData();
        Reservation reservation = hotelService.addReservation(newReservationString);
    }

    private void handleUpdateReservation() throws HotelServiceException {
        Reservation[] reservations = hotelService.listReservations();
        if (reservations != null) {
            int reservationId = consoleService.promptForReservation(reservations, "Update Reservation");
            Reservation existingReservation = hotelService.getReservation(reservationId);
            if (existingReservation != null) {
                String csv = "" + reservationId + ",";
                csv += consoleService.promptForReservationData();
                hotelService.updateReservation(csv);
            }
        }
    }

    private void handleDeleteReservation() throws HotelServiceException {
        Reservation[] reservations = hotelService.listReservations();
        if (reservations != null) {
            int reservationId = consoleService.promptForReservation(reservations, "Delete Reservation");
            hotelService.deleteReservation(reservationId);
        }
    }

    private void handleLogin() {
        String credentials = consoleService.promptForLogin();
        if( credentials.split(",").length == 2 ) {
            try {
                ResponseEntity<Map> response = authenticationService.login(credentials);
                if (response.hasBody()) {
                    String token = (String) response.getBody().get("token");
                    hotelService.setAuthToken(token);
                    System.out.println("Login Successful");
                }
            } catch (AuthenticationServiceException ex) {
                consoleService.printError(ex.getMessage());
                consoleService.next();
            }
        } else {
            consoleService.printError("Please enter username and password separated by a comma.");
        }
    }

}
