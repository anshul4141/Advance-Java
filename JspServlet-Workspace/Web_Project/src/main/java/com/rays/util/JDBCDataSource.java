package com.rays.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.mchange.v2.c3p0.ComboPooledDataSource;

//step1. make class final so child can not be created.
//step2. make self type of static variable, static variable have one
// copy/memory in life time.
//step3. make default constructor private so no one other class can create
// instance of this class.
//step4. make getInstance method to return same class instance.
public final class JDBCDataSource {

	private static JDBCDataSource jdbc = null;
	private static ComboPooledDataSource cpds = null;
	private static ResourceBundle rb = ResourceBundle.getBundle("com.rays.bundle.system");

	private JDBCDataSource() {

		cpds = new ComboPooledDataSource();

		try {
			cpds.setDriverClass(rb.getString("driver"));
			cpds.setJdbcUrl(rb.getString("url"));
			cpds.setUser(rb.getString("username"));
			cpds.setPassword(rb.getString("password"));
			cpds.setMaxPoolSize(30);
			cpds.setMinPoolSize(5);
			cpds.setAcquireIncrement(5);
			cpds.setInitialPoolSize(5);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static JDBCDataSource getInstance() {

		if (jdbc == null) {
			jdbc = new JDBCDataSource();
			return jdbc;
		}
		return null;

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
