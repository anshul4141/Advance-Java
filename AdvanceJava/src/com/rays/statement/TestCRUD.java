package com.rays.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestCRUD {

	public static void main(String[] args) throws Exception {

//		add();
//		update();
		delete();
//		search();
//		findById();
//		findByName();
//		findByEmail();
//		authenticate();

	}

	private static void add() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCAdvance", "root", "root");

		Statement stmt = conn.createStatement();

		int i = stmt.executeUpdate(
				"insert into users values(3, 'Anish', 'Malwiya', 'anish@gmail.com', 'anish@123', '2003-05-06', 'Pune')");

		System.out.println("Data added successfully " + i);
	}

	private static void update() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCAdvance", "root", "root");

		Statement stmt = conn.createStatement();

		int i = stmt.executeUpdate("update users set password = 'pass@123' where id = 2");

		System.out.println("Data Updated successfully " + i);

	}

	private static void delete() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCAdvance", "root", "root");

		Statement stmt = conn.createStatement();

		int i = stmt.executeUpdate("delete from users where id = 3");

		System.out.println("data deleted successfully " + i);

	}

	private static void search() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCAdvance", "root", "root");

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("select * from users");

		while (rs.next()) {

			System.out.print(rs.getInt(1));
			System.out.print("\t" + rs.getString(2));
			System.out.print("\t" + rs.getString(3));
			System.out.print("\t" + rs.getString(4));
			System.out.print("\t" + rs.getString(5));
			System.out.print("\t" + rs.getDate(6));
			System.out.println("\t" + rs.getString(7));

		}

	}

}
