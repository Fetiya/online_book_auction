/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mum.auction.dao.intr;

import java.util.List;
import mum.auction.domain.Auction;

/**
 *
 * @author Fetiya
 */
public interface AuctionDAO {
    
    public void addAuction(Auction auction);
     
    public void updateAuction(Auction auction);
     
    public Auction getAuction(int id);
     
    public List<Auction> getAllAuctions();
     
    public void removeAuction(Auction auction);
}
