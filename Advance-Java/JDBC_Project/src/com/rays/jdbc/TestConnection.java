package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

// create table st_user(id int primary key, firstName varchar(45), lastName varchar(45), loginId varchar(45), password varchar(45), dob date)

public class TestConnection {

	public static void main(String[] args) throws Exception {

		// step 1. Load Driver Class into the class loader
		Class.forName("com.mysql.cj.jdbc.Driver");

		// step 2. Make Connection to the database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");

		System.out.println("connection established successfully.... " + conn.getCatalog());

		// step 3. create Statement and get ResultSet or insert, update and delete
		// records
		Statement stmt = conn.createStatement();

		// step 4 get records
		ResultSet rs = stmt.executeQuery("select * from st_user");

		while (rs.next()) {
			System.out.println(rs.getInt("id"));
			System.out.println(rs.getString("firstName"));
			System.out.println(rs.getString("lastName"));
			System.out.println(rs.getString("loginId"));
			System.out.println(rs.getString("password"));
			System.out.println(rs.getDate("dob"));
			System.out.println("--------------");
		}

	}

}
