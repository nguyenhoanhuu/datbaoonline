package fit.iuh.edu.datbaogiay.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fit.iuh.edu.datbaogiay.convert.GioHangConvert;
import fit.iuh.edu.datbaogiay.dto.BaoDto;
import fit.iuh.edu.datbaogiay.dto.ChiTietGioHangDto;
import fit.iuh.edu.datbaogiay.dto.GioHangDto;
import fit.iuh.edu.datbaogiay.dto.XoaChiTietGioHangDto;
import fit.iuh.edu.datbaogiay.entity.Bao;
import fit.iuh.edu.datbaogiay.entity.ChiTietGioHang;
import fit.iuh.edu.datbaogiay.entity.ChiTietGioHangPk;
import fit.iuh.edu.datbaogiay.entity.DonHang;
import fit.iuh.edu.datbaogiay.entity.GioHang;
import fit.iuh.edu.datbaogiay.repository.BaoRepository;
import fit.iuh.edu.datbaogiay.repository.ChiTietGioHangRepository;
import fit.iuh.edu.datbaogiay.repository.GioHangRepository;
import fit.iuh.edu.datbaogiay.service.ChiTietGioHangService;
import fit.iuh.edu.datbaogiay.service.GioHangService;

@Service
public class GioHangServiceImpl implements GioHangService {
	@Autowired
	private GioHangRepository gioHangRepository;
	@Autowired
	private GioHangConvert gioHangConvert;
	// chi tiet gio hang
	private ChiTietGioHangService chiTietGioHangService;
	@Autowired
	private BaoRepository baoRepository;
	@Autowired
	private ChiTietGioHangRepository chiTietGioHangRepository;

	@Override
	public GioHangDto layGioHangTheoId(int id) {
		GioHang gioHang = gioHangRepository.findById(id).orElse(null);
		List<Bao> baos = baoRepository.findAll();

		if (Objects.isNull(gioHang)) {
			return null;
		}
		return gioHangConvert.chuyenGioHangDto(gioHang, baos);
	}

	@Override
	public String xoaGioHang(int id) {
		gioHangRepository.deleteById(id);
		return " xoá thành công";
	}

	@Transactional
	@Override
	public void luuGioHang(GioHangDto gioHangDto) {
		Optional<GioHang> gioHangOpt = gioHangRepository.findById(gioHangDto.getId());
		if (gioHangOpt.isPresent()) {

			GioHang gioHang = gioHangOpt.get();
			gioHang.getDsChiTietGioHang().clear();

			chiTietGioHangRepository.deleteByGioHang(gioHang);

			List<ChiTietGioHang> chiTietGioHangs = new ArrayList<ChiTietGioHang>();
			for (ChiTietGioHangDto chiTietGioHangDto : gioHangDto.getChiTietGioHang()) {
				ChiTietGioHang chiTietGioHang = new ChiTietGioHang();
				chiTietGioHang
						.setId(new ChiTietGioHangPk(chiTietGioHangDto.getBaoId(), chiTietGioHangDto.getGioHangId()));
				chiTietGioHang.setBao(new Bao(chiTietGioHangDto.getBaoId()));
				chiTietGioHang.setGioHang(new GioHang(chiTietGioHangDto.getGioHangId()));
				chiTietGioHang.setNgayDatBao(chiTietGioHangDto.getNgayDatBao());
				chiTietGioHang.setNgayKetThucDatBao(chiTietGioHangDto.getNgaytKetThucDatBao());
				chiTietGioHang.setSoKy(chiTietGioHangDto.getSoKy());
				chiTietGioHang.setSoLuong(chiTietGioHangDto.getSoLuong());
				chiTietGioHangs.add(chiTietGioHang);
			}
			chiTietGioHangRepository.saveAll(chiTietGioHangs);
			gioHangRepository.save(gioHang);
		}

	}

	@Override
	public List<GioHangDto> layDSGioHang() {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public void themBaoVaoGioHang(GioHangDto gioHangDto) {

		Optional<GioHang> gioHangOpt = gioHangRepository.findById(gioHangDto.getId());
		if (gioHangOpt.isPresent()) {

			ChiTietGioHangDto chiTietGioHangDto = gioHangDto.getChiTietGioHang().iterator().next();
			Optional<Bao> baoOpt = baoRepository.findById(chiTietGioHangDto.getBaoId());
			if (baoOpt.isPresent()) {
				Bao bao = baoOpt.get();
				GioHang gioHang = gioHangOpt.get();
				gioHang.getDsChiTietGioHang().removeIf(item -> item.getBao().getid()==bao.getid());
				chiTietGioHangRepository.deleteByGioHangAndBao(gioHang, bao);

				ChiTietGioHang chiTietGioHang = new ChiTietGioHang();
				chiTietGioHang
						.setId(new ChiTietGioHangPk(chiTietGioHangDto.getBaoId(), chiTietGioHangDto.getGioHangId()));
				chiTietGioHang.setBao(new Bao(chiTietGioHangDto.getBaoId()));
				chiTietGioHang.setGioHang(new GioHang(chiTietGioHangDto.getGioHangId()));
				chiTietGioHang.setNgayDatBao(chiTietGioHangDto.getNgayDatBao());
				chiTietGioHang.setNgayKetThucDatBao(chiTietGioHangDto.getNgaytKetThucDatBao());
				chiTietGioHang.setSoKy(chiTietGioHangDto.getSoKy());
				chiTietGioHang.setSoLuong(chiTietGioHangDto.getSoLuong());
				chiTietGioHangRepository.save(chiTietGioHang);
				gioHangRepository.save(gioHang);
			}
		}

	}

	@Override
	public void xoaChiTietGioHang(XoaChiTietGioHangDto xoaChiTietGioHangDto) {
		chiTietGioHangRepository.deleteById(new ChiTietGioHangPk(xoaChiTietGioHangDto.getBaoId(),xoaChiTietGioHangDto.getGioHangId()));
		
	}

}
