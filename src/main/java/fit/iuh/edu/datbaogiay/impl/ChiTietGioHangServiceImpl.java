package fit.iuh.edu.datbaogiay.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fit.iuh.edu.datbaogiay.convert.ChiTietGioHangConvert;
import fit.iuh.edu.datbaogiay.dto.BaoDto;
import fit.iuh.edu.datbaogiay.dto.ChiTietGioHangDto;
import fit.iuh.edu.datbaogiay.entity.Bao;
import fit.iuh.edu.datbaogiay.entity.ChiTietDonHang;
import fit.iuh.edu.datbaogiay.entity.ChiTietGioHang;
import fit.iuh.edu.datbaogiay.entity.ChiTietGioHangPk;
import fit.iuh.edu.datbaogiay.repository.ChiTietDonHangRepository;
import fit.iuh.edu.datbaogiay.repository.ChiTietGioHangRepository;
import fit.iuh.edu.datbaogiay.service.BaoService;
import fit.iuh.edu.datbaogiay.service.ChiTietDonHangService;
import fit.iuh.edu.datbaogiay.service.ChiTietGioHangService;
@Service
public class ChiTietGioHangServiceImpl implements ChiTietGioHangService{
	@Autowired
	private ChiTietGioHangRepository chiTietGioHangRepository;
	
	@Autowired
	private BaoService baoService;
	@Autowired
	private ChiTietGioHangConvert chiTietGioHangConvert;
	

	@Override
	public List<ChiTietGioHangDto> layDSChiTietGioHang() {
		
		List<ChiTietGioHang> chiTietGioHangs =  chiTietGioHangRepository.findAll();
		List<ChiTietGioHangDto> chiTietGioHangDtos = new ArrayList<ChiTietGioHangDto>();
		
		for (ChiTietGioHang chiTietGioHang : chiTietGioHangs) {
			 if (Objects.isNull(chiTietGioHang)) {
		            return null;
		        }
//			 ChiTietGioHangDto chiTietGioHangDto = chiTietGioHangConvert.chuyenChiTietGioHangDto(chiTietGioHang);
//		chiTietGioHangDtos.add(chiTietGioHangDto);
		}
		return chiTietGioHangDtos;
	}

	@Override
	public ChiTietGioHangDto layChiTietGioHangTheoId(int id) {
		return null;
	}

//	@Override
//	public String xoaChiTietGioHang(int productId) {
//		BaoDto layId= baoService.layBaoTheoID(productId);
//		
//		chiTietGioHangRepository.deleteById(productId);
//		return "xoá sản phẩm có mã :" +productId;
//	}

	@Override
	public ChiTietGioHangDto luuChiTietGioHang(ChiTietGioHangDto chiTietGioHangDto) {
		ChiTietGioHang chiTietGioHang = chiTietGioHangConvert.chuyenChiTietGioHangEntity(chiTietGioHangDto);
		chiTietGioHang= chiTietGioHangRepository.save(chiTietGioHang);
		return null;
//		return chiTietGioHangConvert.chuyenChiTietGioHangDto(chiTietGioHang);
	}

	
	@Override
	public String xoaChiTietGioHang(ChiTietGioHangPk chiTietGioHangId) {
		
		return "xoá thành công";
	}

	


}
