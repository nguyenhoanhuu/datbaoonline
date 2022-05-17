package fit.iuh.edu.datbaogiay.convert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fit.iuh.edu.datbaogiay.dto.KhuyenMaiDto;
import fit.iuh.edu.datbaogiay.entity.KhuyenMai;
import fit.iuh.edu.datbaogiay.service.NhanVienService;

@Component
public class KhuyenMaiConvert {
	
	@Autowired
	private NhanVienService nhanVienService;
	@Autowired
	private NhanVienConvert nhanVienConvert;
	
	
	public KhuyenMai chuyenKhuyenMaiEntity(KhuyenMaiDto khuyenMaiDto) {
		KhuyenMai khuyenMai = new KhuyenMai();
		if(khuyenMaiDto.getId() != 0) {
			khuyenMai.setid(khuyenMaiDto.getId());
		}
		
		
		khuyenMai.setNhanVien(nhanVienConvert.toNhanVienEntity(nhanVienService.layNhanVienTheoid(khuyenMaiDto.getMaNhanVien())));
		
		
		khuyenMai.setGiaTriGiam(khuyenMaiDto.getGiaTriGiam());
		khuyenMai.setNgayBatDau(khuyenMaiDto.getNgayBatDau());
		khuyenMai.setNgayHetHan(khuyenMaiDto.getNgayHetHan());
		khuyenMai.setTenKhuyenMai(khuyenMaiDto.getTenKhuyenMai());
		return khuyenMai;
		
	}
	
	public KhuyenMaiDto chuyenKhuyenMaiDto(KhuyenMai khuyenMai) {
		KhuyenMaiDto khuyenMaiDto = new KhuyenMaiDto();
		
		if(khuyenMai.getid() != 0) {
			khuyenMaiDto.setId(khuyenMai.getid());
		}
		
		khuyenMaiDto.setMaNhanVien(khuyenMai.getNhanVien().getid());
		khuyenMaiDto.setTenNhanVien(khuyenMai.getNhanVien().getTenNhanVien());
		khuyenMaiDto.setGiaTriGiam(khuyenMai.getGiaTriGiam());
		khuyenMaiDto.setNgayBatDau(khuyenMai.getNgayBatDau());
		khuyenMaiDto.setNgayHetHan(khuyenMai.getNgayHetHan());
		khuyenMaiDto.setTenKhuyenMai(khuyenMai.getTenKhuyenMai());
		
		return khuyenMaiDto;
	}
}
