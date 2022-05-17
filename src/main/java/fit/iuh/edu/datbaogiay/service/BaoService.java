package fit.iuh.edu.datbaogiay.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fit.iuh.edu.datbaogiay.dto.BaoDto;
import fit.iuh.edu.datbaogiay.entity.Bao;

@Service
public interface BaoService {
	public List<BaoDto> layDSBao();

	public BaoDto layBaoTheoID(int id);

	public String xoaBao(int id);

	public BaoDto luuBao(BaoDto baoDto);

	public List<BaoDto> timBaoTheoTen(String keyword);
	
	
}
