package www.spring.com.model;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;
import www.spring.com.goods.mapper.GoodsMapper;
import www.spring.com.goods.model.GoodsVO;

@RunWith(SpringJUnit4ClassRunner.class)
//mybatis 있기 때문에 xml열기
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class GoodsMapperTest {
	
	@Autowired
	private GoodsMapper goodsMapper;

	@Test
	public void testInsertGoods() {
		GoodsVO goods = new GoodsVO();
		goods.setName("이것이 자바다");
		goods.setPrice(100000);
		goods.setISBN("01049421169");
		goods.setPublish("2019-02-30");
		goods.setSubject("대학교재");
		goods.setContent("우리는 자바에 대해서 배울 것 입니다. 그러므로 자바를 잘 할 수 있게 됩니다.");
		goods.setBookindex("sdfsdf");
		goods.setPages(32);
		goods.setWeight("ssggKG");
		goods.setBooktype("양장본");
		goods.setIntro("ㄴㅇㅎㄶㅇㅎㄶㄴㅇㄹㄴㅇㅎㄴㅇㅎㄴㅇㅍㄶㅎㅇㅎ");
		goods.setInside("ㄱ0ㅔㅗ헤ㅗ햏");
		goodsMapper.insertGoods(goods);
	}
	
	//@Test
	public void testLookUPGoods() {
		try {
			List<GoodsVO> goods = goodsMapper.();
			goods.forEach(good->System.out.println(good));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testUpdateGoods() {
		GoodsVO goods = new GoodsVO();
		goods.setId(8);
		goods.setName("이것이 자바다");
		goods.setPrice(100000);
		goods.setISBN("01049421169");
		goods.setPublish("2019-02-30");
		goods.setSubject("대학교재");
		goods.setContent("우리는 자바에 대해서 배울 것 입니다. 그러므로 자바를 잘 할 수 있게 됩니다.");
		goods.setBookindex("sdfsdf");
		goods.setPages(32);
		goods.setWeight("ssggKG");
		goods.setBooktype("집에가자");
		goods.setIntro("ㄴㅇㅎㄶㅇㅎㄶㄴㅇㄹㄴㅇㅎㄴㅇㅎㄴㅇㅍㄶㅎㅇㅎ");
		goods.setInside("ㄱ0ㅔㅗ헤ㅗ햏");
		
		
		goodsMapper.updateGoods(goods);
	}
	
	@Test
	public void testdeleteGoods() {
		int dd=3;
		goodsMapper.deleteGoods(dd);
	}
	
	
}
