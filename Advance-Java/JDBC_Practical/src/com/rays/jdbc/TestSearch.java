package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestSearch {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		System.out.println("java is connected with mysql successfully....");

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("select * from st_user");

		// Header
		System.out.println("------------------------------------------------------------------------------------");
		System.out.printf("| %-3s | %-10s | %-10s | %-20s | %-12s | %-10s |%n", "ID", "FirstName", "LastName", "Email",
				"Password", "DOB");
		System.out.println("------------------------------------------------------------------------------------");

		// Data
		while (rs.next()) {
			System.out.printf("| %-3d | %-10s | %-10s | %-20s | %-12s | %-10s |%n", rs.getInt(1), rs.getString(2),
					rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6));
		}

		// Footer line
		System.out.println("------------------------------------------------------------------------------------");

		conn.close();

	}

}
