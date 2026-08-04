package com.rays.jdbc.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rays.jdbc.util.JDBCDataSource;

public class UserModel {

	public void add(UserBean bean) throws SQLException {

		Connection conn = null;

		UserBean existBean = findByLogin(bean.getLoginId());

		if (existBean != null) {
			throw new RuntimeException("loginId already exists");
		}

		try {

			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("insert into st_user values(?, ?, ?, ?, ?, ?)");

			pstmt.setInt(1, bean.getId());
			pstmt.setString(2, bean.getFirstName());
			pstmt.setString(3, bean.getLastName());
			pstmt.setString(4, bean.getLoginId());
			pstmt.setString(5, bean.getPassword());
			pstmt.setDate(6, new java.sql.Date(bean.getDob().getTime()));

			int i = pstmt.executeUpdate();

			conn.commit();

			System.out.println("record inserted successfully: " + i);

		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}

	}

	public void update(UserBean bean) throws SQLException {

		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
					"update st_user set firstName = ?, lastName = ?, loginId = ?, password = ?, dob = ? where id = ?");

			pstmt.setString(1, bean.getFirstName());
			pstmt.setString(2, bean.getLastName());
			pstmt.setString(3, bean.getLoginId());
			pstmt.setString(4, bean.getPassword());
			pstmt.setDate(5, new java.sql.Date(bean.getDob().getTime()));
			pstmt.setInt(6, bean.getId());

			int i = pstmt.executeUpdate();

			conn.commit();

			System.out.println("record updated successfully: " + i);

		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}

	}

	public void delete(int id) throws SQLException {

		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("delete from st_user where id = ?");

			pstmt.setInt(1, id);

			int i = pstmt.executeUpdate();

			conn.commit();

			System.out.println("record delete successfully: " + i);

		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}

	}

	public UserBean findByPk(int id) throws SQLException {

		Connection conn = null;
		UserBean bean = null;

		try {

			conn = JDBCDataSource.getConnection();

			PreparedStatement pstmt = conn.prepareStatement("select * from st_user where id = ?");

			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new UserBean();
				bean.setId(rs.getInt("id"));
				bean.setFirstName(rs.getString("firstName"));
				bean.setLastName(rs.getString("lastName"));
				bean.setLoginId(rs.getString("loginId"));
				bean.setPassword(rs.getString("password"));
				bean.setDob(rs.getDate("dob"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

		return bean;

	}

	public UserBean findByLogin(String loginId) throws SQLException {

		Connection conn = null;
		UserBean bean = null;

		try {

			conn = JDBCDataSource.getConnection();

			PreparedStatement pstmt = conn.prepareStatement("select * from st_user where loginId = ?");

			pstmt.setString(1, loginId);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new UserBean();
				bean.setId(rs.getInt("id"));
				bean.setFirstName(rs.getString("firstName"));
				bean.setLastName(rs.getString("lastName"));
				bean.setLoginId(rs.getString("loginId"));
				bean.setPassword(rs.getString("password"));
				bean.setDob(rs.getDate("dob"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

		return bean;

	}

	public UserBean authenticate(String loginId, String password) throws SQLException {

		UserBean bean = findByLogin(loginId);

		if (bean != null && bean.getPassword().equals(password)) {
			return bean;
		}

		return null;

	}

	public List<UserBean> search(UserBean bean, int pageNo, int pageSize) throws SQLException {

		Connection conn = null;
		List<UserBean> list = new ArrayList<UserBean>();
		StringBuffer sql = new StringBuffer("select * from st_user where 1=1 ");

		if (bean != null) {
			if (bean.getFirstName() != null && bean.getFirstName().length() > 0) {
				sql.append("and firstName like '" + bean.getFirstName() + "%' ");
			}
			if (bean.getLastName() != null && bean.getLastName().length() > 0) {
				sql.append("and lastName like '" + bean.getLastName() + "%' ");
			}
			if (bean.getLoginId() != null && bean.getLoginId().length() > 0) {
				sql.append("and loginId like '" + bean.getLoginId() + "%' ");
			}
			if (bean.getPassword() != null && bean.getPassword().length() > 0) {
				sql.append("and password like '" + bean.getPassword() + "%' ");
			}
			if (bean.getDob() != null && bean.getDob().getTime() > 0) {
				sql.append("and dob like '" + new java.sql.Date(bean.getDob().getTime()) + "'% ");
			}
		}

		if (pageSize > 0) {
			int index = (pageNo - 1) * pageSize;
			sql.append("limit " + index + ", " + pageSize);
		}

		conn = JDBCDataSource.getConnection();

		System.out.println("sql search query ====> " + sql.toString());

		PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt("id"));
			bean.setFirstName(rs.getString("firstName"));
			bean.setLastName(rs.getString("lastName"));
			bean.setLoginId(rs.getString("loginId"));
			bean.setPassword(rs.getString("password"));
			bean.setDob(rs.getDate("dob"));
			list.add(bean);
		}

		try {

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

		return list;

	}

}
