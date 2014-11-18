package mum.auction.dao.impl;

import mum.auction.dao.intr.BidDAO;
import mum.auction.dao.intr.HibernateDAO;

import mum.auction.domain.Bid;

/**
 *
 * @author Fetiya
 */

public class BidDAOImpl extends HibernateDAO<Bid, Long> implements BidDAO
{
	public BidDAOImpl()
	{
		super(Bid.class);
	}
}