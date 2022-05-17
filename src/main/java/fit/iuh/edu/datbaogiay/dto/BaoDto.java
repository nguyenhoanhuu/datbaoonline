package fit.iuh.edu.datbaogiay.dto;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaoDto extends AbstractDTO{

	private String tenBao;

	private String hinhAnh;
	
	private double donGia;

	private String moTa;

	public String getTenBao() {
		return tenBao;
	}

	public void setTenBao(String tenBao) {
		this.tenBao = tenBao;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}


	
}
