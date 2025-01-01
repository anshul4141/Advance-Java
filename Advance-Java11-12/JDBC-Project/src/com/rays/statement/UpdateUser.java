package com.rays.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateUser {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");

		Statement stmt = conn.createStatement();

		int i = stmt.executeUpdate(
				"update st_user set firstName = 'Raman', lastName = 'Yadav', loginId = 'rahu@gmail.com', password = 'raju123', address = 'Bhopal', dob = '2003-02-02' where id = 1");

		System.out.println("Uaser updated successfully.. " + i);
	}

}
