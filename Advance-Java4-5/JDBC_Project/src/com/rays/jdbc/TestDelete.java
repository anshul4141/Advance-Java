package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestDelete {

	public static void main(String[] args) throws Exception {

		// Step 1. load Driver class
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Step 2. make connection to the database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");

		System.out.println("connection established successfully: " + conn.getCatalog());

		// Step 3. create statement
		Statement stmt = conn.createStatement();

		int i = stmt.executeUpdate("delete from st_user where id = 15");

		System.out.println("record deleted " + i + " row affected");

	}

}
