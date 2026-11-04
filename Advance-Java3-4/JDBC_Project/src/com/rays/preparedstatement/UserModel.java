package com.rays.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserModel {

	public int add(UserBean bean) throws SQLException {

		Connection conn = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO ST_USER VALUES(?, ?, ?, ?, ?, ?)");

			pstmt.setInt(1, bean.getId());
			pstmt.setString(2, bean.getFirstName());
			pstmt.setString(3, bean.getLastName());
			pstmt.setString(4, bean.getLogin());
			pstmt.setString(5, bean.getPassword());
			pstmt.setDate(6, new java.sql.Date(bean.getDob().getTime()));

			int i = pstmt.executeUpdate();

			conn.commit();
			System.out.println("record inserted successfully");

		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		} finally {
			conn.close();
		}

		return bean.getId();

	}

	public void delete(int id) throws SQLException {

		Connection conn = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("DELETE FROM ST_USER WHERE ID = ?");

			pstmt.setInt(1, id);

			int i = pstmt.executeUpdate();

			conn.commit();
			System.out.println("record deleted successfully");

		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		} finally {
			conn.close();
		}

	}

	public void update(UserBean bean) throws SQLException {

		Connection conn = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
					"UPDATE ST_USER SET FIRSTNAME = ?, LASTNAME = ?, LOGIN = ?, PASSWORD = ?, DOB = ? WHERE ID = ?");

			pstmt.setString(1, bean.getFirstName());
			pstmt.setString(2, bean.getLastName());
			pstmt.setString(3, bean.getLogin());
			pstmt.setString(4, bean.getPassword());
			pstmt.setDate(5, new java.sql.Date(bean.getDob().getTime()));
			pstmt.setInt(6, bean.getId());

			int i = pstmt.executeUpdate();

			conn.commit();
			System.out.println("record updated successfully");

		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		} finally {
			conn.close();
		}

	}

	public UserBean findByPk(int id) throws SQLException {

		Connection conn = null;
		UserBean bean = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");

			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM ST_USER WHERE ID = ?");

			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new UserBean();
				bean.setId(rs.getInt("id"));
				bean.setFirstName(rs.getString("firstName"));
				bean.setLastName(rs.getString("lastName"));
				bean.setLogin(rs.getString("login"));
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

	public UserBean findByLogin(String login) throws SQLException {

		Connection conn = null;
		UserBean bean = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");

			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM ST_USER WHERE LOGIN = ?");

			pstmt.setString(1, login);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new UserBean();
				bean.setId(rs.getInt("id"));
				bean.setFirstName(rs.getString("firstName"));
				bean.setLastName(rs.getString("lastName"));
				bean.setLogin(rs.getString("login"));
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

	public UserBean authenticate(String login, String password) throws SQLException {

		UserBean bean = findByLogin(login);

		if (bean != null && bean.getPassword().equals(password)) {
			return bean;
		}

		return null;

	}

}
