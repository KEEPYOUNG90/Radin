package www.spring.com.goods.controller;

import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import www.spring.com.goods.model.GoodsVO;
import www.spring.com.goods.service.GoodsService;
import www.spring.com.keyword.service.KeywordService;

@Controller
@RequestMapping("/goods/*")
public class GoodsController {
	
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private KeywordService keywordService;
	
	@RequestMapping("/listAll.do")
	public String listAllBoard(Model model, PageDTO cri) {
		List<GoodsVO> listAllGoods = goodsService.getListWithPagingByCondition(cri);
		//List<GoodsVO> listAllGoods = goodsService.test1();
		model.addAttribute("listAllGoods", listAllGoods);
		int totalCnt = goodsService.getTotalCount(cri);
		PageDTO pageDTO = new PageDTO(cri,totalCnt);
		model.addAttribute("pageMaker", pageDTO);
		return "goods/listAllGoods";
	}
	
	@GetMapping({"showDetail","modify"}) 
	public void getGoods(PageDTO cri, int id, Model model) {
		GoodsVO goods = goodsService.getGoods(id);
		model.addAttribute("goods", goods);
		model.addAttribute("pageMaker", cri);
	}
	
	@GetMapping("insertGoods") 
	public void insertGoods() {
	}
	
	
	@PostMapping("/insert.do")
<<<<<<< HEAD
	public String insertGoods(HttpServletRequest request, GoodsVO goodsVO, RedirectAttributes rttr) {
		String[] keywords = request.getParameterValues("Keywords");
		goodsService.insertGoods(goodsVO);
		if(keywords != null) {
			keywordService.insertKeyword(keywords);
		}
=======
	public String insertGoods(GoodsVO goodsVO, List<String> Keywords, RedirectAttributes rttr) {
		
		goodsService.insertGoods(goodsVO);
		keywordService.insertKeyword(Keywords);
>>>>>>> 113727c48b4d5a6c7189d2140d96584cdda191b1
		return "redirect:/goods/listAll.do"; 
	}
	
	@PostMapping("/makeHashTag")
	@ResponseBody
	public ResponseEntity<String> createReply(@RequestBody String keywordsString) throws Exception{
		ResponseEntity<String> ret = null;
		String komoranKeywords = goodsService.useKomoran(keywordsString);
		komoranKeywords = URLEncoder.encode(komoranKeywords , "UTF-8");
		
		ret = new ResponseEntity<>(komoranKeywords, HttpStatus.OK);

		return ret;
	}
	 
	@PostMapping("/update")
    public String updateGoods(@ModelAttribute("pageMaker") PageDTO cri, GoodsVO goodsVO, RedirectAttributes rttr) {
		goodsService.updateGoods(goodsVO);
        //rttr.addFlashAttribute("result", "수정 처리 완료");
        rttr.addAttribute("pageNum", cri.getPageNum());
        rttr.addAttribute("amount", cri.getAmount());
        return "redirect:/goods/listAll.do";
    }
    @PostMapping("/deletePosting")
    public String deletePosting(@ModelAttribute("pageMaker") PageDTO cri, int id, RedirectAttributes rttr) {
    	goodsService.deleteGoods(id);
        //rttr.addFlashAttribute("result", "삭제 처리 완료");
        rttr.addAttribute("pageNum", cri.getPageNum());
        rttr.addAttribute("amount", cri.getAmount());
        return "redirect:/goods/listAll.do";
    }
	
	
	
}
