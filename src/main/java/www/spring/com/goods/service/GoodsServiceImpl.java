package www.spring.com.goods.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.shineware.nlp.komoran.core.analyzer.Komoran;
import kr.co.shineware.util.common.model.Pair;
import www.spring.com.framework.PageDTO;
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
	public List<GoodsVO> getListWithPagingByCondition(PageDTO cri) {
		return goodsMapper.getListWithPagingByCondition(cri);
	}

	@Override
	public int getTotalCount(PageDTO cri) {
		return goodsMapper.getTotalCount(cri);
	}

	@Override
	public String useKomoran(String keywordsString) {
		String[] komoranKey = {"NNP", "NNG", "NMB", "NR", "NP"};
		
		String modelPath = "C:\\swInstall\\komoran2.4\\models-full";
		Komoran komoran = new Komoran(modelPath);
		List<List<Pair<String, String>>> sentences = komoran.analyze(keywordsString);
		List<Pair<String, String>> sentence = sentences.get(0);

		Set<String> s = new HashSet<>();
		for(Pair<String, String> token : sentence) {
			for(String key : komoranKey) {
				if(token.getSecond().equals(key)) {
					s.add(token.getFirst());
				}
			}
		}
		String keywords = s.toString();
		return keywords.substring(1, keywords.length()-1);
	}
	
	

}
