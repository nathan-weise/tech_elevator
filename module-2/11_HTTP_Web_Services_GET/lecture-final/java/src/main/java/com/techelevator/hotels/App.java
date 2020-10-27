package com.techelevator.hotels;

import java.util.Scanner;

import org.springframework.web.client.RestTemplate;

public class App {
    private static final String API_URL = "http://localhost:3000/";
    private RestTemplate restTemplate = new RestTemplate();

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    private void run() {
        Hotel[] hotels = null;
        Scanner scanner = new Scanner(System.in);
        int menuSelection = 999;

        while(menuSelection != 0) {
            printGreeting();
            try {
                menuSelection = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException exception) {
                System.out.println("Error parsing the input for menu selection.");
            }
            System.out.println();
            if (menuSelection == 1) {
                listHotels();
            } else if (menuSelection == 2) {
                listReviews();
            } else if (menuSelection == 3) {
                showHotel(1);
            } else if (menuSelection == 4) {
                showHotel1Reviews();
            } else if (menuSelection == 5) {
                list3StarHotels();
            } else if (menuSelection == 0) {
                continue;
            } else {
                System.out.println("Invalid Selection");
            }
            System.out.println("\nPress Enter to continue...");
            scanner.nextLine();
        }
    }

    private void listHotels() {
        Hotel[] hotels = restTemplate.getForObject(API_URL + "hotels", Hotel[].class);
        printHotels(hotels);
    }

    private void listReviews() {
        Review[] reviews = restTemplate.getForObject(API_URL + "reviews", Review[].class);
        printReviews(reviews);
    }

    private void showHotel(int id) {
        Hotel hotel = restTemplate.getForObject(API_URL + "hotels/" + id, Hotel.class);
        printHotel(hotel);
    }

    private void showHotel1Reviews() {
        Review[] reviews = restTemplate.getForObject(API_URL + "hotels/1/reviews", Review[].class);
        printReviews(reviews);
    }

    private void list3StarHotels() {
        Hotel[] hotels = restTemplate.getForObject(API_URL + "hotels?stars=3", Hotel[].class);
        printHotels(hotels);
    }

    private void printGreeting() {
        System.out.println();
        System.out.println("Welcome to Tech Elevator Hotels. Please make a selection: ");
        System.out.println("1: List Hotels");
        System.out.println("2: List Reviews");
        System.out.println("3: Show Details for Hotel ID 1");
        System.out.println("4: List Reviews for Hotel ID 1");
        System.out.println("5: List Hotels with star rating 3");
        System.out.println("0: Exit");
        System.out.println();
        System.out.print("Please choose an option: ");
    }

    private void printHotels(Hotel[] hotels) {
        System.out.println("--------------------------------------------");
        System.out.println("Hotels");
        System.out.println("--------------------------------------------");
        for (Hotel hotel : hotels) {
            System.out.println(hotel.getId() + ": " + hotel.getName());
        }
    }

    private void printHotel(Hotel hotel) {
        System.out.println(hotel.toString());
    }

    private void printReviews(Review[] reviews) {
        for (Review review : reviews) {
            System.out.println(review.toString());
        }
    }

}
