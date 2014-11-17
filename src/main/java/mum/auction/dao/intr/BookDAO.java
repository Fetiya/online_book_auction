/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.auction.dao.intr;

import java.util.List;
import mum.auction.domain.Book;

/**
 *
 * @author Komal
 */
public interface BookDAO {
       
     public void addBook(Book book);
     
     public void updateBook(Book book);
     
     public Book getBookId(int id);
     
     public List<Book> getAllBooks();
     
     public void removeBook(Book book);    
}
