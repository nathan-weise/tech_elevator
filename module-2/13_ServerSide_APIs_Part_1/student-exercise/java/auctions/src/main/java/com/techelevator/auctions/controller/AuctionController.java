package com.techelevator.auctions.controller;

import com.techelevator.auctions.DAO.AuctionDAO;
import com.techelevator.auctions.DAO.MemoryAuctionDAO;
import com.techelevator.auctions.model.Auction;
import org.springframework.web.bind.annotation.*;


@RestController
public class AuctionController {

    private final AuctionDAO dao;

    public AuctionController() {
        this.dao = new MemoryAuctionDAO();
    }


}
