package com.techelevator;

public class Lecture {

    public static void main(String[] args) {

        Bid myBid = new Bid("Fred", 100);

        Auction firstAuction = new Auction("The Krusty Krab");
        System.out.println(firstAuction.getHighBid().getBidAmount());

        firstAuction.placeBid(myBid);
        firstAuction.placeBid(new Bid("Plankton", 5000));
        firstAuction.placeBid(new Bid("Ross", 1000));

        System.out.println("The high bidder on " + firstAuction.getItemForSale() + " is " +
                                firstAuction.getHighBid().getBidder());



        ReserveAuction secondAuction = new ReserveAuction("Old Shoes", 50);

        secondAuction.placeBid(new Bid("Joe", 25));
        secondAuction.placeBid(new Bid("Jordan", 51));

        System.out.println("The high bidder on " + secondAuction.getItemForSale() + " is " +
                secondAuction.getHighBid().getBidder());


        BuyoutAuction thirdAuction = new BuyoutAuction("Ford Pinto", 100);

        thirdAuction.placeBid(new Bid("Nathan", 50));
        thirdAuction.placeBid(new Bid("Christopher", 100));
        thirdAuction.placeBid(new Bid("David", 101));

        System.out.println("The high bidder on " + thirdAuction.getItemForSale() + " is " +
                thirdAuction.getHighBid().getBidder());

    }
}
