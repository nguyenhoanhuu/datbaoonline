package fit.iuh.edu.datbaogiay.controller;


import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fit.iuh.edu.datbaogiay.dto.DonHangDTO;
import fit.iuh.edu.datbaogiay.entity.Bao;
import fit.iuh.edu.datbaogiay.entity.DonHang;
import fit.iuh.edu.datbaogiay.service.DonHangService;

@RestController
@RequestMapping("/api")
public class DonHangController {

	private DonHangService donHangService;

	public DonHangController(DonHangService donHangService) {
		super();
		this.donHangService = donHangService;
	}
	
	@GetMapping("/donhang")
	public List<DonHangDTO> layDSDonHang(){
		
		return donHangService.layDSDonHang();
	}
	@GetMapping("/donhang/{madonhang}")
	public DonHangDTO layDonHangTheoId(@PathVariable int  madonhang) {
		return donHangService.layDonHangTheoId(madonhang);
	}
	@PostMapping(value = "/donhang", consumes = MediaType.ALL_VALUE)
	public DonHangDTO luuDonHang(@RequestBody DonHangDTO donHangDTO) {
		return donHangService.luuDonHang(donHangDTO);
	}
	@PutMapping(value = "/donhang", consumes = MediaType.ALL_VALUE)
	public DonHangDTO luuDonHang1(@RequestBody DonHangDTO donHangDTO) {
		return donHangService.luuDonHang(donHangDTO);
	}
	@DeleteMapping("/donhang/{madonhang}")
	public String xoaDonHang(@PathVariable int  madonhang) {
		return donHangService.xoaDonHang(madonhang);
	}
}
