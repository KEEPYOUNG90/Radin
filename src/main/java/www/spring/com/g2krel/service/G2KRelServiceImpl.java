package www.spring.com.g2krel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import www.spring.com.g2krel.mapper.G2KRelMapper;
import www.spring.com.g2krel.model.G2KRel;
import www.spring.com.keyword.model.Keyword;

@Service
public class G2KRelServiceImpl implements G2KRelService {
	@Autowired
	private G2KRelMapper mapper;

	@Override
	public void insertG2K(List<G2KRel> g2kList) {
		mapper.insertG2K(g2kList);
	}
	
}
