package fit.iuh.edu.datbaogiay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fit.iuh.edu.datbaogiay.dto.BaoDto;
import fit.iuh.edu.datbaogiay.service.BaoService;

@RestController
public class Bao1TestController {
	@Autowired
	private BaoService BaoService;
	@GetMapping(value = "/bao/{tenBao}",consumes = MediaType.ALL_VALUE)
	public List<BaoDto> layBaoTheoTen(@PathVariable String tenBao) {
		return  BaoService.timBaoTheoTen(tenBao);

	}
}
