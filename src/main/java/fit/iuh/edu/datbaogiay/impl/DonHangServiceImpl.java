package fit.iuh.edu.datbaogiay.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fit.iuh.edu.datbaogiay.convert.ChiTietDonHangConvert;
import fit.iuh.edu.datbaogiay.convert.DonHangConvert;
import fit.iuh.edu.datbaogiay.dto.BaoDto;
import fit.iuh.edu.datbaogiay.dto.ChiTietDonHangDTO;
import fit.iuh.edu.datbaogiay.dto.ChiTietGioHangDto;
import fit.iuh.edu.datbaogiay.dto.DonHangDTO;
import fit.iuh.edu.datbaogiay.entity.Bao;
import fit.iuh.edu.datbaogiay.entity.ChiTietDonHang;
import fit.iuh.edu.datbaogiay.entity.ChiTietDonHangPk;
import fit.iuh.edu.datbaogiay.entity.DonHang;
import fit.iuh.edu.datbaogiay.entity.KhachHang;
import fit.iuh.edu.datbaogiay.entity.KhuyenMai;
import fit.iuh.edu.datbaogiay.repository.BaoRepository;
import fit.iuh.edu.datbaogiay.repository.ChiTietDonHangRepository;
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
	@Autowired
	private ChiTietDonHangRepository chiTietDonHangRepository;
	@Autowired
	private BaoRepository baoRepository;
	private double tongThanhTien;
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

	@Transactional
	@Override
	public void luuDonHang(DonHangDTO donHangDTO) {
		
		DonHang donHang = new DonHang();
		
//		 tongThanhTien=0;
//			donHang.getChiTietDonHang().forEach(a-> 
//			{
//				ChiTietDonHangDTO chiTietDonHangDTO= chiTietDonHangConvert.chuyenChiTietDonHangDto(a);
//				tongThanhTien+= chiTietDonHangDTO.getThanhTien();
//			
//			}
		
		donHang.setKhachHang(new KhachHang(donHangDTO.getMaKhachHang()));
		donHang.setKhuyenMai(new KhuyenMai(donHangDTO.getMaKhuyenMai()));
		donHang.setNgayTaoDonHang(donHangDTO.getNgayTaoDonHang());
		donHang.setTrangThaiDonHang(donHangDTO.getTrangThaiDonHang());
		donHang.setDiaChiNhanHang(donHangDTO.getDiaChiNhanHang());
		donHang.setTongTienDonHang(donHangDTO.getTongTienDonHang());
		donHang.setHinhThucThanhToan(donHangDTO.getHinhThucThanhToan());
		donHangRepository.save(donHang);

		Set<ChiTietDonHang> chiTietDonHangs = new HashSet<ChiTietDonHang>();
		
		for(ChiTietDonHangDTO chiTietDonHangDTO :donHangDTO.getChiTietDonHang() ) {
			ChiTietDonHang chiTietDonHang = new ChiTietDonHang();
			chiTietDonHang.setId(new ChiTietDonHangPk(donHang.getid(),chiTietDonHangDTO.getMabao()));
			chiTietDonHang.setNgayDatBao(chiTietDonHangDTO.getNgayDatBao());
			chiTietDonHang.setNgatKetThucDatBao(chiTietDonHangDTO.getNgatKetThucDatBao());
			chiTietDonHang.setSoKy(chiTietDonHangDTO.getSoKy());
			chiTietDonHang.setSoLuong(chiTietDonHangDTO.getSoLuong());
			chiTietDonHangs.add(chiTietDonHang);
			
		}
		
		
		
		chiTietDonHangRepository.saveAll(chiTietDonHangs);
	}

}