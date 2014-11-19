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
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;

import mum.auction.domain.Book;
import mum.auction.dao.intr.BookDAO;

import mum.auction.dao.intr.*;
import mum.auction.dao.impl.*;
import mum.auction.domain.Auction;

/**
 *
 * @author Komal
 */
@Named("bookBn")
@SessionScoped
public class BookBean implements Serializable {

    private Book book = new Book();
    private List<Book> books = new ArrayList<Book>();

    private DAOFactory factory = DAOFactory.getFactory();

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    /**
     * @return the books
     */
    public List<Book> getBooks() {
        return books;
    }

    /**
     * @param books the books to set
     */
    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public String addBook() {

        BookDAO bookDao = factory.getBookDAO();
        // bookDao.addBook(book);
        bookDao.beginTransaction();
        bookDao.save(book);
        bookDao.commitTransaction();
        return "confirmBook";
    }

    public void validateBookTitle(FacesContext fc, UIComponent c, Object value) {
        if (((String) value).equals("")) {
            throw new ValidatorException(
                    new FacesMessage("Please provide title"));
        }
    }

    public void validateBookDescription(FacesContext fc, UIComponent c, Object value) {
        if (((String) value).equals("")) {
            throw new ValidatorException(
                    new FacesMessage("Please provide description"));
        }
    }

    public void validateBookAuthor(FacesContext fc, UIComponent c, Object value) {
        if (((String) value).equals("")) {
            throw new ValidatorException(
                    new FacesMessage("Please provide author"));
        }
    }

    public void validateBookPublisher(FacesContext fc, UIComponent c, Object value) {
        if (((String) value).equals("")) {
            throw new ValidatorException(
                    new FacesMessage("Please provide publisher"));
        }
    }

    public void validateBookEdition(FacesContext fc, UIComponent c, Object value) {
        if (((String) value).equals("")) {
            throw new ValidatorException(
                    new FacesMessage("Please provide edition"));
        }
    }

    public List<Book> fetchBooks() {
        BookDAO bookDao = factory.getBookDAO();

        bookDao.beginTransaction();
        List<Book> books = bookDao.findAll(0, 10);
        bookDao.commitTransaction();
        return books;
    }

    public String getBookByID(Long id) {
        BookDAO bookDao = factory.getBookDAO();
        bookDao.beginTransaction();
        book = (Book) bookDao.findByPrimaryKey(id);
        bookDao.commitTransaction();
        return "bookDetail";
    }
}
