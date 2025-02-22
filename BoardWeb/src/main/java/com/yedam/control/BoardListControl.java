package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.Control;
import com.yedam.PageVO;
import com.yedam.dao.BoardDAO;
import com.yedam.vo.BoardVO;
import com.yedam.vo.SearchVO;

public class BoardListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) //
			throws ServletException, IOException {

		String page = req.getParameter("page");
		page = page == null ? "1" : page;
		String sc= req.getParameter("searchCondition");
		String kw= req.getParameter("keyword");		
		sc = sc == null ? "" : sc; // null값 처리
		kw = kw == null ? "" : kw; // null값 처리

		// SearchVO : 파라미터
		SearchVO search = new SearchVO(Integer.parseInt(page),sc, kw);
		String name = "";

		// boardList.do -> (BoardListControl) -> boardList.jsp
		req.setAttribute("msg", name);

		BoardDAO edao = new BoardDAO();
		List<BoardVO> list = edao.selectBoard(search);
		req.setAttribute("list", list);

		// 페이징
		int totalCnt = edao.getTotalCount(search); // 실제건수
		PageVO paging = new PageVO(Integer.parseInt(page), totalCnt);
		req.setAttribute("paging", paging);
		
		//searchCondition, keyword 전달
		req.setAttribute("searchCondition", sc);
		req.setAttribute("keyword", kw);
		
		// 요청재지정(url:boardList.do (doardList.jsp))
		req.getRequestDispatcher("/WEB-INF/views/boardList.jsp").forward(req, resp);

	}
}
