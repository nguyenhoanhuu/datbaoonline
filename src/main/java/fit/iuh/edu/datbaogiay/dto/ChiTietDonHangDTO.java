package fit.iuh.edu.datbaogiay.dto;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;

import fit.iuh.edu.datbaogiay.entity.DonHang;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import fit.iuh.edu.datbaogiay.entity.Bao;
import fit.iuh.edu.datbaogiay.entity.ChiTietGioHangPk;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChiTietDonHangDTO {
	private int madonHang;
	private int mabao;
	private String tenBao;
	private double dongia;
	private LocalDateTime ngayDatBao;
	private LocalDateTime ngatKetThucDatBao;
	private double donGia;
	private int soLuong;
	private int soKy;
	private double thanhTien;

	
	

	
}
