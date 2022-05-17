package fit.iuh.edu.datbaogiay.convert;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fit.iuh.edu.datbaogiay.dto.BaoDto;
import fit.iuh.edu.datbaogiay.dto.ChiTietGioHangDto;
import fit.iuh.edu.datbaogiay.dto.GioHangDto;
import fit.iuh.edu.datbaogiay.entity.Bao;
import fit.iuh.edu.datbaogiay.entity.ChiTietGioHang;
import fit.iuh.edu.datbaogiay.entity.ChiTietGioHangPk;
import fit.iuh.edu.datbaogiay.entity.GioHang;
import fit.iuh.edu.datbaogiay.service.BaoService;
import fit.iuh.edu.datbaogiay.service.GioHangService;

@Component
public class ChiTietGioHangConvert {

	@Autowired
	private BaoConvert baoConvert;
	@Autowired
	private BaoService baoService;

	@Autowired
	private GioHangConvert gioHangConvert;

	@Autowired
	GioHangService gioHangService;

	public ChiTietGioHang chuyenChiTietGioHangEntity(ChiTietGioHangDto chiTietGioHangDto) {
		ChiTietGioHang chiTietGioHang = new ChiTietGioHang();
		
		
		
		BaoDto baoDto = baoService.layBaoTheoID(chiTietGioHangDto.getBaoId());
		chiTietGioHang.setBao(baoConvert.chuyenBaoEntity(baoDto));
		
		GioHangDto gioHangDto = gioHangService.layGioHangTheoId(chiTietGioHangDto.getGioHangId());
		chiTietGioHang.setGioHang(gioHangConvert.chuyenGioHangEntity(gioHangDto));
		
	
		ChiTietGioHangPk chiTietGioHangPk = new ChiTietGioHangPk(chiTietGioHangDto.getBaoId(), chiTietGioHangDto.getGioHangId());
		
				chiTietGioHang.setId(chiTietGioHangPk);
		
		chiTietGioHang.setNgayDatBao(chiTietGioHangDto.getNgayDatBao());
		chiTietGioHang.setNgayKetThucDatBao(chiTietGioHangDto.getNgaytKetThucDatBao());
		chiTietGioHang.setSoKy(chiTietGioHangDto.getSoKy());
		chiTietGioHang.setSoLuong(chiTietGioHangDto.getSoLuong());
		
		
		return chiTietGioHang;
	}

	public ChiTietGioHangDto chuyenChiTietGioHangDto(ChiTietGioHang chiTietGioHang, List<Bao>  baos2) {
		ChiTietGioHangDto chiTietGioHangDto = new ChiTietGioHangDto();
		
		ChiTietGioHangPk chiTietGioHangPk = new ChiTietGioHangPk(chiTietGioHang.getBao().getid(), chiTietGioHang.getGioHang().getid());
		chiTietGioHangDto.setId(chiTietGioHangPk);
		
		chiTietGioHangDto.setBaoId(chiTietGioHang.getBao().getid());
		chiTietGioHangDto.setGioHangId(chiTietGioHang.getGioHang().getid());
		chiTietGioHangDto.setNgayDatBao(chiTietGioHang.getNgayDatBao());
		chiTietGioHangDto.setNgaytKetThucDatBao(chiTietGioHang.getNgayKetThucDatBao());
		chiTietGioHangDto.setSoKy(chiTietGioHang.getSoKy());
		chiTietGioHangDto.setSoLuong(chiTietGioHang.getSoLuong());
		
		chiTietGioHangDto.setDonGia(chiTietGioHang.getBao().getDonGia());
		chiTietGioHangDto.setTenBao(chiTietGioHang.getBao().getTenBao());
		chiTietGioHangDto.setThanhTien(chiTietGioHang.getBao().getDonGia()*chiTietGioHang.getSoKy()*chiTietGioHang.getSoLuong());
		
		return chiTietGioHangDto;

	}
}
