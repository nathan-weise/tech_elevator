package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BidTests {

    private static final String BIDDER_NAME = "TestBidder";
    private static final int BID_AMOUNT = 100;

    private Bid sut;

    @Before
    public void setup() {
        //Arrange
        sut = new Bid(BIDDER_NAME, BID_AMOUNT);
    }

    @Test
    public void getBidder_returns_bidder_name() {
        //Arrange
        //Bid bid = new Bid(BIDDER_NAME, 1); changed to @Before
        //Act
        String bidder = sut.getBidder();
        //Assert
    Assert.assertEquals(BIDDER_NAME, bidder);
    }

    @Test
    public void getBidAmount_returns_bid_amount() {
        //Arrange
        //Bid bid = new Bid(BIDDER_NAME, BID_AMOUNT); changed to @Before
        //Act
        int bidAmount = sut.getBidAmount();
        //Assert
        Assert.assertEquals(BID_AMOUNT, bidAmount);
    }

}

