package mum.auction.dao.impl;

import mum.auction.dao.intr.BookDAO;
import mum.auction.dao.intr.HibernateDAO;
import mum.auction.domain.Book;

/**
 *
 * @author Fetiya
 */

public class BookDAOImpl extends HibernateDAO<Book, Long> implements BookDAO
{
	public BookDAOImpl()
	{
		super(Book.class);
	}
}