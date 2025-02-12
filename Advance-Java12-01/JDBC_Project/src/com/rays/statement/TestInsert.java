package com.rays.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestInsert {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejava", "root", "root");

		Statement stmt = conn.createStatement();

		int i = stmt.executeUpdate("insert into employee values(6, 'Nandani', 'TCS', 65000, 2)");

		System.out.println("data inserted successfully: " + i);

	}

}
