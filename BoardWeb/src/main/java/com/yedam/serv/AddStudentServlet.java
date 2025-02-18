package com.yedam.serv;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.dao.StudentDAO;
import com.yedam.vo.Student;
@WebServlet("/addStudentServlet")
public class AddStudentServlet extends HttpServlet {
	//param 의 값을 활용 -> db 입력
	//처리성공 / 처리실패
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		?empNo=1004&empName=kim&telNo=654-0107
		resp.setContentType("text/html;charset=utf-8");
		
		String sno = req.getParameter("stNumber"); // empNo의 param에 담겨있는 값 반환
		String sname = req.getParameter("stName");
		String tel = req.getParameter("phone");
		String addr = req.getParameter("address");
		
		// 매개값으로 student
		Student std = new Student();
		std.setStNumber(sno);
		std.setStName(sname);
		std.setPhone(tel);
		std.setAddress(addr);	
		System.out.print(std.toString());
		//db등록
		StudentDAO sdao = new StudentDAO();	
//		boolean result = sdao.addStudent(new Student(sno, sname, tel, addr));
		if (sdao.addStudent(std)) {
			resp.getWriter().print("처리성공");
//			resp.sendRedirect("sample"); // addEmpServlet -> sample 페이지로 이동
		} else {
			resp.getWriter().print("처리실패");
		}
	}
	
	
	
	
}
