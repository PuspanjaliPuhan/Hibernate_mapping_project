package com.kodnest.hibernate.fourthHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.*;


/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	//step 1 & 2
    	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    	
    	//step 3
    	Session session = factory.openSession();
    	
//    	step 4
    	Transaction transaction = session.beginTransaction();
    	
    	//step 5
    	System.out.println("Enter id of a student to update name and email update");
    	int id = sc.nextInt();
    	Student obj = session.get(Student.class, id);
    	if(obj != null) {
    		System.out.println("Enter new name and new email");	
    		String name = sc.next();
    		String email = sc.next();
    		obj.setName(name);
    		obj.setEmail(email);
    		session.persist(obj);
    		System.out.println("Updated Succesfully..");
    		
    	}
    	else {
    		System.out.println("Student with id " + id + " not found to update");
    	}
    	
    	
    	//step 6
    	transaction.commit();
    	
    	//step 7
    	session.close();
    	factory.close();
    }
}
