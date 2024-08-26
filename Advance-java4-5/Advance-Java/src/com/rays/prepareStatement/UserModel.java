package com.rays.prepareStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

	public void delete(UserBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myproject", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("delete from user where id = ?");

		pstmt.setInt(1, bean.getId());

		int i = pstmt.executeUpdate();

		System.out.println("data deleted successfully.. " + i);

	}

	public void update(UserBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myproject", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement(
				"update user set firstName = ?, lastName = ?, loginId = ?, password = ?, dob = ?, phoneNo = ?, address = ?, gender = ? where id = ?");

		pstmt.setString(1, bean.getFirstName());
		pstmt.setString(2, bean.getLastName());
		pstmt.setString(3, bean.getLoginId());
		pstmt.setString(4, bean.getPassword());
		pstmt.setDate(5, new java.sql.Date(bean.getDob().getTime()));
		pstmt.setString(6, bean.getPhoneNo());
		pstmt.setString(7, bean.getAddress());
		pstmt.setString(8, bean.getGender());
		pstmt.setInt(9, bean.getId());

		int i = pstmt.executeUpdate();

		System.out.println("data update successfully... " + i);

	}

	public UserBean searchAll() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myproject", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("select * from user");

		ResultSet rs = pstmt.executeQuery();

		UserBean bean = null;

		while (rs.next()) {

			bean = new UserBean();

			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLoginId(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));
			bean.setPhoneNo(rs.getString(7));
			bean.setAddress(rs.getString(8));
			bean.setGender(rs.getString(8));

		}

		return bean;

	}

}
