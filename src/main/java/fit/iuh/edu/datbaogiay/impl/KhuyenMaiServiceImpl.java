package fit.iuh.edu.datbaogiay.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fit.iuh.edu.datbaogiay.convert.DonHangConvert;
import fit.iuh.edu.datbaogiay.convert.KhuyenMaiConvert;
import fit.iuh.edu.datbaogiay.convert.NhanVienConvert;
import fit.iuh.edu.datbaogiay.dto.KhuyenMaiDto;
import fit.iuh.edu.datbaogiay.entity.DonHang;
import fit.iuh.edu.datbaogiay.entity.KhachHang;
import fit.iuh.edu.datbaogiay.entity.KhuyenMai;
import fit.iuh.edu.datbaogiay.entity.NhanVien;
import fit.iuh.edu.datbaogiay.repository.KhuyenMaiRepository;
import fit.iuh.edu.datbaogiay.repository.NhanVienRepository;
import fit.iuh.edu.datbaogiay.service.KhuyenMaiService;

@Service
public class KhuyenMaiServiceImpl implements KhuyenMaiService{
	@Autowired
	private KhuyenMaiRepository khuyenMaiReponsitory;
	@Autowired
	private KhuyenMaiConvert khuyenMaiConvert;
	@Autowired
	private NhanVienRepository nhanVienRepository;

	@Autowired 
	public KhuyenMaiServiceImpl(KhuyenMaiRepository reponsitory) {
		  super();
		  this.khuyenMaiReponsitory = reponsitory;
	}

	@Override
	public List<KhuyenMaiDto> layDSKhuyenMai() {
		List<KhuyenMai> khuyenMais = (List<KhuyenMai>) khuyenMaiReponsitory.findAll();
		List<KhuyenMaiDto> khuyenMaiDtos = new ArrayList<KhuyenMaiDto>();
		for(KhuyenMai khuyenMai : khuyenMais) {
			if(Objects.isNull(khuyenMai)) {
				return null;
			}
			KhuyenMaiDto khuyenMaiDto = khuyenMaiConvert.chuyenKhuyenMaiDto(khuyenMai);
			khuyenMaiDtos.add(khuyenMaiDto);
		}
		return khuyenMaiDtos;
	}

	@Override
	public String xoaKhuyenMai(int id) {
		KhuyenMai khuyenMai = khuyenMaiReponsitory.findById(id).orElse(null);
		if (Objects.isNull(khuyenMai)) {
			return null;
		}
		khuyenMaiReponsitory.delete(khuyenMai);
		return "Xóa khuyến mãi thành công";
	}

	@Override
	public KhuyenMaiDto layKhuyenMaiTheoid(int id) {
		KhuyenMai khuyenMai = khuyenMaiReponsitory.findById(id).orElse(null);
		if (Objects.isNull(khuyenMai)) {
			return null;
		}
		return khuyenMaiConvert.chuyenKhuyenMaiDto(khuyenMai);
	}

	@Override
	public KhuyenMaiDto themKhuyenMai(KhuyenMaiDto khuyenMaiDto) {
		KhuyenMai khuyenMai = khuyenMaiConvert.chuyenKhuyenMaiEntity(khuyenMaiDto);
		NhanVien nhanVien = nhanVienRepository.getById(khuyenMaiDto.getMaNhanVien());
		khuyenMai.setNhanVien(nhanVien);
		khuyenMaiReponsitory.save(khuyenMai);
		return khuyenMaiConvert
				.chuyenKhuyenMaiDto(khuyenMai);
	}
	
}
