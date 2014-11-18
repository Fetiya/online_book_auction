/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mum.auction.domain;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author hiwot
 */

@Entity

public class Auction {
    
    @Id
    @GeneratedValue
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
  
    
    private Date startDate;
    private Date endDate;
    private double minimumPrice;
    
     public enum statusType{
        PENDING,OPEN,CLOSED,CANCELLED;
    }
    
    @Enumerated(EnumType.STRING)
    private statusType status;
    
  
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    @OneToMany(mappedBy = "auction",cascade = CascadeType.ALL)
    private List<Bid> bids;

    public Auction() {
    }

    public Auction(Book book, Date startDate, Date endDate, double minimumPrice, statusType status, User user, List<Bid> bids) {
        this.book = book;
        this.startDate = startDate;
        this.endDate = endDate;
        this.minimumPrice = minimumPrice;
        this.status = status;
        this.user = user;
        this.bids = bids;
    }

   

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Bid> getBids() {
        return bids;
    }

    public void setBids(List<Bid> bids) {
        this.bids = bids;
    }

    public statusType getStatus() {
        return status;
    }

    public void setStatus(statusType status) {
        this.status = status;
    }
    
    
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

 
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getMinimumPrice() {
        return minimumPrice;
    }

    public void setMinimumPrice(double minimumPrice) {
        this.minimumPrice = minimumPrice;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.book);
        hash = 61 * hash + Objects.hashCode(this.startDate);
        hash = 61 * hash + Objects.hashCode(this.endDate);
        hash = 61 * hash + (int) (Double.doubleToLongBits(this.minimumPrice) ^ (Double.doubleToLongBits(this.minimumPrice) >>> 32));
        hash = 61 * hash + Objects.hashCode(this.status);
        hash = 61 * hash + Objects.hashCode(this.user);
        hash = 61 * hash + Objects.hashCode(this.bids);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Auction other = (Auction) obj;
        if (!Objects.equals(this.book, other.book)) {
            return false;
        }
        if (!Objects.equals(this.startDate, other.startDate)) {
            return false;
        }
        if (!Objects.equals(this.endDate, other.endDate)) {
            return false;
        }
        if (Double.doubleToLongBits(this.minimumPrice) != Double.doubleToLongBits(other.minimumPrice)) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        if (!Objects.equals(this.bids, other.bids)) {
            return false;
        }
        return true;
    }

  

   
    
    
}
