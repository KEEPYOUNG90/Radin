package www.spring.com.g2krel.model;

import lombok.Data;
import www.spring.com.buy.model.Buy;

@Data
public class G2KRel {

	int goodsId;
	int keywordId;
	
	public G2KRel() {}
	
	public G2KRel(int goodsId, int keywordId) {
		this.goodsId = goodsId;
		this.keywordId = keywordId;
	}
}
