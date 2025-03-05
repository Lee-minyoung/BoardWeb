package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.Control;
import com.yedam.common.DataSource;
import com.yedam.mapper.StudentMapper;
import com.yedam.vo.StudentVO;

public class MainControl implements Control{

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SqlSession sqlSession = DataSource.getInstance().openSession();
		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
		List<StudentVO> list = mapper.studentListAll();
		request.setAttribute("list", list);
		request.getRequestDispatcher("product/main.tiles").forward(request, response);
		
	}

	
		
	}
