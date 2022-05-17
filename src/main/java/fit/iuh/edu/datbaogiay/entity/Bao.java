package fit.iuh.edu.datbaogiay.entity;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Table(name = "bao")
public class Bao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private int id;
	@Column(name = "ten_bao", columnDefinition = "nvarchar(100)")
	private String tenBao;
	@Column(name = "hinh_anh")
	private String hinhAnh;
	@Column(name = "don_gia")
	private double donGia;
	@Column(name = "mo_ta",columnDefinition = "nvarchar(100)")
	private String moTa;
//mapping
	@OneToMany(mappedBy = "bao")
	private Set<ChiTietGioHang> dsChiTietGioHang;
	@OneToMany(mappedBy = "bao")
	private Set<ChiTietDonHang> dsChiTietHoaDon;
	public int getid() {
		return id;
	}
	public void setid(int id) {
		this.id = id;
	}
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
	public Set<ChiTietGioHang> getDsChiTietGioHang() {
		return dsChiTietGioHang;
	}
	public void setDsChiTietGioHang(Set<ChiTietGioHang> dsChiTietGioHang) {
		this.dsChiTietGioHang = dsChiTietGioHang;
	}
	public Set<ChiTietDonHang> getDsChiTietHoaDon() {
		return dsChiTietHoaDon;
	}
	public void setDsChiTietHoaDon(Set<ChiTietDonHang> dsChiTietHoaDon) {
		this.dsChiTietHoaDon = dsChiTietHoaDon;
	}

	public Bao() {
		super();
	}
	
	
	public Bao(String tenBao, String hinhAnh, double donGia, String moTa, Set<ChiTietGioHang> dsChiTietGioHang,
		Set<ChiTietDonHang> dsChiTietHoaDon) {
	super();
	this.tenBao = tenBao;
	this.hinhAnh = hinhAnh;
	this.donGia = donGia;
	this.moTa = moTa;
	this.dsChiTietGioHang = dsChiTietGioHang;
	this.dsChiTietHoaDon = dsChiTietHoaDon;
}
	
@Override
public String toString() {
	return "Bao [id=" + id + ", tenBao=" + tenBao + ", hinhAnh=" + hinhAnh + ", donGia=" + donGia + ", moTa="
			+ moTa + "]";
}
public Bao(int id) {
	super();
	this.id = id;
}
public Bao(String tenBao) {
	super();
	this.tenBao = tenBao;
}

	
	
}