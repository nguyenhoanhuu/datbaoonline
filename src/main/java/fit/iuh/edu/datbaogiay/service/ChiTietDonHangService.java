package fit.iuh.edu.datbaogiay.service;

import java.util.List;

import fit.iuh.edu.datbaogiay.entity.ChiTietDonHang;
import fit.iuh.edu.datbaogiay.entity.ChiTietDonHangPk;

public interface ChiTietDonHangService {

	public List<ChiTietDonHang> layDSChiTietDonHang();
	public ChiTietDonHang layChiTietDonHangTheoid(ChiTietDonHangPk id);
	public String XoaChiTietDonHang(ChiTietDonHang id );
	public ChiTietDonHang luuChitietDonHang(ChiTietDonHang chiTietDonHang);
}
