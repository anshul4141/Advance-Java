package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestTransactionHandling {

	public static void main(String[] args) throws SQLException {

		Connection conn = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");

			conn.setAutoCommit(false); // transaction begin

			Statement stmt = conn.createStatement();

			int i = stmt.executeUpdate(
					"insert into st_user values(8, 'xyz', 'xyz', 'xyz@gmial.com', 'xyz123', '2001-02-02')");
			i = stmt.executeUpdate(
					"insert into st_user values(8, 'xyz', 'xyz', 'xyz@gmial.com', 'xyz123', '2001-02-02')");
			i = stmt.executeUpdate(
					"insert into st_user values(9, 'xyz', 'xyz', 'xyz@gmial.com', 'xyz123', '2001-02-02')");

			conn.commit(); // transaction commit

		} catch (Exception e) {
			System.out.println("exeption: " + e.getMessage());
			conn.rollback(); // transaction roll-back

		} finally {
			conn.close(); // transaction end
		}

	}

}
