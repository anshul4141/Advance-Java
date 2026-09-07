package com.rays.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public final class JDBCDataSource {

	public static Connection getConnection() {

		ResourceBundle rb = ResourceBundle.getBundle("com.rays.jdbc.bundle.app");

		Connection conn = null;

		try {
			Class.forName(rb.getString("driver"));
			conn = DriverManager.getConnection(rb.getString("url"), rb.getString("password"), rb.getString("username"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;

	}

	public static void closeConnection(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void trnRollBack(Connection conn) {
		try {
			conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
