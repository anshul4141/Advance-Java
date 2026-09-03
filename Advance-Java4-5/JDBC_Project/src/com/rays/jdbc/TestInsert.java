package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestInsert {

	public static void main(String[] args) throws Exception {

		Connection conn = null;

		try {

			// Step 1. load Driver class
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Step 2. make connection to the database
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");

			conn.setAutoCommit(false);

			System.out.println("connection established successfully: " + conn.getCatalog());

			// Step 3. create statement
			Statement stmt = conn.createStatement();

			int i = stmt.executeUpdate(
					"insert into st_user values(16, 'Vinay', 'Prajapati', 'vinay@gmail.com', 'pass123', '2009-02-17')");

			conn.commit();

			System.out.println("record inserted " + i + " row affected");

		} catch (SQLException e) {
			conn.rollback();
		} finally {
			conn.close();
		}

	}

}
