package fit.iuh.edu.datbaogiay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fit.iuh.edu.datbaogiay.dto.GioHangDto;
import fit.iuh.edu.datbaogiay.service.GioHangService;
@Controller
public class GioHangController {
	@Autowired
	private GioHangService gioHangService;

//	public GioHangController(GioHangService gioHangService) {
//		super();
//		this.gioHangService = gioHangService;
//	}

	@GetMapping( value = "/giohang", consumes = MediaType.ALL_VALUE)
	public List<GioHangDto> layDSGioHang(){
		return gioHangService.layDSGioHang();
	}
	
	@PostMapping(value = "/giohang", consumes = MediaType.ALL_VALUE)
	public void luuGioHang(@RequestBody GioHangDto gioHangDto) {
		 gioHangService.luuGioHang(gioHangDto);
	}
	
	@DeleteMapping("/giohang/{gioHangId}")
	public String xoaGioHang(@PathVariable int  gioHangId) {
		return gioHangService.xoaGioHang(gioHangId);
	}
	
	@GetMapping("/giohang/{gioHangId}")
	public String layGioHangTheoID(@PathVariable int gioHangId , Model theModel) {
		GioHangDto gioHangDtos=  gioHangService.layGioHangTheoId(gioHangId);
		
		theModel.addAttribute("giohangId",gioHangDtos );
		return "PageGioHang";
	}
	
	
	
}
