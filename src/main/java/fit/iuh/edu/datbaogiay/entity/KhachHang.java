package fit.iuh.edu.datbaogiay.entity;

import java.io.Serializable;


import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Table(name = "khach_hang")

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class KhachHang {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private int id;
	@Column(name = "ho_ten",columnDefinition = "nvarchar(100)")
	private String hoTen;
	@Column(nullable = false)
	private String email;
	@Column(name = "sdt")
	private String SDT;
	@Column(name = "mat_khau")
	private String matKhau;
	// mapping

	@OneToMany(mappedBy = "khachHang",cascade = {CascadeType.MERGE})
	private Set<DonHang> dsHoaDon;

	@OneToOne(cascade = {CascadeType.MERGE})
	@PrimaryKeyJoinColumn
	private GioHang gioHang;
	public KhachHang() {
		super();
	}

	public KhachHang(int id) {
		super();
		this.id = id;
	}

	public KhachHang(int id, String hoTen, String email, String sDT, String matKhau) {
		super();
		this.id = id;
		this.hoTen = hoTen;
		this.email = email;
		SDT = sDT;
		this.matKhau = matKhau;
	}

	public int getid() {
		return id;
	}

	public void setid(int id) {
		this.id = id;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSDT() {
		return SDT;
	}

	public void setSDT(String sDT) {
		SDT = sDT;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	@Override
	public String toString() {
		return "KhachHang [id=" + id + ", hoTen=" + hoTen + ", email=" + email + ", SDT=" + SDT
				+ ", matKhau=" + matKhau + "]";
	}

}