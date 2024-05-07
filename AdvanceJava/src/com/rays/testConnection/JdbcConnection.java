package com.rays.testConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcConnection {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "root");

		System.out.println("connection successfully...");
	}

}
