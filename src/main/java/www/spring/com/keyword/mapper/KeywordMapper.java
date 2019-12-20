package www.spring.com.keyword.mapper;

import java.util.List;

import www.spring.com.keyword.model.Keyword;

public interface KeywordMapper {
	public int insertKeyword(Keyword keyword);
	public List<Keyword> selectKeywordIn(List<String> beKeywordStringList);
}
