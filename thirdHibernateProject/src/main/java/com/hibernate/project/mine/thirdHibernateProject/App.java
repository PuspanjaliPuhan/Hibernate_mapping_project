package com.hibernate.project.mine.thirdHibernateProject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        //Hibernate steps
    	
    	//step 1 & 2
    	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    	
    	//step 3
    	Session session = factory.openSession();
    	
//    	step 4
    	Transaction transaction = session.beginTransaction();
    	
    	//step 5
    	// check whether data is present in db or not, if present then delete
    	Student obj = session.get(Student.class, 1);
    	if(obj!= null) {
    		session.remove(obj);
    		System.out.println("Student deleted succesfully.");
    	}
    	else {
    		System.out.println("Student doesn't exists.");
    		
    	}
    	
    	//step 6
    	transaction.commit();
    	
    	//step 7
    	session.close();
    	factory.close();
    	}
}
