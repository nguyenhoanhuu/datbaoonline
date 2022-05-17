package fit.iuh.edu.datbaogiay.convert;

import java.util.ArrayList;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fit.iuh.edu.datbaogiay.dto.BaoDto;
import fit.iuh.edu.datbaogiay.dto.ChiTietGioHangDto;
import fit.iuh.edu.datbaogiay.dto.GioHangDto;
import fit.iuh.edu.datbaogiay.entity.Bao;
import fit.iuh.edu.datbaogiay.entity.ChiTietGioHang;
import fit.iuh.edu.datbaogiay.entity.GioHang;
import fit.iuh.edu.datbaogiay.entity.KhachHang;
import fit.iuh.edu.datbaogiay.service.KhachHangService;

@Component
public class GioHangConvert {
	@Autowired
	private KhachHangService khachHangService;
	@Autowired
	private KhachHangConvert khachHangConvert;
	@Autowired
	private ChiTietGioHangConvert chiTietGioHangConvert;

	public GioHang chuyenGioHangEntity(GioHangDto gioHangDto) {
		GioHang gioHang = new GioHang();
		if (gioHangDto.getId() != 0) {
			gioHang.setid(gioHangDto.getId());
		}
		gioHang.setKhachHang(khachHangConvert
				.chuyenKhachHangEntity(khachHangService.layKhachHangTheoId(gioHangDto.getKhachHangId())));
		gioHang.setNgayTaoGioHang(gioHangDto.getNgayTaoGioHang());
		Set<ChiTietGioHang> chiTietGioHangs = new HashSet<ChiTietGioHang>();
		gioHang.setDsChiTietGioHang(chiTietGioHangs);
		return gioHang;
	}

	
	
	public GioHangDto chuyenGioHangDto(GioHang gioHang ,List<Bao> baos2) {
		GioHangDto gioHangDto = GioHangDto.builder()
				.khachHangId(gioHang.getKhachHang().getid())
				.ngayTaoGioHang(gioHang.getNgayTaoGioHang())
				.build();
		
		if (gioHang.getid() != 0) {
			gioHangDto.setId(gioHang.getid());
		}
		
		Set<ChiTietGioHangDto> chiTietGioHangDtos = new HashSet<ChiTietGioHangDto>();
		gioHang.getDsChiTietGioHang().forEach(a -> {
			chiTietGioHangDtos.add(chiTietGioHangConvert.chuyenChiTietGioHangDto(a,baos2));
		});
		gioHangDto.setChiTietGioHang(chiTietGioHangDtos);
		return gioHangDto;
	}
}
