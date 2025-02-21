package com.rays.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestTransaction {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejava", "root", "root");

		// step 1
		conn.setAutoCommit(false);

		Statement stmt = conn.createStatement();

		try {

			int i = stmt.executeUpdate("insert into employee values(6, 'Aniket', 'NCS', 4500, 1)");

			i = stmt.executeUpdate("insert into employee values(6, 'Aniket', 'NCS', 4500, 1)");

			i = stmt.executeUpdate("insert into employee values(7, 'Aniket', 'NCS', 4500, 1)");

			System.out.println("data inserted = " + i + i + i);

			conn.commit();

		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

}
