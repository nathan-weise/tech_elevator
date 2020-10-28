package com.techelevator.auctions.DAO;

import com.techelevator.auctions.model.Auction;

import java.util.List;

public interface AuctionDAO {

    List<Auction> list();

    Auction get(int id);

    Auction create(Auction auction);

    List<Auction> searchByTitle(String searchTerm);

    List<Auction> searchByPrice(double maxPrice);

    List<Auction> searchByTitleAndPrice(String title, double currentBid);
}
