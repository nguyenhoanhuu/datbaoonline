package fit.iuh.edu.datbaogiay.convert;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import fit.iuh.edu.datbaogiay.dto.BaoDto;
import fit.iuh.edu.datbaogiay.dto.ChiTietDonHangDTO;
import fit.iuh.edu.datbaogiay.dto.DonHangDTO;
import fit.iuh.edu.datbaogiay.entity.Bao;
import fit.iuh.edu.datbaogiay.entity.ChiTietDonHang;
import fit.iuh.edu.datbaogiay.entity.DonHang;
import fit.iuh.edu.datbaogiay.service.BaoService;
import fit.iuh.edu.datbaogiay.service.DonHangService;

@Component
public class ChiTietDonHangConvert {
	@Autowired
	private BaoConvert baoConvert;
	@Autowired
	private DonHangConvert donHangConvert;
	@Autowired
	private DonHangService donHangService;
	@Autowired
	private BaoService baoService;
	public ChiTietDonHang chuyenChiTietDonHangEntity(ChiTietDonHangDTO chiTietDonHangDTO,int maDonHang) {
			ChiTietDonHang chiTietDonHang = new ChiTietDonHang();
			
			BaoDto baoDto = baoService.layBaoTheoID(chiTietDonHangDTO.getMabao());
			chiTietDonHang.setBao(baoConvert.chuyenBaoEntity(baoDto));
			DonHangDTO donHangDTO = donHangService.layDonHangTheoId(maDonHang);
			chiTietDonHang.setDonHang(donHangConvert.chuyendonHangEntity(donHangDTO));
			chiTietDonHang.setDonHang(chiTietDonHang.getDonHang());
			chiTietDonHang.setNgayDatBao(chiTietDonHangDTO.getNgayDatBao());
			chiTietDonHang.setNgatKetThucDatBao(chiTietDonHangDTO.getNgatKetThucDatBao());
			chiTietDonHang.setSoLuong(chiTietDonHangDTO.getSoLuong());
			chiTietDonHang.setSoKy(chiTietDonHangDTO.getSoKy());
		return chiTietDonHang;
	}
	
	public ChiTietDonHangDTO chuyenChiTietDonHangDto(ChiTietDonHang chiTietDonHang) {
					ChiTietDonHangDTO chiTietDonHangDTO = new ChiTietDonHangDTO();
					
					chiTietDonHangDTO.setMadonHang(chiTietDonHang.getDonHang().getid());
					chiTietDonHangDTO.setMabao(chiTietDonHang.getBao().getid());
					chiTietDonHangDTO.setTenBao(chiTietDonHang.getBao().getTenBao());
					chiTietDonHangDTO.setNgayDatBao(chiTietDonHang.getNgayDatBao());
					chiTietDonHangDTO.setNgatKetThucDatBao(chiTietDonHang.getNgatKetThucDatBao());
					chiTietDonHangDTO.setSoLuong(chiTietDonHang.getSoLuong());
					chiTietDonHangDTO.setSoKy(chiTietDonHang.getSoKy());
					chiTietDonHangDTO.setThanhTien(chiTietDonHang.getBao().getDonGia()*chiTietDonHang.getSoKy()*chiTietDonHang.getSoLuong());
				

		
		return chiTietDonHangDTO;
	}
}