package mum.auction.util;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fetiya
 */


import mum.auction.domain.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;


public class HibernateUtil 
{
	private static SessionFactory factory;
	
	public static Configuration getInitializedConfiguration()
	{
		AnnotationConfiguration config = new AnnotationConfiguration();
		//Bring all annotated class here you want to use.
		config.addAnnotatedClass(Book.class);
		config.addAnnotatedClass(Auction.class);
		config.addAnnotatedClass(Bid.class);
		config.addAnnotatedClass(User.class);
		
		config.configure();
		
		return config;
	}
	
	public static Session getSession()
	{
		if(factory == null)
		{
			Configuration config = HibernateUtil.getInitializedConfiguration();
			factory = config.buildSessionFactory();
		}
		Session hibernateSession = factory.getCurrentSession();
		
		return hibernateSession;
	}
	
	public static void recreateDatabase()
	{
		Configuration config = HibernateUtil.getInitializedConfiguration(); //WE dont need session in creating schema, we need session in persisting
		new SchemaExport(config).create(true, true);
	}
	
	public static Session beginTransaction()
	{
		Session hibernateSession = HibernateUtil.getSession();
		hibernateSession.beginTransaction();
		return hibernateSession;
	}
	
	public static void commitTransaction(){HibernateUtil.getSession().getTransaction().commit();}
	public static void rollbackTransaction(){HibernateUtil.getSession().getTransaction().rollback();}
	public static void closeSession(){HibernateUtil.getSession().close();}
	
	public static void main (String[] Args)
	{
		HibernateUtil.recreateDatabase();
	}
}