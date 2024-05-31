package com.rays.sp;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class TestStorFunction {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp", "root", "root");

		CallableStatement st = conn.prepareCall("{? = CALL storFunction(?)}");

		st.setInt(2, 1);

		st.registerOutParameter(1, Types.INTEGER);

		st.execute();

		System.out.println(st.getString(1));
	}

}
