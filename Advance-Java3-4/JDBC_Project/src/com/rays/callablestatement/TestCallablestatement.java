package com.rays.callablestatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class TestCallablestatement {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");

		CallableStatement cbst = conn.prepareCall("{call searchById(?)}");
		
		cbst.setInt(1, 3);

		ResultSet rs = cbst.executeQuery();

		while (rs.next()) {
			System.out.println(rs.getInt("id"));
			System.out.println(rs.getString("firstName"));
			System.out.println(rs.getString("lastName"));
			System.out.println(rs.getString("login"));
			System.out.println(rs.getString("password"));
			System.out.println(rs.getDate("dob"));
		}

	}

}
