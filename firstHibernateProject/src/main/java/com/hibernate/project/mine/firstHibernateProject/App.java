package com.hibernate.project.mine.firstHibernateProject;
import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        System.out.println("Enter Student name, marks, email");
        Student s1 = new Student(sc.next(), sc.nextInt(), sc.next());
        
        // Hibernate 7 steps
         
        //Step 1-> 
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        
        Session session = sessionFactory.openSession();
        
        Transaction transaction = session.beginTransaction();
        
        session.persist(s1);
        
        transaction.commit();
        session.close();
        sessionFactory.close();
        
        
        
    }
}
