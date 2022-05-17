package fit.iuh.edu.datbaogiay.entity;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name = "nhan_vien")
public class NhanVien {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private int id;
	@Column(name = "ten_nhan_vien" ,columnDefinition = "nvarchar(100)")
	private String tenNhanVien;
	@Column(name = "sdt")
	private String SDT;
	@Column(name = "dia_chi",columnDefinition = "nvarchar(100)")
	private String diaChi;
	@Column(name = "email")
	private String email;
	@Column(name = "mat_khau")
	private String matKhau;
	// mapping
	@OneToMany(mappedBy = "nhanVien")
	private Set<KhuyenMai> dsKhuyenMai;
	public int getid() {
		return id;
	}
	public void setid(int id) {
		this.id = id;
	}
	public String getTenNhanVien() {
		return tenNhanVien;
	}
	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public NhanVien(int id, String tenNhanVien, String sDT, String diaChi, String email, String matKhau) {
		super();
		this.id = id;
		this.tenNhanVien = tenNhanVien;
		SDT = sDT;
		this.diaChi = diaChi;
		this.email = email;
		this.matKhau = matKhau;
	}
	public NhanVien() {
		super();
	}
	@Override
	public String toString() {
		return "NhanVien [id=" + id + ", tenNhanVien=" + tenNhanVien + ", SDT=" + SDT + ", diaChi="
				+ diaChi + ", email=" + email + ", matKhau=" + matKhau + "]";
	}
	 
	
}
