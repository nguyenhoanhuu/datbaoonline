package fit.iuh.edu.datbaogiay.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "chi_tiet_gio_hang")
public class ChiTietGioHang implements Serializable {
	@EmbeddedId
	@AttributeOverrides({ @AttributeOverride(name = "baoId", column = @Column(name = "bao_id", nullable = false)),
			@AttributeOverride(name = "gioHangId", column = @Column(name = "gio_hang_id", nullable = false)) })
	private ChiTietGioHangPk id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bao_id",insertable = false,updatable = false)
	private Bao bao;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "gio_hang_id",insertable = false,updatable = false)
	private GioHang gioHang;
	@Column(name = "ngay_dat_bao")
	private Date ngayDatBao;
	@Column(name = "ngay_ket_thuc_dat_bao")
	private Date ngayKetThucDatBao;
	@Column(name = "so_ky")
	private int soKy;
	@Column(name = "so_luong")
	private int soLuong;

	
	

	public void setId(ChiTietGioHangPk id) {
		this.id = id;
	}
	
	public ChiTietGioHangPk getId() {
		return id;
	}

	public ChiTietGioHang(ChiTietGioHangPk id, Bao bao, GioHang gioHang, Date ngayDatBao,
			Date ngayKetThucDatBao, int soKy, int soLuong) {
		super();
		this.id = id;
		this.bao = bao;
		this.gioHang = gioHang;
		this.ngayDatBao = ngayDatBao;
		this.ngayKetThucDatBao = ngayKetThucDatBao;
		this.soKy = soKy;
		this.soLuong = soLuong;
	}

	public ChiTietGioHang() {
		super();
	}

	public Bao getBao() {
		return bao;
	}

	public void setBao(Bao bao) {
		this.bao = bao;
	}

	public GioHang getGioHang() {
		return gioHang;
	}

	public void setGioHang(GioHang gioHang) {
		this.gioHang = gioHang;
	}

	public Date getNgayDatBao() {
		return ngayDatBao;
	}

	public void setNgayDatBao(Date date) {
		this.ngayDatBao = date;
	}

	public Date getNgayKetThucDatBao() {
		return ngayKetThucDatBao;
	}

	public void setNgayKetThucDatBao(Date ngayKetThucDatBao) {
		this.ngayKetThucDatBao = ngayKetThucDatBao;
	}

	public int getSoKy() {
		return soKy;
	}

	public void setSoKy(int soKy) {
		this.soKy = soKy;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	@Override
	public String toString() {
		return "ChiTietGioHang [id=" + id + ", bao=" + bao + ", gioHang=" + gioHang + ", ngayDatBao=" + ngayDatBao
				+ ", ngayKetThucDatBao=" + ngayKetThucDatBao + ", soKy=" + soKy + ", soLuong=" + soLuong + "]";
	}

}