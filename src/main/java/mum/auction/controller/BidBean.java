/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.auction.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import mum.auction.dao.intr.AuctionDAO;
import mum.auction.dao.intr.BidDAO;
import mum.auction.dao.intr.DAOFactory;
import mum.auction.dao.intr.UserDAO;
import mum.auction.domain.Auction;
import mum.auction.domain.Bid;
import mum.auction.domain.Book;
import mum.auction.domain.User;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Fetiya
 */
@Named("bidBn")
@SessionScoped
public class BidBean implements Serializable {

    private Bid bid = new Bid();
    private double offeredPrice;
    private DAOFactory factory = DAOFactory.getFactory();

    private List<Bid> bids = new ArrayList();
    private List<Bid> auctionBids;

    public double getOfferedPrice() {
        return offeredPrice;
    }

    public void setOfferedPrice(double offeredPrice) {
        this.offeredPrice = offeredPrice;
    }

    public List<Bid> getAuctionBids() {
        return auctionBids;
    }

    public void setAuctionBids(List<Bid> auctionBids) {
        this.auctionBids = auctionBids;
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
        AuctionDAO auctionDao = factory.getAuctionDAO();
        auctionDao.beginTransaction();
        Auction auction = auctionDao.findByPrimaryKey(auctionId);
        bid.setAuction(auction);
        auctionDao.commitTransaction();

       // UserDAO userDao = factory.getUserDAO();
       // userDao.beginTransaction();
        User user =  getCurrentUser();   // userDao.findByPrimaryKey(userId);
        bid.setUser(user);
        //userDao.commitTransaction();
        
        //bid= new Bid(auction,user,offeredPrice);
        
        bid.setOfferedPrice(offeredPrice);
        BidDAO bidDao = factory.getBidDAO();
        bidDao.beginTransaction();
        bidDao.save(bid);
        bidDao.commitTransaction();
        return "registered";
    }

    
    private User getCurrentUser() {

        FacesContext context = FacesContext.getCurrentInstance();

        Map<String, Object> map = context.getExternalContext().getSessionMap();

        User currentUser = (User) map.get("LoggedInUser");

        System.out.println("loggedin User id is" + currentUser.getFirstName());
        return currentUser;
    }
}
