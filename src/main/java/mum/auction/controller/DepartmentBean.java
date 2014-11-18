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
import mum.auction.dao.impl.BookCategoryDAOImpl;
import mum.auction.dao.impl.DepartmentDAOImpl;
import mum.auction.dao.intr.AuctionDAO;
import mum.auction.dao.intr.BookCategoryDAO;
import mum.auction.dao.intr.DepartmentDAO;
import mum.auction.domain.Auction;
import mum.auction.domain.BookCategory;
import mum.auction.domain.Department;

/**
 *
 * @author Hiwot
 */

@Named("department")
@SessionScoped
public class DepartmentBean implements Serializable {

    private DepartmentDAO departmentDAO = new DepartmentDAOImpl();
    private Department department= new Department();
    private List<Department> departments = new ArrayList<Department>();

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String addDepartment() {
  //      departmentDAO.addDepartment(department);
        
        return "index";
    }

    public void canceDepartment() {
    //    departmentDAO.removeDepartment(department);
    }

    public List<Department> getDepartments() {
        return departmentDAO.getAllDepartments();
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
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
