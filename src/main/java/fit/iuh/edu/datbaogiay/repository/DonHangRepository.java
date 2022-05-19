package fit.iuh.edu.datbaogiay.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fit.iuh.edu.datbaogiay.entity.DonHang;
import fit.iuh.edu.datbaogiay.entity.KhachHang;

public interface DonHangRepository extends JpaRepository<DonHang, Integer> {
	@Query(value = "select * from don_hang where YEAR(ngay_tao_don_hang) = ?1 and MONTH(ngay_tao_don_hang) = ?2 and DAY(ngay_tao_don_hang) = ?3", nativeQuery = true)
	List<DonHang> findAllByNgayTaoDonHang_YearAndNgayTaoDonHang_MonthAndNgayTaoDonHang_DayOfMonth(int year, int month,
			int day);

}