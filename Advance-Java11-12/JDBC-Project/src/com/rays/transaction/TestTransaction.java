package com.rays.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestTransaction {

	public static void main(String[] args) throws Exception {

		Connection conn = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/result", "root", "root");

			// step 1
			conn.setAutoCommit(false);

			Statement stmt = conn.createStatement();

			int i = stmt.executeUpdate("insert into marksheet values(24, 124, 'Ram', 52, 65, 45)");

			i = stmt.executeUpdate("insert into marksheet values(25, 125, 'Ram', 52, 65, 45)");

			i = stmt.executeUpdate("insert into marksheet values(26, 126, 'Ram', 52, 65, 45)");

			System.out.println("data inserted successfully: " + (i + i + i));

			conn.commit();

		} catch (SQLException e) {
			conn.rollback();
			e.printStackTrace();
		}

	}

}
