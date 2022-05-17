package fit.iuh.edu.datbaogiay.service;

import java.util.List;

import fit.iuh.edu.datbaogiay.dto.KhachHangDto;
import fit.iuh.edu.datbaogiay.entity.KhachHang;

public interface KhachHangService {
	public List<KhachHangDto> layDSKhachHang();

	public KhachHangDto themKhachHang(KhachHangDto khachHangDto);

	public KhachHangDto layKhachHangTheoId(int id);

	public String xoaKhachHangTheoId(int id);
	
	public void suaKhachHang( int id,KhachHangDto khachHangDto);
}
