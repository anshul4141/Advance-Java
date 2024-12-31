package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestConnection {

	public static void main(String[] args) throws Exception {

		// Step 1 Load Driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Step 2 Make Connection to the database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance", "root", "root");

		// Step 3 Create Statement
		Statement stmt = conn.createStatement();

		// Step 4 ExecuteQuery and get ResultSet
		ResultSet rs = stmt.executeQuery("select * from employee");

		System.out.println("Database Connection Successfully......");

		while (rs.next()) {
			System.out.print(rs.getInt(1));
			System.out.print("\t" + rs.getString(2));
			System.out.print("\t" + rs.getString(3));
			System.out.print("\t" + rs.getString(4));
			System.out.print("\t" + rs.getInt(5));
			System.out.println("\t" + rs.getString(6));
		}

	}

}
