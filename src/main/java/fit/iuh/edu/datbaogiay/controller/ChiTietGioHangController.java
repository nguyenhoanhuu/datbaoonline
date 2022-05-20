package fit.iuh.edu.datbaogiay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fit.iuh.edu.datbaogiay.dto.ChiTietGioHangDto;
import fit.iuh.edu.datbaogiay.entity.ChiTietGioHang;
import fit.iuh.edu.datbaogiay.service.ChiTietDonHangService;
import fit.iuh.edu.datbaogiay.service.ChiTietGioHangService;

@RestController
public class ChiTietGioHangController {
	@Autowired
	private	ChiTietGioHangService chiTietGioHangService;
	
	@GetMapping( value ="/chitietgiohang", consumes = MediaType.ALL_VALUE)
	public List<ChiTietGioHangDto> layDSChiTietGioHang(){
		return chiTietGioHangService.layDSChiTietGioHang();
	}
	
	@PostMapping(value = "/chitietgiohang", consumes = MediaType.ALL_VALUE)
	public ChiTietGioHangDto luuChiTietGioHang(@RequestBody ChiTietGioHangDto chiTietGioHang) {
		return chiTietGioHangService.luuChiTietGioHang(chiTietGioHang);
	}
	
}
