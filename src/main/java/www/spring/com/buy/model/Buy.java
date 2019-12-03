package www.spring.com.buy.model;

import lombok.Data;
import www.spring.com.p2grel.model.P2GRel;

@Data
public class Buy extends P2GRel {
	private int amount;
	
}
