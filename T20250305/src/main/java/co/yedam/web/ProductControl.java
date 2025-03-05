package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.Control;
import co.yedam.common.DataSource;
import co.yedam.mapper.ProductMapper;

public class ProductControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String prd_code = req.getParameter("prd_code");
		
		SqlSession sqlSession = DataSource.getInstance().openSession();
		ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
		
		req.getRequestDispatcher("product/productInfo.tiles").forward(req, resp);
	}

}
