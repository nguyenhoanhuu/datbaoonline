package fit.iuh.edu.datbaogiay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fit.iuh.edu.datbaogiay.dto.NhanVienDto;
import fit.iuh.edu.datbaogiay.entity.NhanVien;
import fit.iuh.edu.datbaogiay.service.NhanVienService;

@RestController
public class NhanVienController {
	@Autowired
	private NhanVienService nhanVienService;

	@PreAuthorize("hasRole('ROLE_EMPLOYEE')")
	@GetMapping("/nhanVien/{nhanVienId}")
	public NhanVienDto getCustomer(@PathVariable int nhanVienId) {
		NhanVienDto nhanVienDto = nhanVienService.layNhanVienTheoid(nhanVienId);
		return nhanVienDto;
	}

}
