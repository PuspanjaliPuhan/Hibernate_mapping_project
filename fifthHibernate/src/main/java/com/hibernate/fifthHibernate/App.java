package com.hibernate.fifthHibernate;

import java.util.Scanner;

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
        System.out.println("Enter name, email, phone of a student");
        KodnestStudent kodnestStudent = new KodnestStudent(sc.next(), sc.next(), sc.next());
        System.out.println("Enter city, street, state, zipcode of student address.");
        Address address = new Address(sc.next(),sc.next(), sc.next(), sc.next());
        
        kodnestStudent.setAddress(address);
        
        //hibernate steps
        
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        
        Session session = factory.openSession();
        
        Transaction transaction = session.beginTransaction();
        
        session.persist(kodnestStudent);
        
        transaction.commit();
        
        session.close();
        
        factory.close();
        
        sc.close();
        
    }
}
