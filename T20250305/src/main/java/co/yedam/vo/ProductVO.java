package co.yedam.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductVO {
	private String prd_code;
	private String prd_name;
	private String prd_desc;
	private int origin_price;
	private int sale_price;
	private int star_point;
	private String prod_image;
}