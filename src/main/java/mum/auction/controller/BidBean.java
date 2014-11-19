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
import mum.auction.dao.intr.AuctionDAO;
import mum.auction.dao.intr.BidDAO;
import mum.auction.dao.intr.DAOFactory;
import mum.auction.dao.intr.UserDAO;
import mum.auction.domain.Auction;
import mum.auction.domain.Bid;
import mum.auction.domain.Book;
import mum.auction.domain.User;

/**
 *
 * @author Fetiya
 */
@Named("bid")
@SessionScoped
public class BidBean implements Serializable {
    
    private Bid bid = new Bid();
    private double offeredPrice;
    private DAOFactory factory = DAOFactory.getFactory();
    
    private List<Bid> bids = new ArrayList();
    
    public double getOfferedPrice() {
        return offeredPrice;
    }
    
    public void setOfferedPrice(double offeredPrice) {
        this.offeredPrice = offeredPrice;
    }
    
    public Bid getBid() {
        return bid;
    }
    
    public void setBid(Bid bid) {
        this.bid = bid;
    }
    
    public List<Bid> getBids() {
        return bids;
    }
    
    public void setBids(List<Bid> bids) {
        this.bids = bids;
    }
    
    public String registerBid(Long auctionId, Long userId) {
        BidDAO bidDao = factory.getBidDAO();
        AuctionDAO auctionDao = factory.getAuctionDAO();
        auctionDao.beginTransaction();
        Auction auction = auctionDao.findByPrimaryKey(auctionId);
        auctionDao.commitTransaction();
        UserDAO userDao = factory.getUserDAO();
        userDao.beginTransaction();
        User user = userDao.findByPrimaryKey(userId);
        userDao.commitTransaction();
        bid.setAuction(auction);
        bid.setUser(user);
        bid.setOfferedPrice(offeredPrice);
        bidDao.beginTransaction();
        bidDao.save(bid);
        bidDao.commitTransaction();
        return "registered";
    }
    
}
