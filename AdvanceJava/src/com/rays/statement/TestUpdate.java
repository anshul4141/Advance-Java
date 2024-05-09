package com.rays.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestUpdate {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCAdvance", "root", "root");

		Statement stmt = conn.createStatement();

		int i = stmt.executeUpdate("update users set password = 'pass@123' where id = 2");

		System.out.println("Data updated successfully " + i);

	}

}
