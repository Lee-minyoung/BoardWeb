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
import com.yedam.control.AddFormControl;
import com.yedam.control.BoardControl;
import com.yedam.control.BoardListControl;
import com.yedam.control.LoginControl;
import com.yedam.control.LogoutControl;
import com.yedam.control.MainControl;
import com.yedam.control.ModifyBoardControl;
import com.yedam.control.ModifyControl;
import com.yedam.control.RemoveBoardControl;

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
		map.put("/main.do", new MainControl());
//		map.put("url", "servlet"); // addStudent.do AddStudentServlet
		map.put("/boardList.do", new BoardListControl()); //글목록
		map.put("/addForm.do", new AddFormControl()); //등록화면
		map.put("/addBoard.do", new AddBoardControl()); //등록처리
		map.put("/board.do", new BoardControl()); //등록처리		
		map.put("/modifyForm.do", new ModifyControl()); //수정화면
		map.put("/modifyBoard.do", new ModifyBoardControl()); //수정화면
		// 삭제화면 삭제처리
		map.put("/removeBoard.do", new RemoveBoardControl());
		
		// 로그인
		map.put("/loginForm.do", new LoginControl()); // 화면
		map.put("/login.do", new LoginControl()); // 로그인 처리
		map.put("/logout.do", new LogoutControl()); // 로그아웃
		
		
		
		
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