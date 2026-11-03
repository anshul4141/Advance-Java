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

			conn.setAutoCommit(false);

			Statement stmt = conn.createStatement();

			int i = stmt.executeUpdate(
					"insert into st_user values(7, 'Naved', 'Ahmed', 'naved@gmail.com', 'naved123', '2005-11-27')");
			i = stmt.executeUpdate(
					"insert into st_user values(8, 'Ankit', 'Rawat', 'ankit@gmail.com', 'ankit', '2005-11-27')");
			i = stmt.executeUpdate(
					"insert into st_user values(8, 'Vedant', 'Vishput', 'vdant@gmail.com', 'vadant', '2005-11-27')");

			conn.commit();

			System.out.println("record inserted " + (i + i + i) + " row affected");

		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		} finally {
			conn.close();
		}

	}

}
