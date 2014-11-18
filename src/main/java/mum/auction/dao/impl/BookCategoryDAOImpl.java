/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.auction.dao.impl;

import java.util.List;
import mum.auction.dao.intr.BookCategoryDAO;
import mum.auction.dao.intr.DepartmentDAO;
import mum.auction.dao.intr.HibernateDAO;
import mum.auction.domain.BookCategory;


/**
 *
 * @author hiwot
 */

public class BookCategoryDAOImpl extends HibernateDAO<BookCategory, Long> implements BookCategoryDAO
{
	public BookCategoryDAOImpl()
	{
		super(BookCategory.class);
	}
}