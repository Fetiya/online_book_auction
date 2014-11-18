/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.auction.dao.impl;

import java.util.List;
import mum.auction.dao.intr.AuctionDAO;
import mum.auction.dao.intr.DepartmentDAO;
import mum.auction.dao.intr.HibernateDAO;
import mum.auction.domain.Auction;
import mum.auction.domain.Department;

/**
 *
 * @author hiwot
 */
public class DepartmentDAOImpl extends HibernateDAO<Department, Long> implements DepartmentDAO
{
	public DepartmentDAOImpl()
	{
		super(Department.class);
	}
}
