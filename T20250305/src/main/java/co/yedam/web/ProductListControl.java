package co.yedam.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.Control;
import co.yedam.common.DataSource;
import co.yedam.mapper.ProductMapper;

import co.yedam.vo.ProductVO;

public class ProductListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SqlSession sqlSession = DataSource.getInstance().openSession();
		ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
		List<ProductVO> list = mapper.productListAll();
		req.setAttribute("list", list);
		req.getRequestDispatcher("product/productList.tiles").forward(req, resp);

	}

}
