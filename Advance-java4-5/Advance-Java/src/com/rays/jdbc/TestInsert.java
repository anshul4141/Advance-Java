package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestInsert {

	public static void main(String[] args) throws Exception {

		// step 1 load driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		// step 2 create connection
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejava", "root", "root");

		// step 3 create obj of statement
		Statement stmt = conn.createStatement();

		int i = stmt.executeUpdate("insert into emp values(8, 'Anish', 'Malwiya', 75000, 'Ujjain', 'Norm')");

		System.out.println("data inserted successfully.. " + i);
	}

}
