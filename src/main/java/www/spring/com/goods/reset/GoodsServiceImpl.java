package www.spring.com.goods.reset;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import www.spring.com.goods.mapper.GoodsMapper;
import www.spring.com.goods.model.GoodsVO;

@Service
public class GoodsServiceImpl implements GoodsService {
	@Autowired
	private GoodsMapper goodsMapper;

	@Override
	public List<GoodsVO> lookUPGoods() {
		List<GoodsVO> listAllBoard = goodsMapper.lookUPGoods();
		return listAllBoard;
	}

	@Override
	public int insertGoods(GoodsVO goodsVO) {
		return goodsMapper.insertGoods(goodsVO);
	}

}
