/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.auction.domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Komal
 */
public class Book {

    private int id;
    private String title;
    private String desc;
    private String author;
    private String publisher;
    private String edition;
    private Category caterogy;
    private List<Auction> auctionList = new ArrayList<Auction>();

    public Book() {

    }

    public Book(String title, String desc, String auhtor, String publisher, String edition) {
        this.title = title;
        this.desc = desc;
        this.author = auhtor;
        this.publisher = publisher;
        this.edition = edition;
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
    public String getDesc() {
        return desc;
    }

    /**
     * @param desc the desc to set
     */
    public void setDesc(String desc) {
        this.desc = desc;
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

    public Category getCaterogy() {
        return caterogy;
    }

    public void setCaterogy(Category caterogy) {
        this.caterogy = caterogy;
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

}
