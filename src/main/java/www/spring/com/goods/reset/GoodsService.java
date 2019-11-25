package www.spring.com.goods.reset;

import java.util.List;

import www.spring.com.goods.model.GoodsVO;

public interface GoodsService {
	public List<GoodsVO> lookUPGoods();
	public int insertGoods(GoodsVO goodsVO);
}
