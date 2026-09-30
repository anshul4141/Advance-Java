package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestConnection {

	public static void main(String[] args) throws Exception {

		// Step 1. load Driver class
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Step 2. make connection to the database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");

		System.out.println("connection established successfully: " + conn.getCatalog());

		// Step 3. create statement
		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("select * from st_user");

		while (rs.next()) {
			System.out.println(rs.getInt("id"));
			System.out.println(rs.getString("firstName"));
			System.out.println(rs.getString("lastName"));
			System.out.println(rs.getString("loginId"));
			System.out.println(rs.getString("password"));
			System.out.println(rs.getDate("dob"));
			System.out.println("-------------");
		}

	}

}
