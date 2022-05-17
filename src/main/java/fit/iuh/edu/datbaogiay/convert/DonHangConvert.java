package fit.iuh.edu.datbaogiay.convert;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fit.iuh.edu.datbaogiay.dto.ChiTietDonHangDTO;
import fit.iuh.edu.datbaogiay.dto.DonHangDTO;
import fit.iuh.edu.datbaogiay.dto.KhachHangDto;
import fit.iuh.edu.datbaogiay.entity.ChiTietDonHang;
import fit.iuh.edu.datbaogiay.entity.DonHang;
import fit.iuh.edu.datbaogiay.entity.KhachHang;
import fit.iuh.edu.datbaogiay.entity.KhuyenMai;
import fit.iuh.edu.datbaogiay.service.KhachHangService;
import fit.iuh.edu.datbaogiay.service.KhuyenMaiService;

@Component
public class DonHangConvert {
	@Autowired
	private KhachHangService khachHangService;
	@Autowired
	private KhachHangConvert khachHangConvert;
	@Autowired
	private KhuyenMaiConvert khuyenMaiConvert;
	@Autowired
	private KhuyenMaiService khuyenMaiService;
	@Autowired
	private ChiTietDonHangConvert chiTietDonHangConvert;

	public DonHang chuyendonHangEntity(DonHangDTO donHangDTO) {

		DonHang donHang = new DonHang();
		if (donHangDTO.getId() != 0) {
			donHang.setid(donHangDTO.getId());
		}
		KhachHang khachHang = khachHangConvert
				.chuyenKhachHangEntity(khachHangService.layKhachHangTheoId(donHangDTO.getMaKhachHang()));
		donHang.setKhachHang(khachHang);
		donHang.setKhuyenMai(khuyenMaiConvert
				.chuyenKhuyenMaiEntity(khuyenMaiService.layKhuyenMaiTheoid(donHangDTO.getMaKhuyenMai())));
		donHang.setNgayTaoDonHang(donHangDTO.getNgayTaoDonHang());
		donHang.setTrangThaiDonHang(donHangDTO.getTrangThaiDonHang());
		donHang.setDiaChiNhanHang(donHangDTO.getDiaChiNhanHang());
		donHang.setTongTienDonHang(donHangDTO.getTongTienDonHang());
		donHang.setHinhThucThanhToan(donHangDTO.getHinhThucThanhToan());
//		donHang.setChiTietDonHang(chiTietDonHangConvert.chuyenChiTietDonHangEntity(donHangDTO.getChiTietDonHang()));
//		donHang.setChiTietDonHang(null);
		Set<ChiTietDonHang> chiTietDonHangs = new HashSet<ChiTietDonHang>();
//		donHangDTO.getChiTietDonHang().forEach(a->{
//			chiTietDonHangs.add( chiTietDonHangConvert.chuyenChiTietDonHangEntity(a));
//			
//		});
		donHang.setChiTietDonHang(chiTietDonHangs);

		return donHang;
	}

	public DonHangDTO chuyendonHangDTO(DonHang donHang) {
		DonHangDTO donHangDTO = DonHangDTO.builder()
				.maKhachHang(donHang.getKhachHang().getid())
				.tenKhachHang(donHang.getKhachHang().getHoTen())
				.SDT(donHang.getKhachHang().getSDT())
				.maKhuyenMai(donHang.getKhuyenMai().getid())
				.tenKhuyenMai(donHang.getKhuyenMai().getTenKhuyenMai())
				.ngayTaoDonHang(donHang.getNgayTaoDonHang())
				.trangThaiDonHang(donHang.getTrangThaiDonHang())
				.diaChiNhanHang(donHang.getDiaChiNhanHang())
				.tongTienDonHang(donHang.getTongTienDonHang())
				.hinhThucThanhToan(donHang.getHinhThucThanhToan())
				.build();
		
		if (donHang.getid() != 0) {
			donHangDTO.setId(donHang.getid());
		}
		
		Set<ChiTietDonHangDTO> chiTietDonHangDTOs = new HashSet<ChiTietDonHangDTO>();
		donHang.getChiTietDonHang().forEach(a -> {
			chiTietDonHangDTOs.add(chiTietDonHangConvert.chuyenChiTietDonHangDto(a));

		});
		donHangDTO.setChiTietDonHang(chiTietDonHangDTOs);
		return donHangDTO;
	}
}