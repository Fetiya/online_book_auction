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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author hiwot
 */

@Entity
public class BookCategory {
  
    @Id
    @GeneratedValue
    private Long id;
    
    
    private String name;
    
    @OneToMany(mappedBy = "bookCategory",  cascade = CascadeType.ALL)
    private List<Book> books;// = new ArrayList<Book>();

    public BookCategory(Long id, String nam) {
        this.id = id;
        this.name = name;
    }

    public BookCategory() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   
   
   
   

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BookCategory(String name, List<Book> books) {
        this.name = name;
        this.books = books;
    }

   
    
    
}
