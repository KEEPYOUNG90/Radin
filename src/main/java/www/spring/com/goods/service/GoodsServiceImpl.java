package www.spring.com.goods.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import www.spring.com.framework.GoodsCriteria;
import www.spring.com.goods.mapper.GoodsMapper;
import www.spring.com.goods.model.GoodsVO;

@Service
public class GoodsServiceImpl implements GoodsService {
	@Autowired
	private GoodsMapper goodsMapper;

	@Override
	public int insertGoods(GoodsVO goodsVO) {
		return goodsMapper.insertGoods(goodsVO);
	}

	@Override
	public GoodsVO getGoods(int id) {
		return goodsMapper.getGoods(id);
	}

	@Override
	public int updateGoods(GoodsVO goods) {
		return goodsMapper.updateGoods(goods);
	}

	@Override
	public void deleteGoods(int id) {
		goodsMapper.deleteGoods(id);
	}

	@Override
	public List<GoodsVO> getListWithPagingByCondition(GoodsCriteria cri) {
		return goodsMapper.getListWithPagingByCondition(cri);
	}

	@Override
	public int getTotalCount(GoodsCriteria cri) {
		return goodsMapper.getTotalCount(cri);
	}

}
