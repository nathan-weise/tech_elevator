package com.techelevator.auction;

import com.techelevator.models.Auction;
import com.techelevator.services.AuctionService;
import com.techelevator.services.ConsoleService;

public class App {

    private final ConsoleService consoleService = new ConsoleService();
    private final AuctionService auctionService = new AuctionService("http://localhost:3000/auctions");

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    private void run() {
        boolean running = true;
        while (running) {
            int menuSelection = consoleService.printMainMenu();
            if (menuSelection == 1) {
                consoleService.printAuctions(auctionService.getAll());
            } else if (menuSelection == 2) {
                handleListAuctionDetails();
            } else if (menuSelection == 3) {
                handleFindAuctionsByTitle();
            } else if (menuSelection == 4) {
                handleFindAuctionsByPrice();
            } else if (menuSelection == 5) { // Add auction
                handleAddAuction();
            } else if (menuSelection == 6) { // Update location
                handleUpdateAuction();
            } else if (menuSelection == 7) { // Delete location
                handleDeleteAuction();
            } else if (menuSelection == 0) { // Exit
                running = false;
            } else { // defensive programming: anything else is not valid
                System.out.println("Invalid Selection");
            }
        }
    }

    private void handleListAuctionDetails() {
        int auctionId = consoleService.promptForAuction(auctionService.getAll(), "View");
        if (auctionId != 0) {
            consoleService.printAuction(auctionService.getOne(auctionId));
        }
    }

    private void handleFindAuctionsByPrice() {
        double price = consoleService.promptForAuctionPrice();
        if (price != 0.0) {
            consoleService.printAuctions(auctionService.getByPrice(price));
        }
    }

    private void handleFindAuctionsByTitle() {
        String title = consoleService.promptForAuctionTitle();
        if (title != null) {
            consoleService.printAuctions(auctionService.getByTitle(title));
        }
    }

    private void handleAddAuction() {
        String newAuctionString = consoleService.promptForAuctionData();
        Auction auction = auctionService.add(newAuctionString);
        // if unsuccessful
        if (auction == null) {
            System.out.println("Invalid auction. Please enter the Title, Description, User, Current Bid Price (no dollar sign).");
            consoleService.next();
        } else {
            // Print all auctions every time - provides confirmation of action
            consoleService.printAuctions(auctionService.getAll());
        }
    }

    private void handleUpdateAuction() {
        int auctionId = consoleService.promptForAuction(auctionService.getAll(), "Update");
        String CSV = consoleService.promptForAuctionData(auctionService.getOne(auctionId));
        Auction auction = auctionService.update(CSV);
        // if unsuccessful
        if (auction == null) {
            System.out.println("Invalid auction. Please enter the Title, Description, User, Current Bid Price (no dollar sign).");
            consoleService.next();
        } else {
            // Print all locations every time - provides confirmation of action
            consoleService.printAuctions(auctionService.getAll());
        }
    }

    private void handleDeleteAuction() {
        int auctionId = consoleService.promptForAuction(auctionService.getAll(), "Delete");
        auctionService.delete(auctionId);
        // Print all locations every time - provides confirmation of action
        consoleService.printAuctions(auctionService.getAll());
    }
}
