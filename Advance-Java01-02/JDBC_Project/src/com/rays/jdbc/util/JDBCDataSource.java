package com.rays.jdbc.util;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

// 1. create class final so child can not be created
public final class JDBCDataSource {

	private static ComboPooledDataSource cpds = null;

	// 2. create default constructor private so no other class can create instance
	// of this class
	private JDBCDataSource() {
		try {
			cpds = new ComboPooledDataSource();
			cpds.setDriverClass("com.mysql.cj.jdbc.Driver");
			cpds.setJdbcUrl("jdbc:mysql://localhost:3306/sunrays");
			cpds.setUser("root");
			cpds.setPassword("root");
			cpds.setMaxPoolSize(150);
			cpds.setMinPoolSize(10);
			cpds.setAcquireIncrement(10);
			cpds.setInitialPoolSize(10);
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
