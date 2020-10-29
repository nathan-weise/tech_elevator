package com.techelevator.auctions.DAO;

import com.techelevator.auctions.exception.AuctionNotFoundException;
import com.techelevator.auctions.model.Auction;

import java.util.List;

public interface AuctionDAO {

    List<Auction> list();

    Auction get(int id) throws AuctionNotFoundException;

    Auction create(Auction auction);

    List<Auction> searchByTitle(String searchTerm);

    List<Auction> searchByPrice(double maxPrice);

    Auction update(Auction auction, int id) throws AuctionNotFoundException;

    void delete(int id) throws AuctionNotFoundException;
}
