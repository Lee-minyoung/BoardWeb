package co.yedam.mapper;

import java.util.List;
import java.util.Map;

import co.yedam.vo.ProductVO;

public interface ProductMapper {
	String selectMessage();
	String selectHint(String remainTimeString);
	
	public int getTotalCount(ProductVO studentList);
	public List<ProductVO> productListAll();
	public List<ProductVO> productListAll(int prd_code);
	public List<Map<String, Object>> fullData();

}
