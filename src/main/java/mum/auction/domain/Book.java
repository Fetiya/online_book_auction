/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.auction.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


/**
 *
 * @author Komal
 */

@Entity
public class Book {

    
    @Id
    @GeneratedValue
    private Long id;


    private String title;
    private String description;
    private String author;
    private String publisher;
    private String edition;
    private String pictureURL;
    
    @OneToMany(mappedBy = "book",  cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    private List<Auction> auctionList ;
    
    
    @ManyToOne
    @JoinColumn(name = "bookCategory_id")
    private BookCategory bookCategory;
 

    public Book() {

    }

    public Book(String title, String description, String author, String publisher, String edition, String pictureURL, List<Auction> auctionList, BookCategory bookCategory) {
        this.title = title;
        this.description = description;
        this.author = author;
        this.publisher = publisher;
        this.edition = edition;
        this.pictureURL = pictureURL;
        this.auctionList = auctionList;
        this.bookCategory = bookCategory;
    }

  
    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }

   
  

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the desc
     */
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

 

    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return the publisher
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * @param publisher the publisher to set
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * @return the edition
     */
    public String getEdition() {
        return edition;
    }

    /**
     * @param edition the edition to set
     */
    public void setEdition(String edition) {
        this.edition = edition;
    }

    public BookCategory getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(BookCategory bookCategory) {
        this.bookCategory = bookCategory;
    }

 
  

    /**
     * @return the auctionList
     */
    public List<Auction> getAuctionList() {
        return auctionList;
    }

    /**
     * @param auctionList the auctionList to set
     */
    public void setAuctionList(List<Auction> auctionList) {
        this.auctionList = auctionList;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.title);
        hash = 67 * hash + Objects.hashCode(this.description);
        hash = 67 * hash + Objects.hashCode(this.author);
        hash = 67 * hash + Objects.hashCode(this.publisher);
        hash = 67 * hash + Objects.hashCode(this.edition);
        hash = 67 * hash + Objects.hashCode(this.pictureURL);
        hash = 67 * hash + Objects.hashCode(this.auctionList);
        hash = 67 * hash + Objects.hashCode(this.bookCategory);
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
        final Book other = (Book) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.author, other.author)) {
            return false;
        }
        if (!Objects.equals(this.publisher, other.publisher)) {
            return false;
        }
        if (!Objects.equals(this.edition, other.edition)) {
            return false;
        }
        if (!Objects.equals(this.pictureURL, other.pictureURL)) {
            return false;
        }
        if (!Objects.equals(this.auctionList, other.auctionList)) {
            return false;
        }
        if (!Objects.equals(this.bookCategory, other.bookCategory)) {
            return false;
        }
        return true;
    }

   
    


}
