package com.rays.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestInsert {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCAdvance", "root", "root");

		Statement stmt = conn.createStatement();

		int i = stmt.executeUpdate(
				"insert into users values(2, 'Mayank', 'Sahu', 'mayank@gmail.com', 'password', '2001-05-04', 'Bhopal')");

		System.out.println("Data inserted successfully " + i);

	}

}
