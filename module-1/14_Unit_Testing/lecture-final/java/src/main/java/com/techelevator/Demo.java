package com.techelevator;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Demo {


    public static void main(String[] args) {
        Auction myAuction = new Auction("Treasure Chest");
        myAuction.placeBid(new Bid("Ben", 25));
        myAuction.placeBid(new Bid("Christopher", 50));
        myAuction.placeBid(new Bid("Ben", 200));
        Bid winningBid = myAuction.getHighBid();
        System.out.println("The winner is: " + winningBid.getBidder());


        //Map<String, BigDecimal> prices = new HashMap<>(); //order not important
        Map<String, BigDecimal> prices = new LinkedHashMap<>(); //order items added is preserved
        //Map<String, BigDecimal> prices = new TreeMap<>(); //ordered by natural order of keys
        prices.put("Golf ball", new BigDecimal("1.99"));
        prices.put("Umbrella", new BigDecimal("600.00"));
        prices.put("Golf club", new BigDecimal("99.99"));
        prices.put("Tees", new BigDecimal("0.50"));

        for (Map.Entry<String, BigDecimal> price : prices.entrySet()) {
            System.out.println(price.getKey() + " is available for $" + price.getValue());
        }





    }
}
