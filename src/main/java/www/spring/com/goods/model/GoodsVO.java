package www.spring.com.goods.model;

import java.util.Date;

import lombok.Data;

@Data
public class GoodsVO {
	private int id;
	private String name;
	private int price;
	private String ISBN;
	private String publish;
	private String subject;
	private String content;
	private String bookindex;
	private int pages;
	private String weight;
	private String booktype;
	private String intro;
	private String inside;

}
