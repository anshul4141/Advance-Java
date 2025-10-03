package com.rays.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJDBCDataSource {

	public static void main(String[] args) throws SQLException {

		for (int i = 1; i <= 100; i++) {
			testSearch();
			System.out.println("no of connection: " + i);
		}

	}

	public static void testSearch() throws SQLException {

		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();

			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("select * from st_user where id = 1");

			while (rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
