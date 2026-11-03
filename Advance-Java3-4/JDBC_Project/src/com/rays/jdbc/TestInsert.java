package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestInsert {

	public static void main(String[] args) throws Exception {

		// Load Driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Make Connection to the database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");

		System.out.println("connection established successfully: " + conn.getCatalog());

		Statement stmt = conn.createStatement();

		int i = stmt.executeUpdate(
				"insert into st_user values(4, 'Naved', 'Ahmed', 'naved@gmail.com', 'naved123', '2005-11-27')");

		System.out.println("record inserted " + i + " row affected");

	}

}
