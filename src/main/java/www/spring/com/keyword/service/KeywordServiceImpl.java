package www.spring.com.keyword.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import www.spring.com.keyword.mapper.KeywordMapper;

@Service
public class KeywordServiceImpl implements KeywordService {
	@Autowired
	private KeywordMapper keywordMapper;
	
	@Override
	public int insertKeyword(String[] Keywords) {
		return keywordMapper.insertKeyword(Keywords);
	}

}
