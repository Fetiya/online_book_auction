/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mum.auction.dao.impl;

import java.util.Date;
import mum.auction.domain.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 *
 * @author Fetiya
 */
public class BookTest {
    
    public static void main(String[] Args)
    {
      
        
        Configuration config = new Configuration();
        
        config.addAnnotatedClass(Auction.class);
      
        config.addAnnotatedClass(Book.class);
        config.addAnnotatedClass(Bid.class);
        config.addAnnotatedClass(User.class);
         config.addAnnotatedClass(BookCategory.class);
            config.addAnnotatedClass(Department.class);
        config.configure();
       new SchemaExport(config).create(true, true);
        
        
//        SessionFactory factory = config.buildSessionFactory();
//        Session session = factory.getCurrentSession();
//        
//        session.beginTransaction();
//        
//          Book bk = new Book();
//        bk.setTitle("Hibernate made easy");
//        bk.setDescription("A vert good book for beginners");
//        
//        Auction au= new Auction();
//        
//        au.setBook(bk);
//        au.setEndDate(new Date());
//       
//        
//        session.save(bk);
//        session.save(au);
//        
//        session.getTransaction().commit();
    }
    
}
