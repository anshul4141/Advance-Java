package com.rays.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SearchUser {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");

		Statement stmt = conn.createStatement();

		// search all recored
		// ResultSet rs = stmt.executeQuery("select * from st_user");

		// search by firstName
		// ResultSet rs = stmt.executeQuery("select * from st_user where firstName like
		// 'a%'");

		// findeBy id
		ResultSet rs = stmt.executeQuery("select * from st_user");
		while (rs.next()) {
			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));

		}

	}

}
