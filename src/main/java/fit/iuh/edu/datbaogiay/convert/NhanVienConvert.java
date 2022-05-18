package fit.iuh.edu.datbaogiay.convert;

import org.springframework.stereotype.Component;

import fit.iuh.edu.datbaogiay.dto.NhanVienDto;

import fit.iuh.edu.datbaogiay.entity.NhanVien;
@Component
public class NhanVienConvert {
	public NhanVien toNhanVienEntity(NhanVienDto nhanVienDto) {
		NhanVien nhanVien = new NhanVien();
		
		if(nhanVienDto.getId() != 0) {
			nhanVien.setid(nhanVienDto.getId());
		}
		
		nhanVien.setTenNhanVien(nhanVienDto.getTenNhanVien());
		nhanVien.setSDT(nhanVienDto.getSDT());
		nhanVien.setDiaChi(nhanVienDto.getDiaChi());
//		nhanVien.setEmail(nhanVienDto.getEmail());
//		nhanVien.setMatKhau(nhanVienDto.getMatKhau());
	
		
		return nhanVien;
	}
	
	public  NhanVienDto tonhanVienDto(NhanVien nhanVien) {
		NhanVienDto nhanVienDto = new NhanVienDto();
		
		if(nhanVien.getid() != 0) {
			nhanVienDto.setId(nhanVien.getid());
		}
		
		nhanVienDto.setTenNhanVien(nhanVien.getTenNhanVien());
		nhanVienDto.setSDT(nhanVien.getSDT());
		nhanVienDto.setDiaChi(nhanVien.getDiaChi());
//		nhanVienDto.setEmail(nhanVien.getEmail());
//		nhanVienDto.setMatKhau(nhanVien.getMatKhau());
		return nhanVienDto;
	}
}
