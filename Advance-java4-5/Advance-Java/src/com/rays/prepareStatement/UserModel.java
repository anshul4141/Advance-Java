package com.rays.prepareStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UserModel {

	public void add(UserBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myproject", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("insert into user values(?,?,?,?,?,?,?,?,?)");

		pstmt.setInt(1, bean.getId());
		pstmt.setString(2, bean.getFirstName());
		pstmt.setString(3, bean.getLastName());
		pstmt.setString(4, bean.getLoginId());
		pstmt.setString(5, bean.getPassword());
		pstmt.setDate(6, new java.sql.Date(bean.getDob().getTime()));
		pstmt.setString(7, bean.getPhoneNo());
		pstmt.setString(8, bean.getAddress());
		pstmt.setString(9, bean.getGender());

		int i = pstmt.executeUpdate();

		System.out.println("data inserted successfully.. " + i);

	}

}
