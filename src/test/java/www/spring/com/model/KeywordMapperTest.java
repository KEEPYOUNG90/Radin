package www.spring.com.model;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;
import www.spring.com.keyword.mapper.KeywordMapper;
import www.spring.com.keyword.model.Keyword;

@RunWith(SpringJUnit4ClassRunner.class)
//mybatis 있기 때문에 xml열기
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class KeywordMapperTest {
	
	@Autowired
	private KeywordMapper Mapper;

	@Test
	public void testInsertGoods() {
			List<String> list = new ArrayList<>();
			list.add("테스트");
			list.add("키워드");
			list.add("넣기");
			String[] arr = {"두번째","해본다"};
			
			Mapper.insertKeyword(arr);
			
		
	}
	
}
