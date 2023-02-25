package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.Entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			int studentId = 1;
			

			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on the id : primary key
			System.out.println("\n Getting student with id : " + studentId);
			
			Student myStudent = session.get(Student.class, studentId);
			
			System.out.println("Updating students : ");
			myStudent.setFirstName("Abdul");
			
			// commit the transaction
			session.getTransaction().commit();
			
			// NEW CODE
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// update email for all students
			System.out.println("Update email for all students");
			
			//session.createQuery("update Student s set email = 'shafiq@gmail.com' where s.id = 2").executeUpdate();
			session.createQuery("UPDATE Student SET email = 'mdshafiq@gmail.com' WHERE id = 2").executeUpdate();
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}
		finally {
			factory.close();
		}
		
	}

}
