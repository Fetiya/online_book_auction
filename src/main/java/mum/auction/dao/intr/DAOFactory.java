package mum.auction.dao.intr;

/**
 *
 * @author Fetiya
 */

public abstract class DAOFactory
{
	public static final Class FACTORY_CLASS = mum.auction.dao.intr.HibernateDAOFactory.class;
	
		
	public static DAOFactory getFactory()
	{
		try
		{
			return (DAOFactory)FACTORY_CLASS.newInstance();
		}
		catch(Exception e)
		{
			throw new RuntimeException("Couldn't create factory");
		}
	}
	
	public abstract BookDAO getBookDAO();
	public abstract AuctionDAO getAuctionDAO();
	public abstract BidDAO getBidDAO();
	public abstract UserDAO getUserDAO();
        public abstract DepartmentDAO getDepartmentDAO();
	public abstract BookCategoryDAO getBookCategoryDAO();
	
	
}