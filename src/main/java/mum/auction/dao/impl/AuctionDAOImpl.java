package mum.auction.dao.impl;

import mum.auction.dao.intr.AuctionDAO;
import mum.auction.dao.intr.HibernateDAO;
import mum.auction.domain.Auction;

/**
 *
 * @author Fetiya
 */
public class AuctionDAOImpl extends HibernateDAO<Auction, Long> implements AuctionDAO
{
	public AuctionDAOImpl()
	{
		super(Auction.class);
	}
}