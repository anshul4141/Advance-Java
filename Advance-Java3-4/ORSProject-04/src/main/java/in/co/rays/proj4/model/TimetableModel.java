package in.co.rays.proj4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.proj4.bean.CourseBean;
import in.co.rays.proj4.bean.SubjectBean;
import in.co.rays.proj4.bean.TimetableBean;
import in.co.rays.proj4.util.JDBCDataSource;

public class TimetableModel {

	public Integer nextPk() throws Exception {
		int pk = 0;
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select max(id) from st_timetable");
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			pk = rs.getInt(1);
		}
		JDBCDataSource.closeConnection(conn);
		return pk + 1;
	}

	public void add(TimetableBean bean) throws Exception {

		CourseModel courseModel = new CourseModel();
		CourseBean courseBean = courseModel.findByPk(bean.getCourseId());
		bean.setCourseName(courseBean.getName());

		SubjectModel subjectModel = new SubjectModel();
		SubjectBean subjectBean = subjectModel.findByPk(bean.getSubjectId());
		bean.setSubjectName(subjectBean.getName());

		int pk = nextPk();

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn
				.prepareStatement("insert into st_timetable values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

		pstmt.setLong(1, pk);
		pstmt.setString(2, bean.getSemester());
		pstmt.setString(3, bean.getDescription());
		pstmt.setDate(4, new java.sql.Date(bean.getExamDate().getTime()));
		pstmt.setString(5, bean.getExamTime());
		pstmt.setLong(6, bean.getCourseId());
		pstmt.setString(7, bean.getCourseName());
		pstmt.setLong(8, bean.getSubjectId());
		pstmt.setString(9, bean.getSubjectName());
		pstmt.setString(10, bean.getCreatedBy());
		pstmt.setString(11, bean.getModifiedBy());
		pstmt.setTimestamp(12, bean.getCreatedDatetime());
		pstmt.setTimestamp(13, bean.getModifiedDatetime());

		int i = pstmt.executeUpdate();

		JDBCDataSource.closeConnection(conn);

		System.out.println("data inserted => " + i);

	}

	public void update(TimetableBean bean) throws Exception {

		CourseModel courseModel = new CourseModel();
		CourseBean courseBean = courseModel.findByPk(bean.getCourseId());
		bean.setCourseName(courseBean.getName());

		SubjectModel subjectModel = new SubjectModel();
		SubjectBean subjectBean = subjectModel.findByPk(bean.getSubjectId());
		bean.setSubjectName(subjectBean.getName());

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement(
				"update st_timetable set semester = ?, description = ?, exam_date = ?, exam_time = ?, course_id = ?, course_name = ?, subject_id = ?, subject_name = ?, created_by = ?, modified_by = ?, created_datetime = ?, modified_datetime = ? where id = ?");

		pstmt.setString(1, bean.getSemester());
		pstmt.setString(2, bean.getDescription());
		pstmt.setDate(3, new java.sql.Date(bean.getExamDate().getTime()));
		pstmt.setString(4, bean.getExamTime());
		pstmt.setLong(5, bean.getCourseId());
		pstmt.setString(6, bean.getCourseName());
		pstmt.setLong(7, bean.getSubjectId());
		pstmt.setString(8, bean.getSubjectName());
		pstmt.setString(9, bean.getCreatedBy());
		pstmt.setString(10, bean.getModifiedBy());
		pstmt.setTimestamp(11, bean.getCreatedDatetime());
		pstmt.setTimestamp(12, bean.getModifiedDatetime());
		pstmt.setLong(13, bean.getId());

		int i = pstmt.executeUpdate();

		JDBCDataSource.closeConnection(conn);

		System.out.println("data updated => " + i);

	}

	public void delete(long id) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("delete from st_timetable where id = ?");

		pstmt.setLong(1, id);

		int i = pstmt.executeUpdate();

		JDBCDataSource.closeConnection(conn);

		System.out.println("data deleted => " + i);

	}

	public TimetableBean findByPk(long id) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("select * from st_timetable where id = ?");

		pstmt.setLong(1, id);

		ResultSet rs = pstmt.executeQuery();

		TimetableBean bean = null;

		while (rs.next()) {
			bean = new TimetableBean();
			bean.setId(rs.getLong(1));
			bean.setSemester(rs.getString(2));
			bean.setDescription(rs.getString(3));
			bean.setExamDate(rs.getDate(4));
			bean.setExamTime(rs.getString(5));
			bean.setCourseId(rs.getLong(6));
			bean.setCourseName(rs.getString(7));
			bean.setSubjectId(rs.getLong(8));
			bean.setSubjectName(rs.getString(9));
			bean.setCreatedBy(rs.getString(10));
			bean.setModifiedBy(rs.getString(11));
			bean.setCreatedDatetime(rs.getTimestamp(12));
			bean.setModifiedDatetime(rs.getTimestamp(13));
		}
		JDBCDataSource.closeConnection(conn);
		return bean;
	}

	public List search(TimetableBean bean, int pageNo, int pageSize) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		StringBuffer sql = new StringBuffer("select * from st_timetable where 1=1");

		if (bean != null) {
			if (bean.getSemester() != null && bean.getSemester().length() > 0) {
				sql.append(" and semester like '" + bean.getSemester() + "%'");
			}
		}

		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			sql.append(" limit " + pageNo + ", " + pageSize);
		}

		System.out.println("sql ==>> " + sql.toString());

		PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		ResultSet rs = pstmt.executeQuery();

		List list = new ArrayList();

		while (rs.next()) {
			bean = new TimetableBean();
			bean.setId(rs.getLong(1));
			bean.setSemester(rs.getString(2));
			bean.setDescription(rs.getString(3));
			bean.setExamDate(rs.getDate(4));
			bean.setExamTime(rs.getString(5));
			bean.setCourseId(rs.getLong(6));
			bean.setCourseName(rs.getString(7));
			bean.setSubjectId(rs.getLong(8));
			bean.setSubjectName(rs.getString(9));
			bean.setCreatedBy(rs.getString(10));
			bean.setModifiedBy(rs.getString(11));
			bean.setCreatedDatetime(rs.getTimestamp(12));
			bean.setModifiedDatetime(rs.getTimestamp(13));
			list.add(bean);
		}
		JDBCDataSource.closeConnection(conn);
		return list;
	}
}
