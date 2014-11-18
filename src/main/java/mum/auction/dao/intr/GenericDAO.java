package mum.auction.dao.intr;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Fetiya
 */

interface GenericDAO < T, ID extends Serializable>
{
	//define all the abstract methods that our project needs for persistence
	
	T findByPrimaryKey( ID id);
	
	List<T> findAll(int startIndex, int fetchSize);
	
	List<T> findByExample( T exampleInstance, String[] excludeProperty);
	
	T save( T entity);
	
	void delete( T entity);
	
	void beginTransaction();
	void commitTransaction();
}