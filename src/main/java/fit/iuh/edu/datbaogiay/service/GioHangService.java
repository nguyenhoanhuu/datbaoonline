package fit.iuh.edu.datbaogiay.service;

import java.util.List;

import fit.iuh.edu.datbaogiay.dto.GioHangDto;
import fit.iuh.edu.datbaogiay.dto.XoaChiTietGioHangDto;
import fit.iuh.edu.datbaogiay.entity.DonHang;
import fit.iuh.edu.datbaogiay.entity.GioHang;

public interface GioHangService {
		public List<GioHangDto> layDSGioHang();
		public GioHangDto layGioHangTheoId(int id);
		public String  xoaGioHang(int id);
		public void luuGioHang(GioHangDto gioHangDto);
		public void themBaoVaoGioHang(GioHangDto gioHangDto);
		public void xoaChiTietGioHang(XoaChiTietGioHangDto xoaChiTietGioHangDto);
}
