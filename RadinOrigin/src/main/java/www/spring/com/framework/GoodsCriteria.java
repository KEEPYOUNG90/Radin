package www.spring.com.framework;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Data;

@Data
public class GoodsCriteria extends PageDTO {
	private String searchType;
	private String keyword;

	public GoodsCriteria() {
		super();
	}

	public GoodsCriteria(int pageNum, int amount) {
		super(pageNum, amount);
	}
	
	public GoodsCriteria(GoodsCriteria cri, int totalCnt) {
		super(cri, totalCnt);
		this.searchType = cri.searchType;
		this.keyword = cri.keyword;
	}

	public String[] getSearchTypeArr() {
		return searchType == null ? new String[] {} : searchType.split("");
	}
	
	public String getListLink() {
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("");
		builder.queryParam("pageNum", getPageNum())
		.queryParam("amount", getAmount())
		.queryParam("searchType", getSearchType())
		.queryParam("keyword", getKeyword());

		return builder.toUriString();
	}

}
