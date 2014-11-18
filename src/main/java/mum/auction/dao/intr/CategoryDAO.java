/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.auction.dao.intr;

import java.util.List;
import mum.auction.domain.Auction;
import mum.auction.domain.Category;

/**
 *
 * @author hiwot
 */
public interface CategoryDAO {

    public void addCategory(Category category);

    public void updateCategory(Category category);

    public Category getCategory(int id);

    public List<Category> getAllCategories();

    public void removeCategory(Category category);
}
