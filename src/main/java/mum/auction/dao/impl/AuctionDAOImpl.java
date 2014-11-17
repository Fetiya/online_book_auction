/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mum.auction.dao.impl;

import java.util.List;
import mum.auction.dao.intr.AuctionDAO;
import mum.auction.domain.Auction;

/**
 *
 * @author Fetiya
 */
public class AuctionDAOImpl implements AuctionDAO {

    @Override
    public void addAuction(Auction auction) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
        System.out.println("Sumbitted Auction Values to Save");
        System.out.println("" + auction.getBook().getTitle());
        System.out.println("" + auction.getStartDate());
        System.out.println("Auction end date" + auction.getEndDate());
        System.out.println("Auction amount" + auction.getMinimumPrice());
        System.out.println("Auction status" + auction.getStatus());
    }

    @Override
    public void updateAuction(Auction auction) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Auction getAuction(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Auction> getAllAuctions() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeAuction(Auction auction) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
