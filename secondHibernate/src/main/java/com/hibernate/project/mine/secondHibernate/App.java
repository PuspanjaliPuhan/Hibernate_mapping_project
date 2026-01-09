package com.hibernate.project.mine.secondHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        
        Session session = sessionFactory.openSession();
        
        Transaction transaction = session.beginTransaction();
        
        Student ref = session.get(Student.class, 1);
        System.out.println(ref);
        transaction.commit();
        session.close();
        sessionFactory.close();
        
    }
}
