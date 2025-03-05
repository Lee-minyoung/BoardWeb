package com.yedam;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.StudentMapper;
import com.yedam.vo.StudentVO;

public class StudentExe {
public static void main(String[] args) {
	SqlSession sqlSession = DataSource.getInstance().openSession();
	StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
	List<StudentVO> list = mapper.studentListAll();
	
	for(StudentVO student:list) {
		System.out.println(student.toString());
	}
}
}
