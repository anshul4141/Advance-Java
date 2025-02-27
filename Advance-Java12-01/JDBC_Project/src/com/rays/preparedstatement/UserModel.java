package com.rays.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.rays.util.JDBCDataSource;

public class UserModel {

	public void add(UserBean bean) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		UserBean existBean = findByLogin(bean.getLoginId());

		if (existBean != null) {

			throw new Exception("loginId alreday exist...");

		}

		conn.setAutoCommit(false);

		try {
			PreparedStatement pstmt = conn.prepareStatement("insert into user values(?,?,?,?,?,?,?,?)");

			pstmt.setInt(1, bean.getId());
			pstmt.setString(2, bean.getFirstName());
			pstmt.setString(3, bean.getLastName());
			pstmt.setString(4, bean.getLoginId());
			pstmt.setString(5, bean.getPassword());
			pstmt.setString(6, bean.getAddress());
			pstmt.setString(7, bean.getGender());
			pstmt.setDate(8, new java.sql.Date(bean.getDob().getTime()));

			int i = pstmt.executeUpdate();

			System.out.println("data added successfully: " + i);

			conn.commit();
		} catch (Exception e) {
			conn.rollback();
		}

	}

	public void delete(int id) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myproject", "root", "root");

		conn.setAutoCommit(false);

		try {
			PreparedStatement pstmt = conn.prepareStatement("delete from user where id = ?");

			pstmt.setInt(1, id);

			int i = pstmt.executeUpdate();

			System.out.println("data deleted successfully: " + i);

			conn.commit();
		} catch (Exception e) {
			conn.rollback();
		}

	}

	public List search(UserBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myproject", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("select * from user");

		ResultSet rs = pstmt.executeQuery();

		List list = new ArrayList();

		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLoginId(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setAddress(rs.getString(6));
			bean.setGender(rs.getString(7));
			bean.setDob(rs.getDate(8));
			list.add(bean);
		}

		return list;

	}

	public UserBean findByPk(int id) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myproject", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("select * from user where id = ?");

		pstmt.setInt(1, id);

		ResultSet rs = pstmt.executeQuery();
		UserBean bean = null;
		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLoginId(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setAddress(rs.getString(6));
			bean.setGender(rs.getString(7));
			bean.setDob(rs.getDate(8));

		}

		return bean;

	}

	// select * from user where loginId = ?
	public UserBean findByLogin(String loginId) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myproject", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("select * from user where loginId = ?");

		pstmt.setString(1, loginId);

		ResultSet rs = pstmt.executeQuery();

		UserBean bean = null;

		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLoginId(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setAddress(rs.getString(6));
			bean.setGender(rs.getString(7));
			bean.setDob(rs.getDate(8));
		}
		return bean;
	}

	// select * from user where loginId = ? and password = ?
	public UserBean authenticate(String loginId, String password) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myproject", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("select * from user where loginId = ? and password = ?");

		pstmt.setString(1, loginId);
		pstmt.setString(2, password);

		ResultSet rs = pstmt.executeQuery();

		UserBean bean = null;

		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLoginId(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setAddress(rs.getString(6));
			bean.setGender(rs.getString(7));
			bean.setDob(rs.getDate(8));
		}
		return bean;

	}

}
