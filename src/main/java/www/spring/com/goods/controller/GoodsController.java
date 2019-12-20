package www.spring.com.goods.controller;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import www.spring.com.framework.PageDTO;
import www.spring.com.g2krel.model.G2KRel;
import www.spring.com.g2krel.service.G2KRelService;
import www.spring.com.goods.model.GoodsVO;
import www.spring.com.goods.service.GoodsService;
import www.spring.com.keyword.model.Keyword;
import www.spring.com.keyword.service.KeywordService;

@Controller
@RequestMapping("/goods/*")
public class GoodsController {

	@Autowired
	private GoodsService goodsService;
	@Autowired
	private KeywordService keywordService;
	@Autowired
	private G2KRelService g2kRelService;

	@RequestMapping("/listAll.do")
	public String listAllBoard(Model model, PageDTO cri) {
		List<GoodsVO> listAllGoods = goodsService.getListWithPagingByCondition(cri);
		model.addAttribute("listAllGoods", listAllGoods);
		int totalCnt = goodsService.getTotalCount(cri);
		PageDTO pageDTO = new PageDTO(cri, totalCnt);
		model.addAttribute("pageMaker", pageDTO);
		return "goods/listAllGoods";
	}

	@GetMapping({ "showDetail", "modify" })
	public void getGoods(PageDTO cri, int id, Model model) {
		GoodsVO goods = goodsService.getGoods(id);
		model.addAttribute("goods", goods);
		model.addAttribute("pageMaker", cri);
	}

	@GetMapping("insertGoods")
	public void insertGoods() {
	}

	@PostMapping("/insert.do")
	public String insertGoods(GoodsVO goodsVO, String[] keywords, RedirectAttributes rttr) {
		goodsService.insertGoods(goodsVO);
		if (keywords != null) {
			//string[] -> list
			List<String> beKeywordStringList = new ArrayList<>();
			for(String keyword : keywords) {
				beKeywordStringList.add(keyword);
			}
			//string으로 키워드가 이미 있는 존재하는 리스트 만들어서 교집합 제거
			List<Keyword> existingKeywordList = keywordService.selectKeywordIn(beKeywordStringList);
			List<String> existingList = new ArrayList<>();
			for(Keyword key : existingKeywordList) {
				existingList.add(key.getWord());
			}
			beKeywordStringList.removeAll(existingList);
			//신규 키워드 반복 생성
			List<Keyword> beKeywordList = new ArrayList<>();
			for(String beKeyword : beKeywordStringList) {
				beKeywordList.add(new Keyword(beKeyword));
			}
			for(Keyword keyword : beKeywordList) {
				keywordService.insertKeyword(keyword);
			}
			
			//keyword와 goods 관계 연결
			List<G2KRel> g2kList = new ArrayList<>();
			//새로생긴 keyword와 goods를 연결
			for(Keyword keyword : beKeywordList) {
				g2kList.add(new G2KRel(goodsVO.getId(), keyword.getKeywordId()));
				System.out.println("--------------------");
				System.out.println(goodsVO.getId());
				System.out.println(keyword.getKeywordId());
			}
			//이미 있는 keyword와 goods를 연결
			for(Keyword keyword : existingKeywordList){
				g2kList.add(new G2KRel(goodsVO.getId(), keyword.getKeywordId()));
				System.out.println("--------------------");
				System.out.println(goodsVO.getId());
				System.out.println(keyword.getKeywordId());
			}
			g2kRelService.insertG2K(g2kList);
			
		}
		return "redirect:/goods/listAll.do";
	}

	@PostMapping("/makeHashTag")
	@ResponseBody
	public ResponseEntity<String> createReply(@RequestBody String keywordsString) throws Exception {
		ResponseEntity<String> ret = null;
		String komoranKeywords = goodsService.useKomoran(keywordsString);
		komoranKeywords = URLEncoder.encode(komoranKeywords, "UTF-8");

		ret = new ResponseEntity<>(komoranKeywords, HttpStatus.OK);

		return ret;
	}

	@PostMapping("/update")
	public String updateGoods(@ModelAttribute("pageMaker") PageDTO cri, GoodsVO goodsVO, RedirectAttributes rttr) {
		goodsService.updateGoods(goodsVO);
		// rttr.addFlashAttribute("result", "수정 처리 완료");
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		return "redirect:/goods/listAll.do";
	}

	@PostMapping("/deletePosting")
	public String deletePosting(@ModelAttribute("pageMaker") PageDTO cri, int id, RedirectAttributes rttr) {
		goodsService.deleteGoods(id);
		// rttr.addFlashAttribute("result", "삭제 처리 완료");
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		return "redirect:/goods/listAll.do";
	}

}
