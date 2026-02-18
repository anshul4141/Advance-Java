package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestConnection {

	public static void main(String[] args) throws Exception {

		// step1 load driver class
		Class.forName("com.mysql.cj.jdbc.Driver");

		// step2 make connection to the database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunrays", "root", "root");

		System.out.println("database connection established: " + conn.getCatalog());

		// step3 create Statement
		Statement stmt = conn.createStatement();

		// step4 executeQuery and get ResultSet
		ResultSet rs = stmt.executeQuery("select * from employee");

		while (rs.next()) {
			System.out.print(rs.getInt(1));
			System.out.print("\t" + rs.getString(2));
			System.out.print("\t" + rs.getString(3));
			System.out.println("\t" + rs.getInt(4));
		}

		conn.close();
		stmt.close();

	}

}
