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
import mum.auction.dao.impl.BookDAOImpl;
import mum.auction.domain.Book;
import mum.auction.dao.intr.BookDAO;

/**
 *
 * @author Komal
 */

@Named("bookBn")
@SessionScoped
public class BookBean implements Serializable{
    
    private Book book;
    private List<Book> books = new ArrayList<Book>();
    
    public Book getBook()
    {
        return book;
    }
    
    public void setBook(Book book)
    {
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
    
    public void addBook()
    {
         BookDAO bookDao = new BookDAOImpl();
         bookDao.addBook(book);
    }
   
    public void validateBookTitle(FacesContext fc, UIComponent c, Object value) {
	   if (((String) value).equals(""))
	      throw new ValidatorException(
	         new FacesMessage("Please provide title"));
   }
    
    public void validateBookDescription(FacesContext fc, UIComponent c, Object value) {
	   if (((String) value).equals(""))
	      throw new ValidatorException(
	         new FacesMessage("Please provide description"));
   }
    
    public void validateBookAuthor(FacesContext fc, UIComponent c, Object value) {
	   if (((String) value).equals(""))
	      throw new ValidatorException(
	         new FacesMessage("Please provide author"));
   }
    
    public void validateBookPublisher(FacesContext fc, UIComponent c, Object value) {
	   if (((String) value).equals(""))
	      throw new ValidatorException(
	         new FacesMessage("Please provide publisher"));
   }
    
    public void validateBookEdition(FacesContext fc, UIComponent c, Object value) {
	   if (((String) value).equals(""))
	      throw new ValidatorException(
	         new FacesMessage("Please provide edition"));
   }
   
}
