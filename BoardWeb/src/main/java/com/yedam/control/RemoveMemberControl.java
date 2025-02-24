package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.Control;

public record RemoveMemberControl() implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("mid");
		
		// MemberDAO에 삭제. boolean
		boolean isOk = true;
		
		if (isOk) {
			// {"retCode": "OK"}
			resp.getWriter().print("\"retCode\": \"OK\"}");
		} else {
			// {"retCode": "NG"}
			resp.getWriter().print("\"retCode\": \"NG\"}");
		}
		
	}
	
}
