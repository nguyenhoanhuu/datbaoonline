package fit.iuh.edu.datbaogiay.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Table(name = "chi_tiet_don_hang")
@IdClass(ChiTietDonHangPk.class)
public class ChiTietDonHang {
	@Id
	@ManyToOne
	@JoinColumn(name = "donHangId")
	private DonHang donHang;
	@Id
	@ManyToOne
	@JoinColumn(name = "baoId")
	private Bao bao;
	@Column(name = "ngay_dat_bao")
	private LocalDateTime ngayDatBao;
	@Column(name = "ngay_ket_thuc_dat_bao")
	private LocalDateTime ngatKetThucDatBao;
	@Column(name = "so_luong")
	private int soLuong;
	@Column(name = "so_ky")
	private int soKy;
	public DonHang getDonHang() {
		return donHang;
	}
	public void setDonHang(DonHang donHang) {
		this.donHang = donHang;
	}
	public Bao getBao() {
		return bao;
	}
	public void setBao(Bao bao) {
		this.bao = bao;
	}
	public LocalDateTime getNgayDatBao() {
		return ngayDatBao;
	}
	public void setNgayDatBao(LocalDateTime ngayDatBao) {
		this.ngayDatBao = ngayDatBao;
	}
	public LocalDateTime getNgatKetThucDatBao() {
		return ngatKetThucDatBao;
	}
	public void setNgatKetThucDatBao(LocalDateTime ngatKetThucDatBao) {
		this.ngatKetThucDatBao = ngatKetThucDatBao;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public int getSoKy() {
		return soKy;
	}
	public void setSoKy(int soKy) {
		this.soKy = soKy;
	}
	public ChiTietDonHang(DonHang donHang, Bao bao, LocalDateTime ngayDatBao, LocalDateTime ngatKetThucDatBao,
			int soLuong, int soKy) {
		super();
		this.donHang = donHang;
		this.bao = bao;
		this.ngayDatBao = ngayDatBao;
		this.ngatKetThucDatBao = ngatKetThucDatBao;
		this.soLuong = soLuong;
		this.soKy = soKy;
	}
	public ChiTietDonHang() {
		super();
	}
	@Override
	public String toString() {
		return "ChiTietDonHang [donHang=" + donHang + ", bao=" + bao + ", ngayDatBao=" + ngayDatBao
				+ ", ngatKetThucDatBao=" + ngatKetThucDatBao + ", soLuong=" + soLuong + ", soKy=" + soKy + "]";
	}

	
}