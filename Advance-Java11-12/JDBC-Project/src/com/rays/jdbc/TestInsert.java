package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestInsert {

	public static void main(String[] args) throws Exception {

		// Step 1 Load Driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Step 2 Make Connection to the database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance", "root", "root");

		// Step 3 Create Statement
		Statement stmt = conn.createStatement();

		int i = stmt.executeUpdate("insert into employee values(21, 'Raman', 'Yadav', 'TCS', 65000, 'Ujjain', 2)");

		System.out.println("data inserted successfully: " + i);
	}

}
