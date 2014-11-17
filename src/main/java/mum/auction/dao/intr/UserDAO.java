/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mum.auction.dao.intr;

import java.util.List;
import mum.auction.domain.User;

/**
 *
 * @author Fetiya
 */
public interface UserDAO {
    
    public void addUser(User user);
     
    public void updateUser(User user);
     
    public User getUser(int id);
     
    public List<User> getAllUsers();
     
    public void removeUser(User user);
}
