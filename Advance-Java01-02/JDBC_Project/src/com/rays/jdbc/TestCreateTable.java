package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestCreateTable {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		// step2 make connection to the database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunrays", "root", "root");

		System.out.println("database connection established: " + conn.getCatalog());

		// step3 create Statement
		Statement stmt = conn.createStatement();

		stmt.executeUpdate(
				"create table st_user(id int primary key, firstName varchar(45), lastName varchar(45), login varchar(45), password varchar(45), dob date)");

		System.out.println("table created successfully");

	}

}
