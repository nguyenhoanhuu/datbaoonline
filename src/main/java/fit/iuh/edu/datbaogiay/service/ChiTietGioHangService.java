package fit.iuh.edu.datbaogiay.service;

import java.util.List;

import fit.iuh.edu.datbaogiay.dto.ChiTietGioHangDto;
import fit.iuh.edu.datbaogiay.entity.ChiTietGioHang;
import fit.iuh.edu.datbaogiay.entity.ChiTietGioHangPk;

public interface ChiTietGioHangService {
	public List<ChiTietGioHangDto> layDSChiTietGioHang();
	public String xoaChiTietGioHang(ChiTietGioHangPk chiTietGioHangId);

	public ChiTietGioHangDto layChiTietGioHangTheoId(int id);
	public ChiTietGioHangDto luuChiTietGioHang(ChiTietGioHangDto chiTietGioHangDto);
}
