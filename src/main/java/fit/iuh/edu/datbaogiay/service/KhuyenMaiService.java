package fit.iuh.edu.datbaogiay.service;

import java.util.List;

import fit.iuh.edu.datbaogiay.dto.KhuyenMaiDto;


public interface KhuyenMaiService {

	public List<KhuyenMaiDto> layDSKhuyenMai();
	public String xoaKhuyenMai(int id) ;
	public KhuyenMaiDto layKhuyenMaiTheoid(int id);
	public KhuyenMaiDto themKhuyenMai(KhuyenMaiDto khuyenMaiDto);
}
