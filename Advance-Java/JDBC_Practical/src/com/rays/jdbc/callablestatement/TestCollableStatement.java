package com.rays.jdbc.callablestatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class TestCollableStatement {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		CallableStatement ctmt = conn.prepareCall("{CALL searchById()}");

		ResultSet rs = ctmt.executeQuery();

		while (rs.next()) {
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			System.out.println(rs.getString(4));
			System.out.println(rs.getString(5));
			System.out.println(rs.getDate(6));
		}

		conn.close();
		ctmt.close();

	}

}
