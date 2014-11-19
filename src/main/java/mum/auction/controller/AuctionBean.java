/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.auction.controller;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;
import mum.auction.dao.intr.*;
import mum.auction.dao.intr.DAOFactory;
import mum.auction.dao.intr.UserDAO;
import mum.auction.domain.Auction;
import mum.auction.domain.*;

/**
 *
 * @author Fetiya
 */
@Named("auctionBn")
@SessionScoped
public class AuctionBean implements Serializable {

    private Auction auction = new Auction();

    private Long bookId;
    private Book selectedBook;

    private DAOFactory factory = DAOFactory.getFactory();
    private List<Book> books = new ArrayList<Book>();

    public AuctionBean() {
        setBooks();
        //   auction.setBook(new Book());
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public String addAuction() {

        getAndSetBookByID();

        String titl = auction.getBook().getTitle();
        computeAuctionStatus();
        AuctionDAO auctionDao = factory.getAuctionDAO();

        auctionDao.beginTransaction();
        auctionDao.save(auction);
        auctionDao.commitTransaction();

        return "auctionConfirmation.xhtml";
    }

    public void computeAuctionStatus() {
        Date today = new Date();
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");

        if (fmt.format(today).equals(fmt.format(auction.getStartDate()))) {
            auction.setStatus(Auction.statusType.OPEN);
        } else if (auction.getStartDate().after(today)) {
            auction.setStatus(Auction.statusType.PENDING);

        } else {
            auction.setStatus(Auction.statusType.OPEN);
        }
    }

    public void validateStartDate(FacesContext fc, UIComponent component, Object value) {

        Date startDate = (Date) value;

        if (startDate.before(new Date())) {
            throw new ValidatorException(
                    new FacesMessage("Start date should be current or valid future date"));

        }

    }

    public void validateEndDate(FacesContext fc, UIComponent component, Object value) {

//        if (((String) value).equals("")) {
//            throw new ValidatorException(
//                    new FacesMessage("Please provide an auction end date"));
//        } else {
        Date endDate = (Date) value;

         //   UIInput startDateInput = (UIInput) component.findComponent("startDate");
        //    Date startDate = ((Date) startDateInput.getLocalValue());
//
        if (endDate.before(new Date())) {
            throw new ValidatorException(
                    new FacesMessage("End date should be current or valid future date"));

        }
        //else if (endDate.before(startDate)) {
//                throw new ValidatorException(
//                        new FacesMessage("Auction end date should be later than start date"));
//            }
//        }
    }

    public void cancelAuction(Auction auction) {
        AuctionDAO auctionDao = factory.getAuctionDAO();

        auctionDao.beginTransaction();
        auctionDao.delete(auction);
        auctionDao.commitTransaction();
    }
 public List<Auction> fetchAuctions() {
        AuctionDAO auctionDao = factory.getAuctionDAO();

        auctionDao.beginTransaction();
        List<Auction> auctions=auctionDao.findAll(0, 10);
        auctionDao.commitTransaction();
        return auctions;
    }
    public List<String> completeTitle() {
        String query = null;
        List<String> results = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            results.add(query + i);
        }

        return results;

    }

    public void setBooks() {
        BookDAO bookDao = factory.getBookDAO();

        bookDao.beginTransaction();

        books = bookDao.findAll(0, 10);
        
        for ( Book b : books)
        {
            System.out.println("Book" + b.getTitle());
        }
        bookDao.commitTransaction();

    }

     public void getAndSetBookByID() {

        BookDAO bookDao = factory.getBookDAO();

        bookDao.beginTransaction();

        selectedBook = (Book)bookDao.findByPrimaryKey(bookId);
        auction.setBook(selectedBook);
    
        System.out.println("Book Title" + selectedBook.getTitle());
        bookDao.commitTransaction();

    }

}
