package fit.iuh.edu.datbaogiay.convert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fit.iuh.edu.datbaogiay.dto.KhachHangDto;
import fit.iuh.edu.datbaogiay.entity.KhachHang;
import fit.iuh.edu.datbaogiay.entity.Users;
import fit.iuh.edu.datbaogiay.repository.UsersRepository;
import fit.iuh.edu.datbaogiay.service.UsersService;

@Component
public class KhachHangConvert {
	@Autowired
	private UsersService usersService;
	 public KhachHang chuyenKhachHangEntity(KhachHangDto khachHangDto) {
		 KhachHang khachHang = new KhachHang();
		 if(khachHangDto.getId() != 0) {
			 khachHang.setid(khachHangDto.getId());
		 }
		 
		 khachHang.setHoTen(khachHangDto.getTenKhachHang());
		 khachHang.setEmail(khachHangDto.getEmail());
		 khachHang.setSDT(khachHangDto.getSDT());
		 khachHang.setUsers(usersService.findById(khachHangDto.getMaUser()));
//		 khachHang.setMatKhau(khachHangDto.getMatKhau());

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
		 khachHangDto.setMaUser(khachHang.getUsers().getId());
//		 khachHangDto.setMatKhau(khachHang.getMatKhau());
		 
		 return khachHangDto;
	 }
}