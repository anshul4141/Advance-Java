package com.rays.preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class AddUser {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("insert into st_user values(?,?,?,?,?,?,?)");

		int nextpk = UserNextPk.nextPk();

		System.out.println("next pk: " + nextpk);

		pstmt.setInt(1, nextpk);
		pstmt.setString(2, "Rupali");
		pstmt.setString(3, "Sharma");
		pstmt.setString(4, "rupali@gmail.com");
		pstmt.setString(5, "rupali123");
		pstmt.setString(6, "Pune");
		pstmt.setDate(7, new java.sql.Date(2003, 02, 04));

		int i = pstmt.executeUpdate();

		System.out.println("data added successfully: " + i);

	}

}
