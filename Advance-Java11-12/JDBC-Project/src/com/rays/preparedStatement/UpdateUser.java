package com.rays.preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateUser {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement(
				"update st_user set firstName = ?, lastName = ?, loginId = ?, password = ?, address = ?, dob = ? where id = ?");

		pstmt.setString(1, "Rupali");
		pstmt.setString(2, "Sharma");
		pstmt.setString(3, "rupali@gmail.com");
		pstmt.setString(4, "rupali123");
		pstmt.setString(5, "Pune");
		pstmt.setDate(6, new java.sql.Date(2003, 02, 04));
		pstmt.setInt(7, 30);

		int i = pstmt.executeUpdate();

		if (i == 0) {

			System.out.println("record not found ");

		} else {

			System.out.println("data updated successfully: " + i);

		}

	}

}
