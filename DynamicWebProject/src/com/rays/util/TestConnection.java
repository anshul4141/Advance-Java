package com.rays.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestConnection {

	public static void main(String[] args) throws Exception {

		for (int i = 0; i < 100; i++) {

			System.out.println(i + " " + "Connection");

			testGet();

		}

	}

	private static void testGet() throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("select * from st_user where id = 1");

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			System.out.println(rs.getString(4));
			System.out.println(rs.getString(5));
			System.out.println(rs.getDate(7));
			System.out.println(rs.getString(6));
		}

	}

}
