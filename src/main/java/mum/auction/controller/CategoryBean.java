/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.auction.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import mum.auction.dao.impl.AuctionDAOImpl;
import mum.auction.dao.intr.AuctionDAO;
import mum.auction.domain.Auction;

/**
 *
 * @author Hiwot
 */

@Named("category")
@SessionScoped
public class CategoryBean implements Serializable {

//    private AuctionDAO auctionDAO = new AuctionDAOImpl();
    private Auction auction= new Auction();

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }

    public String addAuction() {
        auctionDAO.addAuction(auction);
        
        return "index";
    }

    public void cancelAuction() {
        auctionDAO.removeAuction(auction);
    }

    public List<String> completeTitle() {
        String query = null;
        List<String> results = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            results.add(query + i);
        }

        return results;

    }
}
