package com.rays.jdbc.util;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

//1. Single class will provide connection with database.
//2. Provide Reliable Connection with database.
public final class JDBCDataSource {

	private static JDBCDataSource jdbc = null;
	private ComboPooledDataSource cpds = null;

	private JDBCDataSource() {

		cpds = new ComboPooledDataSource();
		try {
			cpds.setDriverClass("com.mysql.cj.jdbc.Driver");
			cpds.setJdbcUrl("jdbc:mysql://localhost:3306/demo");
			cpds.setUser("root");
			cpds.setPassword("root");
			cpds.setMaxPoolSize(30);
			cpds.setMinPoolSize(10);
			cpds.setInitialPoolSize(10);
			cpds.setAcquireIncrement(10);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static JDBCDataSource getInstance() {

		if (jdbc == null) {
			jdbc = new JDBCDataSource();
			return jdbc;
		}
		return jdbc;

	}

	public static Connection getConnection() {
		try {
			return getInstance().cpds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void closeConnection(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void trnRollBack(Connection conn) {
		if (conn != null) {
			try {
				conn.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
