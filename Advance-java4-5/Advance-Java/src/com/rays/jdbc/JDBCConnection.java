package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCConnection {

	public static void main(String[] args) throws Exception {

		// step 1 load driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		// step 2 create connection
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejava", "root", "root");

		// step 3 create obj of statement
		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("select * from emp");

		while (rs.next()) {

			System.out.print(rs.getInt(1));
			System.out.print("\t" + rs.getString(2));
			System.out.print("\t" + rs.getString(3));
			System.out.print("\t" + rs.getInt(4));
			System.out.print("\t" + rs.getString(5));
			System.out.println("\t" + rs.getString(6));

		}
	}

}
