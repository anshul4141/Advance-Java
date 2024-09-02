package com.rays.util;

import java.util.ResourceBundle;

import com.mchange.v2.c3p0.ComboPooledDataSource;

// step1. make class final
public final class JDBCDataSource {

	// step2. make default counstructer private
	private JDBCDataSource() {

	}

	// step3. make self type of static variable
	private static JDBCDataSource datasource = null;

	private ComboPooledDataSource cpds = null;
	private static ResourceBundle rb = ResourceBundle.getBundle("com.rays.bundle.system");

	// step4. make getInstance method to return self type of instance
	public static JDBCDataSource getInstance() {

		if (datasource == null) {
			datasource = new JDBCDataSource();
			datasource.cpds = new ComboPooledDataSource();
			try {
				datasource.cpds.setDriverClass(rb.getString("driver"));
			} catch (Exception e) {
				System.out.println(e);
				e.printStackTrace();
			}
			datasource.cpds.setJdbcUrl(rb.getString("url"));
			datasource.cpds.setUser(rb.getString("user"));
			datasource.cpds.setPassword(rb.getString("password"));
			datasource.cpds.setInitialPoolSize(Integer.parseInt(rb.getString("initialpoolsize")));
			datasource.cpds.setAcquireIncrement(Integer.parseInt(rb.getString("acquireincrement")));
			datasource.cpds.setMaxPoolSize(Integer.parseInt(rb.getString("maxpoolsize")));
		}

		return datasource;

	}
}
