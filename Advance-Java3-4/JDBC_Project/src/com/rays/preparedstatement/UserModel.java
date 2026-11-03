package com.rays.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class UserModel {

	public int add(int id, String firstName, String lastName, String login, String password, Date dob)
			throws SQLException {

		Connection conn = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO ST_USER VALUES(?, ?, ?, ?, ?, ?)");

			pstmt.setInt(1, id);
			pstmt.setString(2, firstName);
			pstmt.setString(3, lastName);
			pstmt.setString(4, login);
			pstmt.setString(5, password);
			pstmt.setDate(6, new java.sql.Date(dob.getTime()));

			int i = pstmt.executeUpdate();

			conn.commit();
			System.out.println("record inserted successfully");

		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		} finally {
			conn.close();
		}

		return id;

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

	public int update(int id, String firstName, String lastName, String login, String password, Date dob)
			throws SQLException {

		Connection conn = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
					"UPDATE ST_USER SET FIRSTNAME = ?, LASTNAME = ?, LOGIN = ?, PASSWORD = ?, DOB = ? WHERE ID = ?");

			pstmt.setString(1, firstName);
			pstmt.setString(2, lastName);
			pstmt.setString(3, login);
			pstmt.setString(4, password);
			pstmt.setDate(5, new java.sql.Date(dob.getTime()));
			pstmt.setInt(6, id);

			int i = pstmt.executeUpdate();

			conn.commit();
			System.out.println("record updated successfully");

		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		} finally {
			conn.close();
		}

		return id;

	}

}
