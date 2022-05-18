package fit.iuh.edu.datbaogiay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fit.iuh.edu.datbaogiay.dto.DonHangDTO;
import fit.iuh.edu.datbaogiay.dto.GioHangDto;
import fit.iuh.edu.datbaogiay.dto.NhanVienDto;
import fit.iuh.edu.datbaogiay.service.DonHangService;

@RestController
public class DonHangControllerTest {

	@Autowired
	private DonHangService donHangService;
	
	
	@GetMapping(value = "/donhang1", consumes = MediaType.ALL_VALUE)
	public List<DonHangDTO> layDonHang() {
		return donHangService.layDSDonHang();

	}
	@PostMapping(value = "/donhang2", consumes = MediaType.ALL_VALUE)
	public void luuDonHang(@RequestBody DonHangDTO donHangDTO) {
		donHangService.luuDonHang(donHangDTO);
	}

	@GetMapping("/donhang/{donHangId}")
	public DonHangDTO layDonHangTheoId(@PathVariable int donHangId) {
		DonHangDTO donHangDTO = donHangService.layDonHangTheoId(donHangId);
		return donHangDTO;
	}
}
