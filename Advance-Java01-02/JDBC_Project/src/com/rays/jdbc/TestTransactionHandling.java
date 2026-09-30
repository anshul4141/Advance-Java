package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestTransactionHandling {

	public static void main(String[] args) throws Exception {

		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");

			conn.setAutoCommit(false); // begin transaction

			System.out.println("connection established successfully: " + conn.getCatalog());

			Statement stmt = conn.createStatement();

			int i = stmt.executeUpdate(
					"insert into st_user values(16, 'Vinay', 'Prajapati', 'vinay@gmail.com', 'pass123', '2009-02-17')");

			conn.commit(); // saved in database

			System.out.println("record inserted " + i + " row affected");
		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback(); // rolled back from database
		} finally {
			conn.close();
		}

	}

}
