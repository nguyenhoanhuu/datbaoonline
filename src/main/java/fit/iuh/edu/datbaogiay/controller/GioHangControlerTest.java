package fit.iuh.edu.datbaogiay.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fit.iuh.edu.datbaogiay.dto.GioHangDto;
import fit.iuh.edu.datbaogiay.dto.XoaChiTietGioHangDto;
import fit.iuh.edu.datbaogiay.entity.GioHang;
import fit.iuh.edu.datbaogiay.entity.Users;
import fit.iuh.edu.datbaogiay.repository.GioHangRepository;
import fit.iuh.edu.datbaogiay.service.GioHangService;
import fit.iuh.edu.datbaogiay.service.UsersService;

@RestController
public class GioHangControlerTest {
	@Autowired
	private GioHangService gioHangService;
	@Autowired
	private UsersService usersService;
	@Autowired
	private GioHangRepository gioHangRepository;

	@GetMapping(value = "/giohangtest/{gioHangId}", consumes = MediaType.ALL_VALUE)
	public GioHangDto layGioHangTheoId(@PathVariable int gioHangId) {
		return gioHangService.layGioHangTheoId(gioHangId);

	}

	@PostMapping(value = "/giohang1", consumes = MediaType.ALL_VALUE)
	public void luuGioHang(@RequestBody GioHangDto gioHangDto) {
		gioHangService.luuGioHang(gioHangDto);
	}

//	@PostMapping(value = "/giohang2", consumes = MediaType.ALL_VALUE)
//	@RequestMapping(value="/giohang2", method=RequestMethod.POST)
//	@ResponseBody
//	@PreAuthorize("#gioHangDto.author.name == #principal.name")
//	public void themBaoVaoGioHang(@RequestBody GioHangDto gioHangDto, Principal principal) {
//		Users users = usersService.getByUsername(principal.getName());
//		users.getId();
//		GioHang gioHang = gioHangRepository.findByUsersId(users.getId());
//		gioHangService.themBaoVaoGioHang(gioHangDto);
//	}
//	

	@PostMapping(value = "/giohang2", consumes = MediaType.ALL_VALUE)
	public void themBaoVaoGioHang(@RequestBody GioHangDto gioHangDto) {
		gioHangService.themBaoVaoGioHang(gioHangDto);
	}

	@PostMapping(value = "/giohang3", consumes = MediaType.ALL_VALUE)
	public void xoaChiTietGiohang(@RequestBody XoaChiTietGioHangDto xoaChiTietGioHangDto) {
		gioHangService.xoaChiTietGioHang(xoaChiTietGioHangDto);
	}
}
