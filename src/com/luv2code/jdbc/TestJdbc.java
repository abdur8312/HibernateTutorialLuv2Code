package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
	public static void main(String[] args) {

		// making connection to Postgresql
		String jdbcUrl = "jdbc:postgresql://localhost:5432/hb_student_tracker";
		String user = "hbstudent";
		String pass = "hbstudent";
		
		try {
			System.out.println("connecting to database : " + jdbcUrl);
			Connection con = DriverManager.getConnection(jdbcUrl, user, pass);
			System.out.println("Connection successful!!!");
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		
	}
	
}
