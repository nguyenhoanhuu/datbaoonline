package fit.iuh.edu.datbaogiay.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fit.iuh.edu.datbaogiay.dto.DonHangDTO;
import fit.iuh.edu.datbaogiay.dto.KhuyenMaiDto;
import fit.iuh.edu.datbaogiay.entity.Bao;
import fit.iuh.edu.datbaogiay.entity.Day;
import fit.iuh.edu.datbaogiay.entity.DonHang;
import fit.iuh.edu.datbaogiay.service.DonHangService;
import fit.iuh.edu.datbaogiay.service.UsersService;

@Controller
//@RequestMapping("/admin/donHang")
public class DonHangController {

	private DonHangService donHangService;
	private static double tongtien;
	private Day day;
	@Autowired
	private UsersService usersService;
	public DonHangController(DonHangService donHangService) {
		super();
		this.donHangService = donHangService;
	}
	@PreAuthorize("hasAuthority('EMPLOYEE')")
	@GetMapping(value = "/admin/donHang/show", consumes = MediaType.ALL_VALUE)
	public String layDSDonHang(Model model){
		
		List<DonHangDTO>  donHangDTOs =  donHangService.layDSDonHang();
		model.addAttribute("dsDonHang", donHangDTOs);
		return "PageQuanLyHoaDon";
		
	}
	@PreAuthorize("hasAuthority('EMPLOYEE')")
	@GetMapping("/admin/donHang/put/{madonhang}")
	public String layDonHangTheoId(@PathVariable int  madonhang,Model model) {
		
		DonHangDTO donHangDTO = donHangService.layDonHangTheoId(madonhang);
		model.addAttribute("donhang", donHangDTO);
		model.addAttribute("chitietdonhang", donHangDTO.getChiTietDonHang());
		return "PageChiTietDonHang";
	}
	@PreAuthorize("hasAuthority('EMPLOYEE')")
	@GetMapping("/admin/donHang/doanhThu/put/{madonhang}")
	public String layDonHangTheoId1(@PathVariable int  madonhang,Model model) {
		
		DonHangDTO donHangDTO = donHangService.layDonHangTheoId(madonhang);
		model.addAttribute("donhang", donHangDTO);
		model.addAttribute("chitietdonhang", donHangDTO.getChiTietDonHang());
		return "PageChiTietDonHang";
	}
//	@PostMapping(value = "/donhang", consumes = MediaType.ALL_VALUE)
//	public DonHangDTO luuDonHang(@RequestBody DonHangDTO donHangDTO) {
//		return donHangService.luuDonHang(donHangDTO);
//	}
//	@PutMapping(value = "/donhang", consumes = MediaType.ALL_VALUE)
//	public DonHangDTO luuDonHang1(@RequestBody DonHangDTO donHangDTO) {
//		return donHangService.luuDonHang(donHangDTO);
//	}

	@DeleteMapping("/donhang/{madonhang}")
	public String xoaDonHang(@PathVariable int  madonhang) {
		return donHangService.xoaDonHang(madonhang);
	}
	@PreAuthorize("hasAuthority('EMPLOYEE')")
	@GetMapping(value = "/admin/donHang/doanhThu/show", consumes = MediaType.ALL_VALUE)
		public String layDSDonHang1(Model model){
			tongtien = 0;
			List<DonHangDTO>  donHangDTOs =  donHangService.layDSDonHang();
			donHangDTOs.forEach(donhang->{
				tongtien+=donhang.getTongTienDonHang();
			});
			day = new Day();
			model.addAttribute("tongtien", tongtien);
			model.addAttribute("dsDonHang", donHangDTOs);
			model.addAttribute("day", day);
			return "PageQuanLyDoanhThu";
	}
	
	@PreAuthorize("hasAuthority('EMPLOYEE')")
	@GetMapping(value = "/admin/donHang/test", consumes = MediaType.ALL_VALUE)
	public String test(@ModelAttribute("day") Day day,Model model) {
		tongtien = 0;
		 List<DonHangDTO> donHangDTOs = donHangService.finddonhang(day.getNam(),day.getThang(),day.getNgay());
			donHangDTOs.forEach(donhang->{
				tongtien+=donhang.getTongTienDonHang();
			});
			model.addAttribute("dsDonHang", donHangDTOs);
			model.addAttribute("tongtien", tongtien);
			return "PageQuanLyDoanhThu";
	}
	
	
	// trang tổng kết đơn hàng
	@GetMapping("/tongdonhang/{madonhang}")
	public String layVuaTaoDonHangTheoId(@PathVariable int  madonhang,Model model) {
		
		DonHangDTO donHangDTO = donHangService.layDonHangTheoId(madonhang);
		model.addAttribute("donhang", donHangDTO);
		return "PageTongKetDonHang";
	}
}
