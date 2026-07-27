package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestDelete {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");

		Statement stmt = conn.createStatement();

		int i = stmt.executeUpdate("delete from st_user where id = 8");

		System.out.println("record deleted " + i + " row affected");

	}

}
