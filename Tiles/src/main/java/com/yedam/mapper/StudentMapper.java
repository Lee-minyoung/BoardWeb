package com.yedam.mapper;

import java.util.List;
import java.util.Map;

import com.yedam.vo.StudentVO;


public interface StudentMapper {
	// 메소드명: studentList
	public int getTotalCount(StudentVO studentList);
	public List<StudentVO> studentListAll();
	public List<StudentVO> studentListAll(int student_no);
	public List<Map<String, Object>> fullData();
}
