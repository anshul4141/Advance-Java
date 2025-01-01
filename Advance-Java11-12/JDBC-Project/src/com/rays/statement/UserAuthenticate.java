package com.rays.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserAuthenticate {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt
				.executeQuery("select * from st_user where loginId = 'rahu@gmail.com' and password = 'raju1ghghy23'");

		boolean b = false;

		while (rs.next()) {

			b = true;

			System.out.println(rs.getString(2) + " " + rs.getString(3));

		}

		if (!b) {
			System.out.println("invalid loginId or Password");
		}
	}
}
