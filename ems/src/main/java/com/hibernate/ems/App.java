package com.hibernate.ems;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 */
public class App {
	static SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("WELCOME TO EMPLOYEE MANAGEMENT SYSTEM.");
		
		while(true) {
			
			System.out.println("PRESS1 -> AddEmployee.");
			System.out.println("PRESS2 -> GetEmployee.");
			System.out.println("PRESS3 -> DeleteEmployee.");
			System.out.println("PRESS4 -> UpdateEmployee.");
			System.out.println("PRESS other -> Exit.");
			int ch = sc.nextInt();
		
			switch(ch) {
				case 1: addEmployee();
				break;
				
				case 2: getEmployee();
				break;
				
				case 3: deleteEmployee();
				break;
				
				case 4: updateEmployee();
				break;
				
				default: System.out.println("THANKS FOR USING EMPLOYEE MANAGEMENT SYSTEM");
				factory.close();
				sc.close();
				return;
			}
		}
    }
    
    public static void addEmployee() {
    	Session session = factory.openSession();
    	Transaction transaction = session.beginTransaction();
    	System.out.println("Enter employee name, salary, email");
    	Employee emp = new Employee(sc.next(), sc.nextInt(), sc.next());
    	session.persist(emp);
    	transaction.commit();
    	session.close();
    	
    }
    public static void getEmployee() {
    	Session session = factory.openSession();
    	Transaction transaction = session.beginTransaction();
    	System.out.println("Enter employee id");
    	int id = sc.nextInt();
    	Employee obj = session.get(Employee.class, id);
    	if(obj != null) {
    		System.out.println(obj);
    		
    	}
    	else {
    		System.out.println("Employee with id:" + id + "Doesn't exist please try again");
    	}
    	transaction.commit();
    	session.close();
    	
    }
    public static void deleteEmployee() {
    	Session session = factory.openSession();
    	Transaction transaction = session.beginTransaction();
    	System.out.println("Enter employee id");
    	int id = sc.nextInt();
    	Employee obj = session.get(Employee.class, id);
    	if(obj != null) {
    		session.remove(obj);
    		System.out.println("Employee with id:" + id + "Deleted succesfully");
    		
    	}
    	else {
    		System.out.println("Employee with id:" + id + "Doesn't exist please try again");
    	}
    	transaction.commit();
    	session.close();
    }
    public static void updateEmployee() {
    	Session session = factory.openSession();
    	Transaction transaction = session.beginTransaction();
    	System.out.println("Enter employee id");
    	int id = sc.nextInt();
    	Employee obj = session.get(Employee.class, id);
    	if(obj != null) {
    		System.out.println("Enter new name, salary and email");
    		obj.setName(sc.next());
    		obj.setSalary(sc.nextInt());
    		obj.setEmail(sc.next());
    		session.persist(obj);
    		System.out.println("Employee updated successfully");
    		
    		
    	}
    	else {
    		System.out.println("Employee with id:" + id + "Doesn't exist please try again");
    	}
    	transaction.commit();
    	session.close();
    }
    
}
