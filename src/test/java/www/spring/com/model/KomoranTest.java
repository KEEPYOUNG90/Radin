package www.spring.com.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import kr.co.shineware.nlp.komoran.core.analyzer.Komoran;
import kr.co.shineware.util.common.model.Pair;

class KomoranTest {

	@Test
	void test() {
		String modelPath = "C:\\swInstall\\komoran2.4\\models-full";
		Komoran komoran = new Komoran(modelPath);
		List<List<Pair<String, String>>> sentences = komoran.analyze("1,2,김동규,3,짤리냐");
		List<Pair<String, String>> sentence = sentences.get(0);
		for(Pair<String, String> token:sentence) {
			System.out.println(token);
		}
	}

}
