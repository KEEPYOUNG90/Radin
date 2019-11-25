package www.spring.com.goods.mapper;

import java.util.List;

import www.spring.com.goods.model.GoodsVO;

public interface GoodsMapper {
	public int insertGoods(GoodsVO goods);
	//public List<GoodsVO> getAllBoard();

	public List<GoodsVO> lookUPGoods();
	
	public int updateGoods(GoodsVO goods);
	//public List<GoodsVO> getAllBoard();

	public void deleteGoods(GoodsVO goods);

}