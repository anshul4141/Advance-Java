package com.rays.util;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.mchange.v2.c3p0.ComboPooledDataSource;

//1. create class final so child can not be created
public final class JDBCDataSource {

	private static ComboPooledDataSource cpds = null;

	private static ResourceBundle rb = ResourceBundle.getBundle("com.rays.bundle.system");

	// 2. create default constructor private so no other class can create instance
	// of this class
	private JDBCDataSource() {
		try {
			cpds = new ComboPooledDataSource();
			cpds.setDriverClass(rb.getString("driver"));
			cpds.setJdbcUrl(rb.getString("url"));
			cpds.setUser(rb.getString("username"));
			cpds.setPassword(rb.getString("password"));
			cpds.setMaxPoolSize(Integer.parseInt(rb.getString("maxPoolSize")));
			cpds.setMinPoolSize(Integer.parseInt(rb.getString("minPoolSize")));
			cpds.setAcquireIncrement(Integer.parseInt(rb.getString("acquireIncrement")));
			cpds.setInitialPoolSize(Integer.parseInt(rb.getString("initialPoolSize")));
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 3. create static attribute of same type static attribute have only one copy
	// in there life time
	private static JDBCDataSource jdbc = null;

	// 4. create getInstance method that return instance of same type
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
			return null;
		}
	}

}
