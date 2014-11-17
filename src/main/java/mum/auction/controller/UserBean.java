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
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Named;
import mum.auction.domain.User;

/**
 *
 * @author Fetiya
 */

@Named("user")
@SessionScoped
public class UserBean  implements Serializable{
    
    private User user;
    
    private List<User> users= new ArrayList();

    private boolean loggedIn ;
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    
 public String login() {
        loggedIn = true;
        return "planetarium";
    }

    public String logout() {
        loggedIn = false;
        return "login";
    }

    public void checkLogin(ComponentSystemEvent event) {

        if (!loggedIn) {

            FacesContext context = FacesContext.getCurrentInstance();

            ConfigurableNavigationHandler handler = (ConfigurableNavigationHandler) context.getApplication().getNavigationHandler();

            handler.performNavigation("login");

        }
    }
            
}
