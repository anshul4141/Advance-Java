package com.rays.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.mchange.v2.c3p0.ComboPooledDataSource;

// step 1 make class final so child can not be created
public final class JDBCDataSource {

	// step 2 make self type of private static variable
	// static variable have one copy in life time
	private static JDBCDataSource datasource;

	private ComboPooledDataSource cpds = null;

	private static ResourceBundle rb = ResourceBundle.getBundle("com.rays.bundle.app");

	// step 3 make constructor private so object can not be created
	private JDBCDataSource() {

	}

	// step 4 make getInstance method
	public static JDBCDataSource getInstance() {

		if (datasource == null) {

			datasource = new JDBCDataSource();
			datasource.cpds = new ComboPooledDataSource();

			try {

				datasource.cpds.setDriverClass(rb.getString("driver"));
				datasource.cpds.setJdbcUrl(rb.getString("url"));
				datasource.cpds.setUser(rb.getString("username"));
				datasource.cpds.setPassword(rb.getString("password"));
				datasource.cpds.setInitialPoolSize(Integer.parseInt(rb.getString("initialpoolsize")));
				datasource.cpds.setMaxPoolSize(Integer.parseInt(rb.getString("maxpoolsize")));
				datasource.cpds.setAcquireIncrement(Integer.parseInt(rb.getString("acquireincrement")));

			} catch (Exception e) {
				// TODO: handle exception
			}

		}

		return datasource;

	}

	public static Connection getConnection() throws Exception {
		return getInstance().cpds.getConnection();
	}

	public static void closeConnection(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (Exception e) {
			}
		}
	}

	public static void trnRollback(Connection connection) throws Exception {
		if (connection != null) {

			try {
				connection.rollback();
			} catch (SQLException ex) {
				throw new Exception(ex.toString());
			}
		}
	}

}
