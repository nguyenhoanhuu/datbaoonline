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

import fit.iuh.edu.datbaogiay.entity.Bao;
import fit.iuh.edu.datbaogiay.entity.ChiTietDonHang;
import fit.iuh.edu.datbaogiay.entity.ChiTietDonHangPk;
import fit.iuh.edu.datbaogiay.entity.DonHang;
import fit.iuh.edu.datbaogiay.service.BaoService;
import fit.iuh.edu.datbaogiay.service.ChiTietDonHangService;
import fit.iuh.edu.datbaogiay.service.DonHangService;

@RestController
@RequestMapping("/api")
public class ChiTietDonHangController {

	private ChiTietDonHangService chiTietDonHangService;
	private DonHangService donHangService;
	private BaoService baoService;

	public ChiTietDonHangController(ChiTietDonHangService chiTietDonHangService, DonHangService donHangService,
			BaoService baoService) {
		super();
		this.chiTietDonHangService = chiTietDonHangService;
		this.donHangService = donHangService;
		this.baoService = baoService;
	}

	@GetMapping("/chitietdonhang")
	public List<ChiTietDonHang> layDSDonHang(){
		return chiTietDonHangService.layDSChiTietDonHang();
	}

	@PutMapping(value = "/chitietdonhang", consumes = MediaType.ALL_VALUE)
	public ChiTietDonHang luuChiTietDonHan1(@RequestBody ChiTietDonHang chiTietDonHang) {
		return chiTietDonHangService.luuChitietDonHang(chiTietDonHang);
	}
}
