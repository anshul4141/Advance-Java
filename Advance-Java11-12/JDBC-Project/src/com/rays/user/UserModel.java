package com.rays.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserModel {

	public int nextPk() throws Exception {

		int pk = 0;

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("select max(id) from st_user");

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {

			pk = rs.getInt(1);

		}

		return pk + 1;
	}

	public void add(UserBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("insert into st_user values(?,?,?,?,?,?,?)");

		pstmt.setInt(1, nextPk());
		pstmt.setString(2, bean.getFirstName());
		pstmt.setString(3, bean.getLastName());
		pstmt.setString(4, bean.getLoginId());
		pstmt.setString(5, bean.getPassword());
		pstmt.setString(6, bean.getAddress());
		pstmt.setDate(7, new java.sql.Date(bean.getDob().getTime()));

		int i = pstmt.executeUpdate();

		System.out.println("data added successfully: " + i);

	}

	public void update(UserBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement(
				"update st_user set firstName = ?, lastName = ?, loginId = ?, password = ?, address = ?, dob = ? where id = ?");

		pstmt.setString(1, bean.getFirstName());
		pstmt.setString(2, bean.getLastName());
		pstmt.setString(3, bean.getLoginId());
		pstmt.setString(4, bean.getPassword());
		pstmt.setString(5, bean.getAddress());
		pstmt.setDate(6, new java.sql.Date(bean.getDob().getTime()));
		pstmt.setInt(7, bean.getId());

		int i = pstmt.executeUpdate();

		System.out.println("data updated successfully: " + i);

	}

	public void delete(int id) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("delete from st_user where id = ?");

		pstmt.setInt(1, id);

		int i = pstmt.executeUpdate();

		System.out.println("data deleted successfully: " + i);

	}

	public List search() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("select * from st_user");

		ResultSet rs = pstmt.executeQuery();

		UserBean bean = null;
		List list = new ArrayList();

		while (rs.next()) {

			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLoginId(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setAddress(rs.getString(6));
			bean.setDob(rs.getDate(7));
			list.add(bean);

		}

		return list;
	}

}
