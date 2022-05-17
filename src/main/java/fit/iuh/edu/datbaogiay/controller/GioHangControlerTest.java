package fit.iuh.edu.datbaogiay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fit.iuh.edu.datbaogiay.dto.BaoDto;
import fit.iuh.edu.datbaogiay.dto.GioHangDto;
import fit.iuh.edu.datbaogiay.dto.XoaChiTietGioHangDto;
import fit.iuh.edu.datbaogiay.service.GioHangService;

@RestController
public class GioHangControlerTest {
	@Autowired
	private GioHangService gioHangService;

	@GetMapping(value = "/giohangtest/{gioHangId}", consumes = MediaType.ALL_VALUE)
	public GioHangDto layGioHangTheoId(@PathVariable int gioHangId) {
		return gioHangService.layGioHangTheoId(gioHangId);

	}

	@PostMapping(value = "/giohang1", consumes = MediaType.ALL_VALUE)
	public void luuGioHang(@RequestBody GioHangDto gioHangDto) {
		gioHangService.luuGioHang(gioHangDto);
	}

	@PostMapping(value = "/giohang2", consumes = MediaType.ALL_VALUE)
	public void themBaoVaoGioHang(@RequestBody GioHangDto gioHangDto) {
		gioHangService.themBaoVaoGioHang(gioHangDto);
	}

	@PostMapping(value = "/giohang3", consumes = MediaType.ALL_VALUE)
	public void xoaChiTietGiohang(@RequestBody XoaChiTietGioHangDto xoaChiTietGioHangDto) {
		gioHangService.xoaChiTietGioHang(xoaChiTietGioHangDto);
	}
}
