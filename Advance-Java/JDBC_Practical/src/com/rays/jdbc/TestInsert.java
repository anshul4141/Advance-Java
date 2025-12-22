package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestInsert {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		Statement stmt = conn.createStatement();

		int i = stmt.executeUpdate(
				"insert into st_user values(3, 'Akbar', 'Khan', 'akbar@gmail.com', 'akbar123', '2002-02-02'),(4, 'Akbar', 'Khan', 'akbar@gmail.com', 'akbar123', '2002-02-02')");

		System.out.println(i + " row affected..(records inserted)");

		conn.close();

	}

}
