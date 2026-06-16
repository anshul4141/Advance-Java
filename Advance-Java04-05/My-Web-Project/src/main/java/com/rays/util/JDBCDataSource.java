package com.rays.util;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.mchange.v2.c3p0.ComboPooledDataSource;

// make class final so child can not be created
public final class JDBCDataSource {

	// make self type static variable static variable have one copy in there life
	// time
	private static JDBCDataSource jdbc = null;
	private static ComboPooledDataSource cpds = null;
	private static ResourceBundle rb = ResourceBundle.getBundle("com.rays.bundle.system");

	// make default constructor private so no one another class can create instance
	// of single/this class
	private JDBCDataSource() {
		try {
			cpds = new ComboPooledDataSource();
			cpds.setDriverClass(rb.getString("driver"));
			cpds.setJdbcUrl(rb.getString("url"));
			cpds.setUser(rb.getString("username"));
			cpds.setPassword(rb.getString("password"));
			cpds.setMinPoolSize(10);
			cpds.setMaxPoolSize(30);
			cpds.setInitialPoolSize(10);
			cpds.setAcquireIncrement(5);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
	}

	// make getInstance method to return instance of same class
	private static JDBCDataSource getInstance() {
		if (jdbc == null) {
			jdbc = new JDBCDataSource();
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

}
