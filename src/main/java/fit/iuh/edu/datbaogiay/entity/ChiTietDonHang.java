package fit.iuh.edu.datbaogiay.entity;

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



@Entity
@Table(name = "chi_tiet_don_hang")

public class ChiTietDonHang {
	@EmbeddedId
	@AttributeOverrides({ @AttributeOverride(name = "donHangId", column = @Column(name = "don_hang_id", nullable = false)),
			@AttributeOverride(name = "baoId", column = @Column(name = "bao_id", nullable = false)) })
	private ChiTietDonHangPk id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "don_hang_id",insertable = false,updatable = false)
	private DonHang donHang;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bao_id",insertable = false,updatable = false)
	private Bao bao;
	@Column(name = "ngay_dat_bao")
	private Date ngayDatBao;
	@Column(name = "ngay_ket_thuc_dat_bao")
	private Date ngatKetThucDatBao;
	@Column(name = "so_luong")
	private int soLuong;
	@Column(name = "so_ky")
	private int soKy;

	public ChiTietDonHang(ChiTietDonHangPk id, DonHang donHang, Bao bao, Date ngayDatBao,
			Date ngatKetThucDatBao, int soLuong, int soKy) {
		super();
		this.id = id;
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
	
	public ChiTietDonHangPk getId() {
		return id;
	}

	

	public void setId(ChiTietDonHangPk id) {
		this.id = id;
	}

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

	public Date getNgayDatBao() {
		return ngayDatBao;
	}

	public void setNgayDatBao(Date ngayDatBao) {
		this.ngayDatBao = ngayDatBao;
	}

	public Date getNgatKetThucDatBao() {
		return ngatKetThucDatBao;
	}

	public void setNgatKetThucDatBao(Date ngatKetThucDatBao) {
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

	@Override
	public String toString() {
		return "ChiTietDonHang [id=" + id + ", donHang=" + donHang + ", bao=" + bao + ", ngayDatBao=" + ngayDatBao
				+ ", ngatKetThucDatBao=" + ngatKetThucDatBao + ", soLuong=" + soLuong + ", soKy=" + soKy + "]";
	}

}