package www.spring.com.goods.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import www.spring.com.framework.GoodsCriteria;
import www.spring.com.framework.PageDTO;
import www.spring.com.goods.model.GoodsVO;

public interface GoodsMapper {
	public int insertGoods(GoodsVO goods);

	public GoodsVO getGoods(int id);
	public int updateGoods(GoodsVO goods);
	public void deleteGoods(int id);
	public List<GoodsVO> getListWithPagingByCondition(@Param("cri") PageDTO cri);
	public int getTotalCount(@Param("cri") PageDTO cri);

	
	
	


}