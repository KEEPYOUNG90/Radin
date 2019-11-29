package www.spring.com.model;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import www.spring.com.keyword.www.radin.com.model.Info;
import www.spring.com.keyword.www.radin.com.model.Keyword;
import www.spring.com.keyword.www.radin.com.model.dao.InfoDAO;
import www.spring.com.keyword.www.radin.com.model.dao.KeywordDAO;

class InfoMng {

	//@Test
	void testCreateInfo() {
		//Mybatis를 활용하여 T_info에서 CRUD 기능을 개발합니다.
		Info info = createInfo();

		System.out.println(info);
	}

	@Test
	void testCreateKeyword() {
		Info info = createInfo();
		
		List<Keyword> listKW = new ArrayList<>();
		
		for(int i = 25; i < 35; i++) {
			Keyword kw = new Keyword();
			kw.setWord("가" + i);
			listKW.add(kw);
		}
		KeywordDAO kDao = new KeywordDAO();
		List<Keyword> listOfExisting = kDao.findExistings(listKW);
	
		//교집합과 차집합으로 구분하고
		//select * from t_keyword where word in ('가0', ..., '가9');
		//교는 id만 재사용.
		
		//차는 생성까지 한다.
		listKW.removeAll(listOfExisting);
		kDao.insertByBatch(listKW);

		kDao.insertMapping2InfoByBatch(info, listOfExisting, listKW);
		
	} 

	private Info createInfo() {
		Info info = new Info();
		info.setName("HJong길동");
		info.setSsn("031131-9876543");
		info.setAddress("서울 마포 이대 중앙 6f");
		info.setGender("남자");

		(new InfoDAO()).createInfo(info);
		
		return info;
	}
}
