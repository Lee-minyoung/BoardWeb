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

public class BoardListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) //
			throws ServletException, IOException {

		String page = req.getParameter("page");
		page = page == null ? "1" : page;

		String name = "";

		// boardList.do -> (BoardListControl) -> boardList.jsp
		req.setAttribute("msg", name);

		BoardDAO edao = new BoardDAO();
		List<BoardVO> list = edao.selectBoard(Integer.parseInt(page));
		req.setAttribute("list", list);

		// 페이징
		int totalCnt = edao.getTotalCount();
		PageVO paging = new PageVO(Integer.parseInt(page), totalCnt);
		req.setAttribute("paging", paging);
		
		// 요청재지정(url:boardList.do (doardList.jsp))
		req.getRequestDispatcher("/WEB-INF/views/boardList.jsp").forward(req, resp);

	}
}
