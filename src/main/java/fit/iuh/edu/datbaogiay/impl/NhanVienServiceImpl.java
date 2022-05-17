package fit.iuh.edu.datbaogiay.impl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fit.iuh.edu.datbaogiay.controller.NhanVienController;
import fit.iuh.edu.datbaogiay.convert.NhanVienConvert;
import fit.iuh.edu.datbaogiay.dto.NhanVienDto;
import fit.iuh.edu.datbaogiay.entity.NhanVien;
import fit.iuh.edu.datbaogiay.repository.NhanVienRepository;
import fit.iuh.edu.datbaogiay.service.NhanVienService;
@Service
public class NhanVienServiceImpl implements NhanVienService {
	 @Autowired
	private NhanVienRepository nhanVienRepository;
	 @Autowired
	    private NhanVienConvert nhanVienConvert;
	@Autowired
	public NhanVienServiceImpl(NhanVienRepository nhanVienRepository) {
		super();
		this.nhanVienRepository = nhanVienRepository;
	}

	@Override
	public NhanVienDto layNhanVienTheoid(int id) {
		NhanVien nhanVien = nhanVienRepository.findById(id).orElse(null);
		 if (Objects.isNull(nhanVien)) {
	            return null;
	        }
		return nhanVienConvert.tonhanVienDto(nhanVien);
	}
	
}
