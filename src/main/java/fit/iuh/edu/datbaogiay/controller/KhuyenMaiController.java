package fit.iuh.edu.datbaogiay.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fit.iuh.edu.datbaogiay.dto.KhuyenMaiDto;
import fit.iuh.edu.datbaogiay.entity.Users;
import fit.iuh.edu.datbaogiay.service.KhuyenMaiService;
import fit.iuh.edu.datbaogiay.service.NhanVienService;
import fit.iuh.edu.datbaogiay.service.UsersService;

@Controller
@RequestMapping("/admin/khuyenMai")
public class KhuyenMaiController {
	@Autowired
	private KhuyenMaiService KhuyenMaiService;
	@Autowired
	private NhanVienService nhanVienService;
	@Autowired
	private UsersService usersService;

	@PreAuthorize("hasAuthority('EMPLOYEE')")
	@GetMapping("/show")
	public String listKhuyenMai(Model theModel) {
		List<KhuyenMaiDto> khuyenMaiDtos = KhuyenMaiService.layDSKhuyenMai();
		List<String> tenNVs = new ArrayList<String>();
		theModel.addAttribute("khuyenMai", khuyenMaiDtos);
		return "PageQuanLyKhuyenMai";
	}

	@PreAuthorize("hasAuthority('EMPLOYEE')")
	@GetMapping("/khuyenMai")
	public List<KhuyenMaiDto> layDSBao() {
		return KhuyenMaiService.layDSKhuyenMai();
	}

	@PreAuthorize("hasAuthority('EMPLOYEE')")
//		@DeleteMapping("/khuyenMai/{maKhuyenMai}")
	@RequestMapping(value = "/{maKhuyenMai}")
	public String xoaKhuyenMai(@PathVariable int maKhuyenMai) {
		KhuyenMaiService.xoaKhuyenMai(maKhuyenMai);
		return "redirect:/admin/khuyenMai/show";
	}

	@PreAuthorize("hasAuthority('EMPLOYEE')")
	@GetMapping("/put/{maKhuyenMai}")
//		@RequestMapping(value = "/put/{maKhuyenMai}")
	public String layKhuyenMaiTheoid(@PathVariable int maKhuyenMai, Model model) {
		KhuyenMaiDto khuyenMaiDto = KhuyenMaiService.layKhuyenMaiTheoid(maKhuyenMai);
		model.addAttribute("khuyenmai", khuyenMaiDto);
		return "PageThemKhuyenMai";

	}

	@PreAuthorize("hasAuthority('EMPLOYEE')")
	@GetMapping("/put")
	public String themKhuyenMai2(Model model, Principal principal) {
		Users users = usersService.getByUsername(principal.getName());
		KhuyenMaiDto khuyenMaiDto = new KhuyenMaiDto(users.getNhanVien().getid());
		model.addAttribute("khuyenmai", khuyenMaiDto);
		return "PageThemKhuyenMai";
	}

// 		@PutMapping("/addKhuyenMai")
//		public KhuyenMaiDto themKhuyenMai(@RequestBody KhuyenMaiDto khuyenMaiDto) {
//			 return KhuyenMaiService.themKhuyenMai(khuyenMaiDto);
//		}
	@PreAuthorize("hasAuthority('EMPLOYEE')")
	@PostMapping(value = "/addKhuyenMai", consumes = MediaType.ALL_VALUE)
	public String themKhuyenMai1(@ModelAttribute("khuyenmai") KhuyenMaiDto khuyenMaiDto) {
		KhuyenMaiService.themKhuyenMai(khuyenMaiDto);
		return "redirect:/admin/khuyenMai/show";
	}
}
