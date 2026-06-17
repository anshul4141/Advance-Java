package com.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.rays.bean.UserBean;
import com.rays.util.JDBCDataSource;

public class UserModel {

	public int nextPk() {
		int pk = 0;
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("SELECT MAX(id) FROM ST_USER");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				pk = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pk + 1;

	}

	public int add(UserBean bean) {

		int pk = nextPk();
		Connection conn = null;

		UserBean existBean = findByLogin(bean.getLoginId());

		if (existBean != null) {
			throw new RuntimeException("loginId already exist");
		}

		try {
			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO ST_USER VALUES(?, ?, ?, ?, ?, ?)");
			pstmt.setInt(1, pk);
			pstmt.setString(2, bean.getFirstName());
			pstmt.setString(3, bean.getLastName());
			pstmt.setString(4, bean.getLoginId());
			pstmt.setString(5, bean.getPassword());
			pstmt.setDate(6, new java.sql.Date(bean.getDob().getTime()));

			pstmt.executeUpdate();
			conn.commit(); // database changes committed successfully
		} catch (Exception e) {
			try {
				conn.rollback(); // database changes revert successfully
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

		return pk;

	}

	public UserBean findByLogin(String loginId) {

		Connection conn = null;
		UserBean bean = null;

		try {

			conn = JDBCDataSource.getConnection();

			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM ST_USER WHERE loginId = ?");

			pstmt.setString(1, loginId);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new UserBean();
				bean.setId(rs.getInt(1));
				bean.setFirstName(rs.getString(2));
				bean.setLastName(rs.getString(3));
				bean.setLoginId(rs.getString(4));
				bean.setPassword(rs.getString(5));
				bean.setDob(rs.getDate(6));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}

	public UserBean authenticate(String loginId, String password) {

		Connection conn = null;
		UserBean bean = null;

		try {

			conn = JDBCDataSource.getConnection();

			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM ST_USER WHERE loginId = ? AND password = ?");

			pstmt.setString(1, loginId);
			pstmt.setString(2, password);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new UserBean();
				bean.setId(rs.getInt(1));
				bean.setFirstName(rs.getString(2));
				bean.setLastName(rs.getString(3));
				bean.setLoginId(rs.getString(4));
				bean.setPassword(rs.getString(5));
				bean.setDob(rs.getDate(6));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}

}
