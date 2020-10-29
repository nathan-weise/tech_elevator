package com.techelevator.auctions.controller;

import com.techelevator.auctions.DAO.AuctionDAO;
import com.techelevator.auctions.DAO.MemoryAuctionDAO;
import com.techelevator.auctions.model.Auction;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class AuctionController {

    private final AuctionDAO dao;

    public AuctionController() {
        this.dao = new MemoryAuctionDAO();
    }

    @RequestMapping(path = "/auctions", method = RequestMethod.GET)
    public List<Auction> list(@RequestParam(defaultValue = "", name = "title_like") String title,
            @RequestParam(defaultValue = "0", name = "currentBid_lte") Double currentBid) {

        if (title.equals(title) && currentBid != 0) {
            return dao.searchByTitleAndPrice(title, currentBid);
        }
        else if (title.equals(title) && currentBid == 0) {
            return dao.searchByTitle(title);
        } else if (currentBid != 0 && title.equals("")) {
            return dao.searchByPrice(currentBid);
        } else {
            return dao.list();
        }
    }

    @RequestMapping(path = "/auctions/{id}", method = RequestMethod.GET)
    public Auction get(@PathVariable int id) {
        return dao.get(id);
    }

    @RequestMapping(path = "/auctions", method = RequestMethod.POST)
    public Auction create(@RequestBody Auction auction) {
        return dao.create(auction);
    }


}
