package com.yedam.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.vo.Student;

public class StudentDAO extends DAO {

	public boolean addStudent(Student student) {
		String sql = "insert into tbl_student (student_no, student_name, phone, address)"//
				+ "values(?, ?, ?, ?)"
				;
		try {
			psmt = getConnect().prepareStatement(sql);
			psmt.setString(1, student.getStNumber());
			psmt.setString(2, student.getStName());
			psmt.setString(3, student.getPhone());
			psmt.setString(4, student.getAddress());

			// 쿼리실행
			int r = psmt.executeUpdate(); // 처리된 건수반환
			if (r > 0) {
				return true; //등록성공
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false; // 등록실패
	}

	// 학생목록을 반환 메소드.
	public List<Student> studentList() {
		List<Student> stuList = new ArrayList();
		String qry = "select * from tbl_student "
//				+ "where emp_name = nvl('" + emp.getEmpName + "', emp_name) "
//				+ "where student_name = nvl(?, student_name)" // number, varchar2에 따라 처리.
				+ "order by student_no";

		try {
			PreparedStatement stmt = getConnect().prepareStatement(qry);
//			stmt.setString(1, stu.getStName());
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Student stu1 = new Student();
				stu1.setStNumber(rs.getString("student_no"));
				stu1.setStName(rs.getString("student_name"));
				stu1.setPhone(rs.getString("phone"));
				stu1.setAddress(rs.getString("address"));
				stuList.add(stu1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stuList;
	} // end of studentList()
}
