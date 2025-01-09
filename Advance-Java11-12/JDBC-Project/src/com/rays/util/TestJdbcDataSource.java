package com.rays.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestJdbcDataSource {

	public static void main(String[] args) throws Exception {

		for (int i = 0; i < 100; i++) {
			System.out.println("connection = " + i);
			testSearch();

		}

	}

	private static void testSearch() throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("select * from st_user where id = 1");

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {

			System.out.print(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + "\n");

		}

	}

}
