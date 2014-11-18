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
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;
import mum.auction.domain.Department;
import mum.auction.domain.User;

/**
 *
 * @author Fetiya
 */

@Named("user")
@SessionScoped
public class UserBean  implements Serializable{
    
    private User user;
    private String firstName;
    private String lastName;
    private String studentId;
    private Department department;
    private String email;
    private String userName;
    private String password;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
    
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
        return "home";
    }

    public String logout() {
        loggedIn = false;
        return "index";
    }

    public void checkLogin(ComponentSystemEvent event) {

        if (!loggedIn) {

            FacesContext context = FacesContext.getCurrentInstance();

            ConfigurableNavigationHandler handler = (ConfigurableNavigationHandler) context.getApplication().getNavigationHandler();

            handler.performNavigation("login");

        }
    }
     public String signUp(){
        
     //   users.add(new User(firstName,lastName,studentId,department,email,userName,password));
        return "home";
        
    }
    public void validateFirstName(FacesContext fc, UIComponent c, Object value) {
	   if (((String) value).equals(""))
	      throw new ValidatorException(
	         new FacesMessage("First name is required"));
   }
    public void validateLastName(FacesContext fc, UIComponent c, Object value) {
	   if (((String) value).equals(""))
	      throw new ValidatorException(
	         new FacesMessage("Last name is required"));
   }
    public void validateStudentId(FacesContext fc, UIComponent c, Object value) {
	   if (((String) value).equals(""))
	      throw new ValidatorException(
	         new FacesMessage("Student ID is required"));
   }
    public void validateEmail(FacesContext fc, UIComponent c, Object value) {
//	   if (!((String) value).matches("@\"^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@\"\n" +
//"     + @\"((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?\n" +
//"				[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.\"\n" +
//"     + @\"([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?\n" +
//"				[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|\"\n" +
//"     + @\"([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$\"")){
//	      throw new ValidatorException(
//	         new FacesMessage("Enter a valid email"));
//           }
   }
    public void validateUserName(FacesContext fc, UIComponent c, Object value) {
	   if (((String) value).equals(""))
	      throw new ValidatorException(
	         new FacesMessage("User name is required"));
   }
            
}
