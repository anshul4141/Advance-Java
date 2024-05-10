package com.rays.preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestCRUD {

	public static void main(String[] args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Date d = (Date) sdf.parse("2001-05-08");

		add(3, "Rahul", "Gour", "rahul@gmail.com", "pass@123", d, "Bhopal");

	}

	private static Connection getConnection() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCAdvance", "root", "root");

		return conn;

	}

	private static void add(int id, String fname, String lname, String email, String pwd, Date dob, String address)
			throws Exception {

		Connection conn = getConnection();

		PreparedStatement pstmt = conn.prepareStatement("insert into users values(?, ?, ?, ?, ?, ?, ?)");

		pstmt.setInt(1, id);
		pstmt.setString(2, fname);
		pstmt.setString(3, lname);
		pstmt.setString(4, email);
		pstmt.setString(5, pwd);
		pstmt.setDate(6, new java.sql.Date(dob.getTime()));
		pstmt.setString(7, address);

		int i = pstmt.executeUpdate();

		System.out.println("data inserted successfully " + i);

	}

}
