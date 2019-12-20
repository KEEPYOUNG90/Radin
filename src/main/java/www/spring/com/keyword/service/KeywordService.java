package www.spring.com.keyword.service;

import java.util.List;

import www.spring.com.keyword.model.Keyword;

public interface KeywordService {
	public int insertKeyword(Keyword keyword);
	public List<Keyword> selectKeywordIn(List<String> beKeywordStringList);

}
