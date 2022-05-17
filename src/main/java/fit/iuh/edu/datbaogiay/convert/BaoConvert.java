package fit.iuh.edu.datbaogiay.convert;

import org.springframework.stereotype.Component;

import fit.iuh.edu.datbaogiay.dto.BaoDto;
import fit.iuh.edu.datbaogiay.entity.Bao;

@Component
public class BaoConvert {
	
	public Bao chuyenBaoEntity(BaoDto baoDto) {
		Bao bao = new Bao();
		
		if(baoDto.getId() != 0) {
			bao.setid(baoDto.getId());
		}
		
		bao.setTenBao(baoDto.getTenBao());
		bao.setHinhAnh(baoDto.getHinhAnh());
		bao.setDonGia(baoDto.getDonGia());
		bao.setMoTa(baoDto.getMoTa());		
		return bao;
	}
	
	public  BaoDto chuyenBaoDto(Bao bao) {
		BaoDto baoDto = new BaoDto();
		
		if(bao.getid() != 0) {
			baoDto.setId(bao.getid());
		}
		baoDto.setTenBao(bao.getTenBao());
		baoDto.setHinhAnh(bao.getHinhAnh());
		baoDto.setDonGia(bao.getDonGia());
		baoDto.setMoTa(bao.getMoTa());		
		return baoDto;
	}
}
