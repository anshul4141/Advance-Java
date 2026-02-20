package com.rays.jdbc.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MarksheetModel {

	ResourceBundle rb = ResourceBundle.getBundle("com.rays.bundle.app");

	String url = rb.getString("url");
	String driver = rb.getString("driver");
	String username = rb.getString("username");
	String pwd = rb.getString("pwd");

	public int add(MarksheetBean bean) throws Exception {

		Class.forName(driver);

		Connection conn = DriverManager.getConnection(url, username, pwd);

		PreparedStatement pstmt = conn.prepareStatement("insert into st_marksheet values(?, ?, ?, ?, ?, ?)");

		pstmt.setInt(1, bean.getId());
		pstmt.setString(2, bean.getRollNo());
		pstmt.setString(3, bean.getName());
		pstmt.setInt(4, bean.getPhy());
		pstmt.setInt(5, bean.getChm());
		pstmt.setInt(5, bean.getMaths());

		int i = pstmt.executeUpdate();

		System.out.println(i + " row affected(marksheet added)");

		return bean.getId();

	}

	public void update(MarksheetBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcproject", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement(
				"update st_marksheet set rollNo = ?, name = ?, phy = ?, chm = ?, maths = ? where id = ?");

		pstmt.setString(1, bean.getRollNo());
		pstmt.setString(2, bean.getName());
		pstmt.setInt(3, bean.getPhy());
		pstmt.setInt(4, bean.getChm());
		pstmt.setInt(5, bean.getMaths());
		pstmt.setInt(6, bean.getId());

		int i = pstmt.executeUpdate();

		System.out.println(i + " row affected(marksheet updated)");
		conn.close();
		pstmt.close();
	}

	public void delete(MarksheetBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcproject", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("delete from st_marksheet where id = ?");

		pstmt.setInt(1, bean.getId());

		int i = pstmt.executeUpdate();

		System.out.println(i + " row affected(marksheet deleted)");
		conn.close();
		pstmt.close();
	}

	public MarksheetBean findByRollNo(String rollNo) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcproject", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("select * from st_marksheet where rollNo = ?");

		pstmt.setString(1, rollNo);

		MarksheetBean bean = null;

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			bean = new MarksheetBean();
			bean.setId(rs.getInt(1));
			bean.setRollNo(rs.getString(2));
			bean.setName(rs.getString(3));
			bean.setPhy(rs.getInt(4));
			bean.setChm(rs.getInt(5));
			bean.setMaths(rs.getInt(6));
		}

		return bean;
	}

	public MarksheetBean findByPk(int pk) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcproject", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("select * from st_marksheet where id = ?");

		pstmt.setInt(1, pk);

		MarksheetBean bean = null;

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			bean = new MarksheetBean();
			bean.setId(rs.getInt(1));
			bean.setRollNo(rs.getString(2));
			bean.setName(rs.getString(3));
			bean.setPhy(rs.getInt(4));
			bean.setChm(rs.getInt(5));
			bean.setMaths(rs.getInt(6));
		}

		return bean;
	}

	public List<MarksheetBean> search(MarksheetBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcproject", "root", "root");

		StringBuffer sql = new StringBuffer("select * from st_marksheet where 1 = 1");

		if (bean != null) {
			if (bean.getName() != null && bean.getName().length() > 0) {
				sql.append(" and name like '" + bean.getName() + "'");
			}
		}

		System.out.println("sql ===== > " + sql.toString());

		PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		ResultSet rs = pstmt.executeQuery();

		List list = new ArrayList();

		while (rs.next()) {
			bean = new MarksheetBean();
			bean.setId(rs.getInt(1));
			bean.setRollNo(rs.getString(2));
			bean.setName(rs.getString(3));
			bean.setPhy(rs.getInt(4));
			bean.setChm(rs.getInt(5));
			bean.setMaths(rs.getInt(6));
			list.add(bean);
		}

		return list;

	}

	public List<MarksheetBean> getMeritList() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcproject", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement(
				"select *, (phy+chm+maths) as total from st_marksheet order by total desc limit 0, 5");

		ResultSet rs = pstmt.executeQuery();

		List<MarksheetBean> list = new ArrayList<MarksheetBean>();
		MarksheetBean bean = null;

		while (rs.next()) {
			bean = new MarksheetBean();
			bean.setId(rs.getInt(1));
			bean.setRollNo(rs.getString(2));
			bean.setName(rs.getString(3));
			bean.setPhy(rs.getInt(4));
			bean.setChm(rs.getInt(5));
			bean.setMaths(rs.getInt(6));
			list.add(bean);
		}

		return list;

	}

}
