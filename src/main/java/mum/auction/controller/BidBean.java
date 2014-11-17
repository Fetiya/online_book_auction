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
import mum.auction.domain.Bid;

/**
 *
 * @author Fetiya
 */
@Named("bid")
@SessionScoped
public class BidBean implements Serializable {
    
   private Bid bid;
   
   private List<Bid> bids =new ArrayList();

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
   
  
    
}
