package fit.iuh.edu.datbaogiay.service;

import java.security.Principal;
import java.util.List;

import fit.iuh.edu.datbaogiay.dto.DonHangDTO;
import fit.iuh.edu.datbaogiay.entity.Bao;
import fit.iuh.edu.datbaogiay.entity.DonHang;

public interface DonHangService {
	public List<DonHangDTO> layDSDonHang();
	public DonHangDTO layDonHangTheoId(int id);
	public String xoaDonHang(int id);
	public Integer luuDonHang(DonHangDTO donHangDTO, Principal principal);
	List<DonHangDTO> finddonhang(int year, int month, int day);
	
}
