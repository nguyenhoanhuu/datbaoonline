package fit.iuh.edu.datbaogiay.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fit.iuh.edu.datbaogiay.dto.BaoDto;
import fit.iuh.edu.datbaogiay.dto.KhachHangDto;
import fit.iuh.edu.datbaogiay.dto.KhuyenMaiDto;
import fit.iuh.edu.datbaogiay.entity.Bao;
import fit.iuh.edu.datbaogiay.service.BaoService;

@Controller
public class BaoController {
	@Autowired
	private BaoService BaoService;

//	public BaoController(BaoService BaoService) {
//		super();
//		this.BaoService = BaoService;
//	}
//	@GetMapping(value = "/bao", consumes = MediaType.ALL_VALUE)
//	public List<BaoDto> layDSBao() {
//		return BaoService.layDSBao();
//	}

	@GetMapping(value = "/bao", consumes = MediaType.ALL_VALUE)
	public String danhSachBao(Model theModel) {
		List<BaoDto> baos = BaoService.layDSBao();
		theModel.addAttribute("dsBao", baos);
		return "PageChinh";
	}
	@GetMapping(value = "/admin/bao/show", consumes = MediaType.ALL_VALUE)
	public String danhSachBao1(Model theModel) {
		List<BaoDto> baos = BaoService.layDSBao();
		theModel.addAttribute("dsBao", baos);
		return "PageQuanLySanPham";
	}
//	@GetMapping("search")
//	public String search(ModelMap model, @RequestParam(tenBao="tenBao",required = false) String tenBao) {
//		List<BaoDto> list = null;
//		
//		if(StringUtils.hasText(tenBao)) {
//			list = BaoService.timBaoTheoTen(tenBao);
//			
//		}else {
//			list= BaoService.layDSBao();
//			
//		}
//		model.addAttribute("tenBao", list);
//		return 
//	}

	
	@RequestMapping(value = "/chitietdatbao/{maBao}", method = RequestMethod.GET)
	public String layBaoTheoID(@PathVariable int maBao, Model theModel) {
		BaoDto baoDto = BaoService.layBaoTheoID(maBao);
		List<BaoDto> baoDtos = BaoService.layDSBao();
		theModel.addAttribute("bao1", baoDto);
		theModel.addAttribute("baos", baoDtos);
		return "PageChiTietBao";
		
	}
	
	
	@GetMapping("/admin/bao/put/{maBao}")
//	@RequestMapping(value = "/put/{maBao}")
	public String laybaoTheoid(@PathVariable int maBao,Model model) {
		 BaoDto baoDto = BaoService.layBaoTheoID(maBao);
		 model.addAttribute("bao", baoDto);
		 return "PageThemBao";
		 
	}
	@GetMapping("/admin/bao/put")
	public String	laybaoTheoid(Model model) {
		KhuyenMaiDto khuyenMaiDto= new KhuyenMaiDto();
		BaoDto baoDto = new BaoDto();
		 model.addAttribute("bao", baoDto);
		 return "PageThemBao";
	}

	@PostMapping(value = "/admin/bao/addbao", consumes = MediaType.ALL_VALUE)
	public String luuBao(@ModelAttribute("bao") BaoDto baoDto) {
		 BaoService.luuBao(baoDto);
		 return "redirect:/admin/bao/show";
	}

	@PutMapping(value = "/bao", consumes = MediaType.ALL_VALUE)
	public BaoDto luuBao1(@RequestBody BaoDto baoDto) {
		return BaoService.luuBao(baoDto);
	}

//	@DeleteMapping("/bao/{maBao}")
	@RequestMapping(value = "/admin/bao/{maBao}")
	public String xoaBao(@PathVariable int maBao) {
		 BaoService.xoaBao(maBao);
		 return "redirect:/admin/bao/show";
	}
}
