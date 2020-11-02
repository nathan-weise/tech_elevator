package com.techelevator.auction;

import com.techelevator.services.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;

import com.techelevator.models.Auction;

import java.util.Map;

public class App {
    private static final String API_BASE_URL = "http://localhost:8080/";

    private final ConsoleService consoleService = new ConsoleService();
    private final AuctionService auctionService = new AuctionService(API_BASE_URL);
    private final AuthenticationService authenticationService = new AuthenticationService(API_BASE_URL);

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
                    consoleService.printAuctions(auctionService.getAll());
                } else if (menuSelection == 2) {
                    handleListAuctionDetails();
                } else if (menuSelection == 3) {
                    handleFindAuctionsByTitle();
                } else if (menuSelection == 4) {
                    handleFindAuctionsByPrice();
                } else if (menuSelection == 5) {
                    handleCreateAuction();
                } else if (menuSelection == 6) {
                    handleModifyAuction();
                } else if (menuSelection == 7) {
                    handleDeleteAuction();
                } else if (menuSelection == 8) {
                    handleLogin();
                } else if (menuSelection != 0) {
                    System.out.println("Invalid Selection");
                }
            } catch (AuctionServiceException ex) {
                consoleService.printError(ex.getMessage());
                consoleService.next();
            }
        }
    }

    private void handleListAuctionDetails() throws AuctionServiceException {
        Auction[] auctions = auctionService.getAll();
        if (auctions != null) {
            int auctionId = consoleService.promptForAuction(auctions, "View");
            if (auctionId != 0) {
                consoleService.printAuction(auctionService.getOne(auctionId));
            }
        }
    }

    private void handleFindAuctionsByTitle() throws AuctionServiceException {
        String title = consoleService.promptForAuctionTitle();
        if (title != null) {
            consoleService.printAuctions(auctionService.getByTitle(title));
        }
    }

    private void handleFindAuctionsByPrice() throws AuctionServiceException {
        double price = consoleService.promptForAuctionPrice();
        if (price != 0.0) {
            consoleService.printAuctions(auctionService.getByPrice(price));
        }
    }

    private void handleCreateAuction() throws AuctionServiceException {
        String newAuctionString = consoleService.promptForAuctionData();
        Auction auction = auctionService.add(newAuctionString);
        // if unsuccessful
        if (auction == null) {
            System.out.println("Invalid auction. Please enter the Title, Description, User, Current Bid Price (no dollar sign).");
        } else {
            consoleService.printAuctions(auctionService.getAll());
        }
    }

    private void handleModifyAuction() throws AuctionServiceException {
        Auction[] auctions = auctionService.getAll();
        if (auctions != null) {
            int auctionId = consoleService.promptForAuction(auctions, "Update");
            Auction auction = auctionService.getOne(auctionId);
            if (auction != null) {
                String CSV = consoleService.promptForAuctionData(auction);
                auction = auctionService.update(CSV);
                // if unsuccessful
                if (auction == null) {
                    System.out.println("Invalid auction. Please enter the Title, Description, User, Current Bid Price (no dollar sign).");
                } else {
                    consoleService.printAuctions(auctionService.getAll());
                }
            }
        }
    }

    private void handleDeleteAuction() throws AuctionServiceException {
        Auction[] auctions = auctionService.getAll();
        if (auctions != null) {
            int auctionId = consoleService.promptForAuction(auctions, "Delete");
            auctionService.delete(auctionId);
            consoleService.printAuctions(auctionService.getAll());
        }
    }

    private void handleLogin() {
        String credentials = consoleService.promptForLogin();
        if( credentials.split(",").length == 2 ) {
            try {
                ResponseEntity<Map> response = authenticationService.login(credentials);
                if (response.hasBody()) {
                    auctionService.setAuthToken((String) response.getBody().get("token"));
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
