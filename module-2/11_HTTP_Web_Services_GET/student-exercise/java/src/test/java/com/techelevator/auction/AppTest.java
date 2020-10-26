package com.techelevator.auction;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.web.client.RestTemplate;

public class AppTest {

        App app;
        RestTemplate mockRestTemplate;

        private final Auction[] auctions = { new Auction(0, "Zero", "Zero Auction", "User0", 0.0),
                        new Auction(1, "One", "One Auction", "User1", 1.1) };

        private final Auction auction = new Auction(0, "Zero", "Zero Auction", "User0", 0.0);

        /**
         * Scanner is instantiated with System.in and must be started for each test
         * individually.
         * 
         * @param input
         */
        private void initForScannerPurposes(String input) {
                mockRestTemplate = Mockito.mock(RestTemplate.class);
                app = new App(mockRestTemplate, new Scanner(new ByteArrayInputStream(input.getBytes())));
        }

        /**
         * reduce repeated code
         * 
         * @param url
         */
        private void mockHelper(String url) {
                Mockito.when(mockRestTemplate.getForObject(Mockito.eq(url), Mockito.eq(Auction[].class)))
                                .thenReturn(auctions);

        }


        @Test
        public void listAllAuctions() {
                initForScannerPurposes("1");
                mockHelper("http://localhost:3000/auctions");
                assertArrayEquals(auctions, app.listAllAuctions());
        }

        @Test
        public void listDetailsForAuction() {
                initForScannerPurposes("1");
                String url = "http://localhost:3000/auctions/1";

                Mockito.when(mockRestTemplate.getForObject(Mockito.eq(url), Mockito.eq(Auction.class)))
                                .thenReturn(auction);

                assertEquals(auction, app.listDetailsForAuction());
        }

        /*
         * Test should pass without throwing a NumberFormatException
         */
        @Test
        public void listDetailsForAuctionShouldNotThrowNumberFormatException() {
                // Arrange
                initForScannerPurposes("what");

                // Act
                Auction auction = app.listDetailsForAuction();

                // Assert
                Mockito.verify(mockRestTemplate, Mockito.never()).getForObject(ArgumentMatchers.anyString(),
                                ArgumentMatchers.eq(Auction.class));

                assertNull(auction);
        }

        @Test
        public void findAuctionsSearchTitle() {
                initForScannerPurposes("Zero");
                mockHelper("http://localhost:3000/auctions?title_like=Zero");
                assertArrayEquals(auctions, app.findAuctionsSearchTitle());
        }

        @Test
        public void findAuctionsSearchPrice() {
                initForScannerPurposes("23.25");
                mockHelper("http://localhost:3000/auctions?currentBid_lte=23.25");
                assertArrayEquals(auctions, app.findAuctionsSearchPrice());
        }

        /*
         * Test should pass without throwing a NumberFormatException
         */
        @Test
        public void findAuctionsSearchPriceShouldNotThrowNumberFormatException() {
                // Arrange
                initForScannerPurposes("what");

                // Act
                Auction[] auctions = app.findAuctionsSearchPrice();

                // Assert
                Mockito.verify(mockRestTemplate, Mockito.never()).getForObject(ArgumentMatchers.anyString(),
                                ArgumentMatchers.eq(Auction[].class));

                assertNull(auctions);
        }
}
