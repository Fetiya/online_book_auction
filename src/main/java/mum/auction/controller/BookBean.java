/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.auction.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;
import mum.auction.dao.impl.*;
import mum.auction.dao.intr.*;
import mum.auction.dao.intr.BookDAO;
import mum.auction.domain.Book;
import mum.auction.domain.BookCategory;
import mum.auction.domain.User;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Komal
 */
@Named("bookBn")
@SessionScoped
public class BookBean implements Serializable {

    private Book book = new Book();
    private List<Book> books = new ArrayList<Book>();
    private List<BookCategory> bookCategories = new ArrayList<BookCategory>();
    private BookCategory category = new BookCategory();
    private List<Book> searchedBooks = new ArrayList<Book>();
    private Long selectedCategoryId;

    private DAOFactory factory = DAOFactory.getFactory();

    public BookBean() {

        initBookCategories();
    }

    public Long getSelectedCategoryId() {
        return selectedCategoryId;
    }

    public void setSelectedCategoryId(Long selectedCategoryId) {
        this.selectedCategoryId = selectedCategoryId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public BookCategory getCategory() {
        return category;
    }

    public void setCategory(BookCategory category) {
        this.category = category;
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

    public List<BookCategory> getBookCategories() {
        return bookCategories;
    }

    public void setBookCategories(List<BookCategory> bookCategories) {
        this.bookCategories = bookCategories;
    }

    public String addBook() {
        
        setBookCategoryById(selectedCategoryId);
        
        BookDAO bookDao = factory.getBookDAO();
        // bookDao.addBook(book);

        bookDao.beginTransaction();
        bookDao.save(book);
        bookDao.commitTransaction();

        return "confirmBook.xhtml";

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

    public void initBookCategories() {
        BookCategoryDAO categoryDao = factory.getBookCategoryDAO();

        categoryDao.beginTransaction();

        bookCategories = (ArrayList<BookCategory>) categoryDao.findAll(0, 10);

        for (BookCategory b : bookCategories) {
            System.out.println("Bookcategory" + b.getName());
        }
        categoryDao.commitTransaction();

    }
  
   public String displayBookByCategory(Long id) {
        BookCategoryDAO bookCategoryDao = factory.getBookCategoryDAO();
        bookCategoryDao.beginTransaction();
        category = (BookCategory) bookCategoryDao.findByPrimaryKey(id);
        bookCategoryDao.commitTransaction();
        BookDAO bookDao = factory.getBookDAO();
        bookDao.beginTransaction();
        books = (List<Book>) bookDao.findByCriteria(Restrictions.like("bookCategory", category));
           bookDao.commitTransaction();    
        return "displayBookByCategory.xhtml";
    }
    
     public List<BookCategory> fetchBooksCategory() {
       BookCategoryDAO categoryDao = factory.getBookCategoryDAO();

        categoryDao.beginTransaction();

        bookCategories =(ArrayList<BookCategory>) categoryDao.findAll(0, 10);

//        for (BookCategory b : bookCategories) {
//            System.out.println("Bookcategory" + b.getName());
//        }
        categoryDao.commitTransaction();
        return bookCategories;
    }
    
    
    
    public List<Book> fetchBooks() {
        BookDAO bookDao = factory.getBookDAO();

        bookDao.beginTransaction();
        List<Book> books = bookDao.findAll(0, 10);
        bookDao.commitTransaction();
        return books;
    }

    public String[] fetchBookTitles() {
        BookDAO bookDao = factory.getBookDAO();

        bookDao.beginTransaction();
        List<Book> books = bookDao.findAll(0, 10);
        bookDao.commitTransaction();
        String[] bookTitles = new String[books.size()];
        if (books.size() > 0) {
            for (int i = 0; i < books.size(); i++) {
                bookTitles[i] = books.get(i).getTitle();
            }
        }
        return bookTitles;
    }

    public List<Book> getSearchedBooks() {
        return searchedBooks;
    }

    public void setSearchedBooks(List<Book> searchedBooks) {
        this.searchedBooks = searchedBooks;
    }

    public String showBooksByTitle() {
        BookDAO bookDao = factory.getBookDAO();
        bookDao.beginTransaction();
        searchedBooks = bookDao.findByCriteria(Restrictions.like("title", book.getTitle()));
        bookDao.commitTransaction();
        return "searchedBooks";
    }

    public String getBookByID(Long id) {
        BookDAO bookDao = factory.getBookDAO();
        bookDao.beginTransaction();
        book = (Book) bookDao.findByPrimaryKey(id);

        System.out.println("book id isi" + book.getTitle());
        System.out.println("boook id " + book.getId());
        bookDao.commitTransaction();
        return "bookDetail.xhtml";
    }
    
    public void setBookCategoryById(Long catId)
    {
        BookCategoryDAO bookCategoryDao = factory.getBookCategoryDAO();
        bookCategoryDao.beginTransaction();
        category= (BookCategory) bookCategoryDao.findByPrimaryKey(catId);
        book.setBookCategory(category);
       System.out.println("category name is " + category.getName());
        
        bookCategoryDao.commitTransaction();
       
    }
}
