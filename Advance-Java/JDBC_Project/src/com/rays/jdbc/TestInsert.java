package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestInsert {

	public static void main(String[] args) throws Exception {

		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");

			conn.setAutoCommit(false); // Transaction begin

			Statement stmt = conn.createStatement();

			int i = stmt.executeUpdate(
					"insert into st_user values(7, 'Shyam', 'Yadav', 'shyam@gmail.com', 'shyam123', '2001-02-02'),(8, 'Aman', 'Kumar', 'aman@gmail.com', 'aman123', '2001-02-02')");

			System.out.println("record inserted " + i + " row affected");

			conn.commit(); // Transaction commit
		} catch (Exception e) {
			System.out.println("exception: " + e.getMessage());
			conn.rollback();
		} finally {
			conn.close(); // Transaction end
		}

	}

}
