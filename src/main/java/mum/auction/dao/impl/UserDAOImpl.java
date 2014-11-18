package mum.auction.dao.impl;

import mum.auction.dao.intr.HibernateDAO;
import mum.auction.dao.intr.UserDAO;

import mum.auction.domain.User;

/**
 *
 * @author Fetiya
 */

public class UserDAOImpl extends HibernateDAO<User, Long> implements UserDAO
{
	public UserDAOImpl()
	{
		super(User.class);
	}
}