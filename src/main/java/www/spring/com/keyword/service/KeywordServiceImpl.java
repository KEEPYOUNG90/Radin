package www.spring.com.keyword.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import www.spring.com.keyword.mapper.KeywordMapper;
import www.spring.com.keyword.model.Keyword;

@Service
public class KeywordServiceImpl implements KeywordService {
	@Autowired
	private KeywordMapper keywordMapper;
	
	@Override
	public int insertKeyword(Keyword keyword) {
		return keywordMapper.insertKeyword(keyword);
	}
	
	@Override
	public List<Keyword> selectKeywordIn(List<String> beKeywordStringList) {
		return keywordMapper.selectKeywordIn(beKeywordStringList);
	}
}