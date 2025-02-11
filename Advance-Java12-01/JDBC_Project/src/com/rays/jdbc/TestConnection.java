package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestConnection {

	public static void main(String[] args) throws Exception {

		// step 1 load driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		// step 2 make connection to the database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejava", "root", "root");

		// step 3 create statement
		Statement stmt = conn.createStatement();

		System.out.println("connection successfully ===>");

		// step 4 executeQuery and get resultset
		ResultSet rs = stmt.executeQuery("select * from employee");

		while (rs.next()) {
			System.out.print(rs.getInt(1));
			System.out.print("\t " + rs.getString(2));
			System.out.print("\t " + rs.getString(3));
			System.out.println("\t " + rs.getInt(4));
		}

	}

}
