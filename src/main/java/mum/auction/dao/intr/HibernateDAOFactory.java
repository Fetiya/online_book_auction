package mum.auction.dao.intr;

import mum.auction.dao.intr.DAOFactory;
import mum.auction.dao.intr.BookDAO;
import mum.auction.dao.impl.*;

/**
 *
 * @author Fetiya
 */

public class HibernateDAOFactory extends DAOFactory
{
         
	public BookDAO getBookDAO() { return new BookDAOImpl(); }
	public BidDAO getBidDAO() { return new BidDAOImpl(); }
	public UserDAO getUserDAO() { return new UserDAOImpl(); }
	public AuctionDAO getAuctionDAO() { return new AuctionDAOImpl(); }
}