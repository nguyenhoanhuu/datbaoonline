package fit.iuh.edu.datbaogiay.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fit.iuh.edu.datbaogiay.entity.ChiTietDonHang;
import fit.iuh.edu.datbaogiay.entity.ChiTietDonHangPk;
import fit.iuh.edu.datbaogiay.repository.ChiTietDonHangRepository;
import fit.iuh.edu.datbaogiay.service.ChiTietDonHangService;
@Service
public class ChiTietDonHangImpl implements ChiTietDonHangService{

	private ChiTietDonHangRepository chiTietDonHangRepository;
	
	public ChiTietDonHangImpl(ChiTietDonHangRepository chiTietDonHangRepository) {
		super();
		this.chiTietDonHangRepository = chiTietDonHangRepository;
	}

	@Override
	public List<ChiTietDonHang> layDSChiTietDonHang() {
		return chiTietDonHangRepository.findAll();
	}

	@Override
	public ChiTietDonHang layChiTietDonHangTheoid(ChiTietDonHangPk id) {
		return chiTietDonHangRepository.getById(id);
	}

	@Override
	public String XoaChiTietDonHang(ChiTietDonHang id) {
//		 chiTietDonHangRepository.deleteById(id);
		 chiTietDonHangRepository.delete(id);
		 return "Xóa thành công ";
	}

	@Override
	public ChiTietDonHang luuChitietDonHang(ChiTietDonHang chiTietDonHang) {
		return chiTietDonHangRepository.save(chiTietDonHang);
	}

}
