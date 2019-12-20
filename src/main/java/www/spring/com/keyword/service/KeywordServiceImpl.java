package www.spring.com.keyword.service;

<<<<<<< HEAD
=======
import java.util.List;

>>>>>>> 113727c48b4d5a6c7189d2140d96584cdda191b1
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import www.spring.com.keyword.mapper.KeywordMapper;

@Service
public class KeywordServiceImpl implements KeywordService {
	@Autowired
	private KeywordMapper keywordMapper;
	
	@Override
<<<<<<< HEAD
	public int insertKeyword(String[] Keywords) {
=======
	public int insertKeyword(List<String> Keywords) {
>>>>>>> 113727c48b4d5a6c7189d2140d96584cdda191b1
		return keywordMapper.insertKeyword(Keywords);
	}

}
