package fit.iuh.edu.datbaogiay.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fit.iuh.edu.datbaogiay.convert.BaoConvert;
import fit.iuh.edu.datbaogiay.dto.BaoDto;
import fit.iuh.edu.datbaogiay.entity.Bao;
import fit.iuh.edu.datbaogiay.repository.BaoRepository;
import fit.iuh.edu.datbaogiay.service.BaoService;

@Service
public class BaoServiceImpl implements BaoService {

	@Autowired
	private BaoRepository baoRepository;
	@Autowired
	private BaoConvert baoConvert;
//	@Autowired
//	public BaoServiceImpl(BaoRepository baoRepository) {
//		super();
//		this.baoRepository = baoRepository;
//	}

	@Override
	public List<BaoDto> layDSBao() {

		List<Bao> baos = (List<Bao>) baoRepository.findAll();
		List<BaoDto> baoDtos = new ArrayList<BaoDto>();

		for (Bao bao : baos) {
			if (Objects.isNull(bao)) {
				return null;
			}
			BaoDto baodto = baoConvert.chuyenBaoDto(bao);
			baoDtos.add(baodto);
		}
		return baoDtos;
	}

	@Override
	public BaoDto layBaoTheoID(int id) {
		Bao bao = baoRepository.findById(id).orElse(null);
		if (Objects.isNull(bao)) {
			return null;
		}
		return baoConvert.chuyenBaoDto(bao);

	}

	@Override
	public String xoaBao(int id) {
		baoRepository.deleteById(id);
		return "xóa thành công ";
	}

	@Override
	public BaoDto luuBao(BaoDto baoDto) {

		Bao bao = baoConvert.chuyenBaoEntity(baoDto);
		bao = baoRepository.save(bao);
		return baoConvert.chuyenBaoDto(bao);

	}

	@Override
	public List<BaoDto> timBaoTheoTen(String keyword) {
		List<BaoDto> baoDtos = new ArrayList<BaoDto>();
		List<Bao> baos = baoRepository.findAllByTenBao(keyword);
		for (Bao bao : baos) {
			BaoDto baoDto = baoConvert.chuyenBaoDto(bao);
			baoDtos.add(baoDto);
		}
		return baoDtos;
	}

	

}
