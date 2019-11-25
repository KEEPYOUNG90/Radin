package www.spring.com.goods.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import www.spring.com.goods.model.GoodsVO;
import www.spring.com.goods.reset.GoodsService;

@Controller
@RequestMapping("/goods/*")
public class GoodsController {
	
	@Autowired
	private GoodsService goodsService;
	
	@RequestMapping("/listAll.do")
	public String listAllBoard(Model model) {
		List<GoodsVO> listAllGoods = goodsService.lookUPGoods();
		model.addAttribute("listAllGoods", listAllGoods);
		return "goods/listAllGoods";
	}
	@GetMapping("insertGoods") 
	public void insertGoods() {
	}
	
	
	@PostMapping("/insert.do")
	public String insertBoard(GoodsVO goodsVO, RedirectAttributes rttr) {
		
		goodsService.insertGoods(goodsVO);
		rttr.addFlashAttribute("result", goodsVO.getId()); 
		return "redirect:/goods/listAll.do"; 
	}
	 
 
	
	
	
}
