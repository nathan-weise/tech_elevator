package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class AuctionTests {



    @Test
    public void higher_bid_wins_regardless_of_order_placed() {
        //Arrange
        Auction sut = new Auction("Thing");
        sut.placeBid(new Bid("Person 1", 100));
        sut.placeBid(new Bid("Person 2", 50));

        //Act
        Bid winningBid = sut.getHighBid();

        //Assert
        Assert.assertEquals("Person 1", winningBid.getBidder());
    }

    @Test
    public void getAllBids_returns_correct_number_of_bids() {
        //Arrange
        Auction sut = new Auction("Thing");
        sut.placeBid(new Bid("Person 1", 100));
        sut.placeBid(new Bid("Person 2", 50));
        sut.placeBid(new Bid("Person 3", 500));
        sut.placeBid(new Bid("Person 2", 550));

        //Act
        List<Bid> allBids = sut.getAllBids();

        //Assert
        Assert.assertEquals(4, allBids.size());
    }


}
