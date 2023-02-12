package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.Entity.Student;

public class QueryStudentDemo {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// start a transaction
			session.beginTransaction();
			
			// query students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			// display the students
			displayStudents(theStudents);
			
			// query students : lastName = "shafiq"
			theStudents = session.createQuery("from Student s where s.lastName = 'Faaid'").getResultList();
			
			System.out.println("\n\nDisplay the students who have lastname of Faaid");
			displayStudents(theStudents);
			
			// query students : lastName = 'jassim' OR firstName = 'Mohamed'
			theStudents = session.createQuery("from Student s where s.lastName = 'jassim' OR s.firstName = 'Mohamed'").getResultList();
			System.out.println("\n\nDisplay the students who have lastname of jassim OR firstName of Mohamed");
			displayStudents(theStudents);
			
			// query students where email LIKE '%memob.com'
			theStudents = session.createQuery("from Student s where s.email LIKE '%memob.com'").getResultList();
			System.out.println("\n\nDisplay the students who have email LIKE memob.com");
			displayStudents(theStudents);
			
			
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		}
		finally {
			factory.close();
		}
		
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student temp : theStudents) {
			System.out.println(temp);
		}
	}

}
