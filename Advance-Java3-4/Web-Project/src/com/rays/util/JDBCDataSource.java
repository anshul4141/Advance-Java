package com.rays.util;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public final class JDBCDataSource {

	private static JDBCDataSource datasource = null;

	private static ComboPooledDataSource cpds = null;

	private JDBCDataSource() {

	}

	private static JDBCDataSource getInstance() {

		if (datasource == null) {
			datasource = new JDBCDataSource();
			datasource.cpds = new ComboPooledDataSource();

			ResourceBundle rb = ResourceBundle.getBundle("com.rays.bundle.app");

			try {
				datasource.cpds.setDriverClass(rb.getString("driver"));
				datasource.cpds.setJdbcUrl(rb.getString("url"));
				datasource.cpds.setUser(rb.getString("username"));
				datasource.cpds.setPassword(rb.getString("password"));
				datasource.cpds.setAcquireIncrement(Integer.parseInt(rb.getString("acquireIncrement")));
				datasource.cpds.setInitialPoolSize(Integer.parseInt(rb.getString("initialPoolSize")));
				datasource.cpds.setMaxPoolSize(Integer.parseInt(rb.getString("maxPoolSize")));
				datasource.cpds.setMinPoolSize(Integer.parseInt(rb.getString("minPoolSize")));
			} catch (PropertyVetoException e) {
				e.printStackTrace();
			}
		}

		return datasource;

	}

	public static Connection getConnection() throws SQLException {
		return getInstance().cpds.getConnection();
	}

	public static void closeConnection(Connection conn) throws SQLException {
		if (conn != null) {
			conn.close();
		}
	}

	public static void trnRollback(Connection conn) throws SQLException {
		if (conn != null) {
			conn.rollback();
		}
	}

}