package com.rays.jdbc.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestJdbcDataSource {

	public static void main(String[] args) {

		for (int i = 1; i <= 1000; i++) {

			testSearch();
			System.out.println("connection: " + i);

		}

	}

	private static void testSearch() {

		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();

			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("select * from st_user where id = 1");

			while (rs.next()) {
				System.out.println("id: " + rs.getInt(1));
				System.out.println("firstName: " + rs.getString(2));
			}

		} catch (Exception e) {
			e.getMessage();
		}

	}

}
