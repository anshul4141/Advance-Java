package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestUpdate {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		Statement stmt = conn.createStatement();

		int i = stmt.executeUpdate(
				"update st_user set firstName = 'Birbal', lastName = 'Shekhawat', login = 'birbal@gmail.com', password = 'birbal123' where id = 3");

		System.out.println(i + " row affected..(records updated)");

		conn.close();

	}

}
