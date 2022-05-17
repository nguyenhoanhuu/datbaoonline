package fit.iuh.edu.datbaogiay.convert;

import org.springframework.stereotype.Component;

import fit.iuh.edu.datbaogiay.dto.KhachHangDto;
import fit.iuh.edu.datbaogiay.entity.KhachHang;

@Component
public class KhachHangConvert {
	 public KhachHang chuyenKhachHangEntity(KhachHangDto khachHangDto) {
		 KhachHang khachHang = new KhachHang();
		 if(khachHangDto.getId() != 0) {
			 khachHang.setid(khachHangDto.getId());
		 }
		 
		 khachHang.setHoTen(khachHangDto.getTenKhachHang());
		 khachHang.setEmail(khachHangDto.getEmail());
		 khachHang.setSDT(khachHangDto.getSDT());
		 khachHang.setMatKhau(khachHangDto.getMatKhau());

		 return khachHang;
		 
	 }
	 
	 public KhachHangDto chuyenKhachHangDto(KhachHang khachHang) {
		 KhachHangDto khachHangDto = new KhachHangDto();
		 
		 if(khachHang.getid() != 0) {
			 khachHangDto.setId(khachHang.getid());
		 }
		 
		 khachHangDto.setTenKhachHang(khachHang.getHoTen());
		 khachHangDto.setEmail(khachHang.getEmail());
		 khachHangDto.setSDT(khachHang.getSDT());
		 khachHangDto.setMatKhau(khachHang.getMatKhau());
		 
		 return khachHangDto;
	 }
}
