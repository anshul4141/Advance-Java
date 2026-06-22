package com.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

		JDBCDataSource.closeConnection(conn);
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

		JDBCDataSource.closeConnection(conn);
		return pk;

	}

	public void update(UserBean bean) {

		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
					"UPDATE st_user SET firstName = ?, lastName = ?, loginId = ?, password = ?, dob = ? WHERE id = ?");

			pstmt.setString(1, bean.getFirstName());
			pstmt.setString(2, bean.getLastName());
			pstmt.setString(3, bean.getLoginId());
			pstmt.setString(4, bean.getPassword());
			pstmt.setDate(5, new java.sql.Date(bean.getDob().getTime()));
			pstmt.setInt(6, bean.getId());

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

		JDBCDataSource.closeConnection(conn);

	}

	public void delete(int id) {

		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("DELETE FROM st_user WHERE id = ?");
			pstmt.setInt(1, id);

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

		JDBCDataSource.closeConnection(conn);

	}

	public UserBean findByPk(int id) {

		Connection conn = null;
		UserBean bean = null;

		try {

			conn = JDBCDataSource.getConnection();

			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM ST_USER WHERE id = ?");

			pstmt.setInt(1, id);

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

		JDBCDataSource.closeConnection(conn);
		return bean;
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

		JDBCDataSource.closeConnection(conn);
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

		JDBCDataSource.closeConnection(conn);
		return bean;
	}

	public List<UserBean> search(UserBean bean, int pageNo, int pageSize) {

		Connection conn = null;
		List<UserBean> list = new ArrayList<UserBean>();
		StringBuffer sql = new StringBuffer("SELECT * FROM st_user WHERE 1 = 1 ");
		try {

			if (bean != null) {
				if (bean.getId() > 0) {
					sql.append("AND id = " + bean.getId());
				}
				if (bean.getFirstName() != null && bean.getFirstName().length() > 0) {
					sql.append("AND firstName LIKE '" + bean.getFirstName() + "%'");
				}
				if (bean.getLastName() != null && bean.getLastName().length() > 0) {
					sql.append("AND lastName LIKE '" + bean.getLastName() + "%'");
				}
				if (bean.getLoginId() != null && bean.getLoginId().length() > 0) {
					sql.append("AND loginId LIKE '" + bean.getLoginId() + "%'");
				}
				if (bean.getPassword() != null && bean.getPassword().length() > 0) {
					sql.append("AND password LIKE '" + bean.getPassword() + "%'");
				}
				if (bean.getDob() != null && bean.getDob().getTime() > 0) {
					sql.append("AND dob = '" + new java.sql.Date(bean.getDob().getTime()) + "'");
				}
			}

			if (pageSize > 0) {
				int index = 0;
				index = (pageNo - 1) * pageSize; // formula to get index
				sql.append(" limit " + index + ", " + pageSize);
			}

			System.out.println("SQL =====> " + sql.toString());

			conn = JDBCDataSource.getConnection();

			PreparedStatement pstmt = conn.prepareStatement(sql.toString());

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new UserBean();
				bean.setId(rs.getInt(1));
				bean.setFirstName(rs.getString(2));
				bean.setLastName(rs.getString(3));
				bean.setLoginId(rs.getString(4));
				bean.setPassword(rs.getString(5));
				bean.setDob(rs.getDate(6));
				list.add(bean);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		JDBCDataSource.closeConnection(conn);
		return list;
	}

}
