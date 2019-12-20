package www.spring.com.keyword.model;

import lombok.Data;

@Data
public class Keyword {
	private int keywordId;
	private String word;
	
	public Keyword() {}
	
	public Keyword(String word) {
		this.word = word;
	}
}

