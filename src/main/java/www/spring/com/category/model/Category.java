package www.spring.com.category.model;

import lombok.Data;
import www.spring.com.buy.model.Buy;

@Data
public class Category {
	private int id;
	private String name;
	private int childId;
}
