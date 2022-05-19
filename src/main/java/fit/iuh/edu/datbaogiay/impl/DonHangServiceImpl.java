package fit.iuh.edu.datbaogiay.impl;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fit.iuh.edu.datbaogiay.convert.ChiTietDonHangConvert;
import fit.iuh.edu.datbaogiay.convert.DonHangConvert;
import fit.iuh.edu.datbaogiay.dto.ChiTietDonHangDTO;
import fit.iuh.edu.datbaogiay.dto.DonHangDTO;
import fit.iuh.edu.datbaogiay.entity.ChiTietDonHang;
import fit.iuh.edu.datbaogiay.entity.ChiTietDonHangPk;
import fit.iuh.edu.datbaogiay.entity.ChiTietGioHang;
import fit.iuh.edu.datbaogiay.entity.ChiTietGioHangPk;
import fit.iuh.edu.datbaogiay.entity.DonHang;
import fit.iuh.edu.datbaogiay.entity.GioHang;
import fit.iuh.edu.datbaogiay.entity.KhachHang;
import fit.iuh.edu.datbaogiay.entity.KhuyenMai;
import fit.iuh.edu.datbaogiay.entity.Users;
import fit.iuh.edu.datbaogiay.repository.BaoRepository;
import fit.iuh.edu.datbaogiay.repository.ChiTietDonHangRepository;
import fit.iuh.edu.datbaogiay.repository.ChiTietGioHangRepository;
import fit.iuh.edu.datbaogiay.repository.DonHangRepository;
import fit.iuh.edu.datbaogiay.repository.GioHangRepository;
import fit.iuh.edu.datbaogiay.repository.KhachHangRepository;
import fit.iuh.edu.datbaogiay.repository.KhuyenMaiRepository;
import fit.iuh.edu.datbaogiay.service.DonHangService;
import fit.iuh.edu.datbaogiay.service.UsersService;

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
	@Autowired
	private KhuyenMaiRepository khuyenMaiRepository;
	@Autowired
	private KhachHangRepository khachHangRepository;
	@Autowired
	private ChiTietGioHangRepository chiTietGioHangRepository;
	@Autowired
	private UsersService usersService;
	@Autowired
	private GioHangRepository gioHangRepository;

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
	public Integer luuDonHang(DonHangDTO donHangDTO, Principal principal) {
		DonHang donHang = new DonHang();
		double total = 0.0;
		for (ChiTietDonHangDTO chiTietDonHangDTO : donHangDTO.getChiTietDonHang()) {
			total += chiTietDonHangDTO.getSoKy()*chiTietDonHangDTO.getDonGia()*chiTietDonHangDTO.getSoLuong();
		}
		Optional<KhuyenMai> khuyenMai = khuyenMaiRepository.findById(donHangDTO.getMaKhuyenMai());
		if(khuyenMai.isPresent() ) {
			total-=khuyenMai.get().getGiaTriGiam();
		}
		donHang.setKhachHang(new KhachHang(donHangDTO.getMaKhachHang()));
		donHang.setKhuyenMai(new KhuyenMai(donHangDTO.getMaKhuyenMai()));
		donHang.setNgayTaoDonHang(donHangDTO.getNgayTaoDonHang());
		donHang.setTrangThaiDonHang(donHangDTO.getTrangThaiDonHang());
		donHang.setDiaChiNhanHang(donHangDTO.getDiaChiNhanHang());
		donHang.setTongTienDonHang(total);
		donHang.setHinhThucThanhToan(donHangDTO.getHinhThucThanhToan());
		donHangRepository.save(donHang);
		Set<ChiTietDonHang> chiTietDonHangs = new HashSet<ChiTietDonHang>();
		for (ChiTietDonHangDTO chiTietDonHangDTO : donHangDTO.getChiTietDonHang()) {
			ChiTietDonHang chiTietDonHang = new ChiTietDonHang();
			chiTietDonHang.setId(new ChiTietDonHangPk(donHang.getid(), chiTietDonHangDTO.getMabao()));
			chiTietDonHang.setNgayDatBao(chiTietDonHangDTO.getNgayDatBao());
			chiTietDonHang.setNgatKetThucDatBao(chiTietDonHangDTO.getNgatKetThucDatBao());
			chiTietDonHang.setSoKy(chiTietDonHangDTO.getSoKy());
			chiTietDonHang.setSoLuong(chiTietDonHangDTO.getSoLuong());
			chiTietDonHangs.add(chiTietDonHang);
		}
		chiTietDonHangRepository.saveAll(chiTietDonHangs);
		Users users= usersService.getByUsername(principal.getName());
		users.getId();
		GioHang gioHang= gioHangRepository.findByKhachHang(users.getKhachHang());
		for (ChiTietDonHangDTO chiTietDonHangDTO : donHangDTO.getChiTietDonHang()) {
			
		chiTietGioHangRepository.deleteById(new ChiTietGioHangPk(chiTietDonHangDTO.getMabao(),gioHang.getid()));
		}
		return donHang.getid();
	}

	@Override
	public List<DonHangDTO> finddonhang(int year, int month, int day) {
		List<DonHangDTO> donHangDTOs = new ArrayList<DonHangDTO>();
		List<DonHang> donHangs = donHangRepository
				.findAllByNgayTaoDonHang_YearAndNgayTaoDonHang_MonthAndNgayTaoDonHang_DayOfMonth(year, month, day);
		for (DonHang donHang : donHangs) {
			DonHangDTO donHangDto = donHangConvert.chuyendonHangDTO(donHang);
			donHangDTOs.add(donHangDto);
		}
		return donHangDTOs;
	}

}