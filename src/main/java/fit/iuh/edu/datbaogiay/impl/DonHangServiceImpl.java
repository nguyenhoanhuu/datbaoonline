package fit.iuh.edu.datbaogiay.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fit.iuh.edu.datbaogiay.convert.ChiTietDonHangConvert;
import fit.iuh.edu.datbaogiay.convert.DonHangConvert;
import fit.iuh.edu.datbaogiay.dto.BaoDto;
import fit.iuh.edu.datbaogiay.dto.DonHangDTO;
import fit.iuh.edu.datbaogiay.entity.Bao;
import fit.iuh.edu.datbaogiay.entity.ChiTietDonHang;
import fit.iuh.edu.datbaogiay.entity.DonHang;
import fit.iuh.edu.datbaogiay.repository.DonHangRepository;
import fit.iuh.edu.datbaogiay.service.DonHangService;

@Service
public class DonHangServiceImpl implements DonHangService {
	@Autowired
	private DonHangRepository donHangRepository;
	@Autowired
	private DonHangConvert donHangConvert;
	@Autowired
	private ChiTietDonHangConvert chiTietDonHangConvert; 
//	private ChiTietDonHangConvert chiTietDonHangConvert;
	@Autowired
	public DonHangServiceImpl(DonHangRepository donHangRepository) {
		super();
		this.donHangRepository = donHangRepository;
	}

	@Override
	public List<DonHangDTO> layDSDonHang() {
		List<DonHang> donHangs = donHangRepository.findAll();
		List<DonHangDTO> donHangDTOs = new ArrayList<DonHangDTO>();
		for (DonHang donHang : donHangs) {
			 if (Objects.isNull(donHang)) {
		            return null;
		      }
			 DonHangDTO donHangDTO = donHangConvert.chuyendonHangDTO(donHang);
			 donHangDTOs.add(donHangDTO);
		 }
		return donHangDTOs;
	}

	@Override 
	public DonHangDTO layDonHangTheoId(int id) {
		DonHang donHang = donHangRepository.findById(id).orElse(null);
		 if (Objects.isNull(donHang)) {
	            return null;
	        }
		 return donHangConvert.chuyendonHangDTO(donHang);
	}

	@Override
	public String xoaDonHang(int id) {
		DonHang donHang = donHangRepository.findById(id).orElse(null);
		 if (Objects.isNull(donHang)) {
	            return null;
	        }
		donHangRepository.delete(donHang);
		return "xóa thành công";
	}

	@Override
	public DonHangDTO luuDonHang(DonHangDTO donHangDTO) {
		DonHang  donHang= donHangConvert.chuyendonHangEntity(donHangDTO);
		int maDonHang = donHang.getid();
		Set<ChiTietDonHang> chiTietDonHangs = new HashSet<ChiTietDonHang>(); 
		donHangDTO.getChiTietDonHang().forEach(
				chiTietDonHangDTO1 ->{
					ChiTietDonHang a = chiTietDonHangConvert.chuyenChiTietDonHangEntity(chiTietDonHangDTO1,maDonHang);
					chiTietDonHangs.add(a);
				}
				);
		donHang.setChiTietDonHang(chiTietDonHangs);
		
				donHangRepository.save(donHang);
		
		
		return	donHangConvert.chuyendonHangDTO(donHang);
	}

}