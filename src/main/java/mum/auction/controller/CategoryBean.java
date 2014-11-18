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
import mum.auction.dao.impl.AuctionDAOImpl;
import mum.auction.dao.impl.CategoryDAOImpl;
import mum.auction.dao.intr.AuctionDAO;
import mum.auction.dao.intr.CategoryDAO;
import mum.auction.domain.Auction;
import mum.auction.domain.Category;

/**
 *
 * @author Hiwot
 */

@Named("category")
@SessionScoped
public class CategoryBean implements Serializable {

    private CategoryDAO categoryDAO = new CategoryDAOImpl();
    private Category category= new Category();

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String addCategory() {
        categoryDAO.addCategory(category);
        
        return "index";
    }

    public void cancelCategory() {
        categoryDAO.removeCategory(category);
    }

    public List<String> completeTitle() {
        String query = null;
        List<String> results = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            results.add(query + i);
        }

        return results;

    }
}
