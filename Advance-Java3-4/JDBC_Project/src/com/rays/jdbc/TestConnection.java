package com.rays.jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class TestConnection {

	public static void main(String[] args) throws Exception {

		// Load Driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Make Connection to the database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");

		System.out.println("connection established successfully: " + conn.getCatalog());

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("select * from st_user");

		while (rs.next()) {
			System.out.println(rs.getInt("id"));
			System.out.println(rs.getString("firstName"));
			System.out.println(rs.getString("lastName"));
			System.out.println(rs.getString("login"));
			System.out.println(rs.getString("password"));
			System.out.println(rs.getDate("dob"));
			System.out.println("--------------");
		}

	}

}
