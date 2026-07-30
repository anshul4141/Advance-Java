package com.rays.jdbc.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class UserModel {

	public void add(int id, String firstName, String lastName, String login, String password, Date dob)
			throws SQLException {

		Connection conn = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("insert into st_user values(?, ?, ?, ?, ?, ?)");

			pstmt.setInt(1, id);
			pstmt.setString(2, firstName);
			pstmt.setString(3, lastName);
			pstmt.setString(4, login);
			pstmt.setString(5, password);
			pstmt.setDate(6, new java.sql.Date(dob.getTime()));

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

	public void update(int id, String firstName, String lastName, String login, String password, Date dob)
			throws SQLException {

		Connection conn = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
					"update st_user set firstName = ?, lastName = ?, loginId = ?, password = ?, dob = ? where id = ?");

			pstmt.setString(1, firstName);
			pstmt.setString(2, lastName);
			pstmt.setString(3, login);
			pstmt.setString(4, password);
			pstmt.setDate(5, new java.sql.Date(dob.getTime()));
			pstmt.setInt(6, id);

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

			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");

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

}
