package com.rays.sp;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class TestStorProcedure {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp", "root", "root");

		CallableStatement callStmt = conn.prepareCall("{CALL searchEmp(?)}");

		callStmt.setInt(1, 3);

		ResultSet rs = callStmt.executeQuery();

		while (rs.next()) {

			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));

		}

	}

}
