/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.auction.dao.intr;

import java.util.List;
import mum.auction.domain.Category;
import mum.auction.domain.Department;

/**
 *
 * @author hiwot
 */
public interface DepartmentDAO {

    public void addDepartment(Department department);

    public void updateDepartment(Department department);

    public Department getDepartment(int id);

    public List<Department> getAllDepartments();

    public void removeDepartment(Department department);
}
