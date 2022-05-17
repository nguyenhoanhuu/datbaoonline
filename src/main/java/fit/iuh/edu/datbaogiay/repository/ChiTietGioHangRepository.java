package fit.iuh.edu.datbaogiay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fit.iuh.edu.datbaogiay.entity.Bao;
import fit.iuh.edu.datbaogiay.entity.ChiTietGioHang;
import fit.iuh.edu.datbaogiay.entity.ChiTietGioHangPk;
import fit.iuh.edu.datbaogiay.entity.GioHang;

public interface ChiTietGioHangRepository extends JpaRepository<ChiTietGioHang,ChiTietGioHangPk> {

	void deleteByGioHang(GioHang gioHang);
	void deleteByGioHangAndBao(GioHang gioHang, Bao bao);
}
