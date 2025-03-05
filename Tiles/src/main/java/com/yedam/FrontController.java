package com.yedam;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.control.MainControl;

public class FrontController extends HttpServlet{
	
	Map<String, Control> map;
	
	public FrontController() {
		map = new HashMap<>();
	}
	
	// init
	@Override
	public void init(ServletConfig config) throws ServletException{
		// url - control
		map.put("/main.do", new MainControl());
	}
	
	// service
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// http://localhost:8080/Tiles/main.do
		String uri = req.getRequestURI(); // Tiles/main.do
		String context = req.getContextPath(); //Tiles
		String page = uri.substring(context.length()); // main.do
		
		Control sub = map.get(page);
		sub.exec(req, resp);
	}
}
