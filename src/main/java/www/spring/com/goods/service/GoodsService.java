package www.spring.com.goods.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import www.spring.com.framework.GoodsCriteria;
import www.spring.com.goods.model.GoodsVO;

public interface GoodsService {
	public int insertGoods(GoodsVO goods);
	public GoodsVO getGoods(int id);
	public int updateGoods(GoodsVO goods);
	public void deleteGoods(int id);
	public List<GoodsVO> getListWithPagingByCondition(@Param("cri") GoodsCriteria cri);
	public int getTotalCount(@Param("cri") GoodsCriteria cri);
}
