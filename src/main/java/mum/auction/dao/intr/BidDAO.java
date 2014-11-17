/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mum.auction.dao.intr;

import java.util.List;
import mum.auction.domain.Bid;

/**
 *
 * @author Fetiya
 */
public interface BidDAO {
    
    public void addBid(Bid bid);
     
     public void updateBid(Bid bid);
     
     public Bid getBid(int id);
     
     public List<Bid> getAllBids();
     
     public void removeBid(Bid bid);
}
