package com.yedam;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.control.AddBoardControl;
import com.yedam.control.BoardListControl;

/*
 * MVC 에서 Controller
 * url요청 -> servlet.
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet{
	Map<String, Control> map;
	
	public FrontController() {
		map = new HashMap<>(); // map 필드의 초기화	
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
//		map.put("url", "servlet"); // addStudent.do AddStudentServlet
		map.put("/boardList.do", new BoardListControl());
		map.put("/addboard.do", new AddBoardControl());
	}
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("front control");
		// http://localhost:8080/BoardWeb/addStudent.do => url
		// /BoardWeb/addStudent.do => uri
		String uri = req.getRequestURI(); // " /BoardWeb/addStudent.do"
		String context = req.getContextPath(); // " /BoardWeb"
		String page = uri.substring(context.length());
		
		System.out.println(page);
		// map컬렉션에서 key를 입력하면 value 반환
		Control control = map.get(page);
		control.exec(req, resp);
	}
}
; 