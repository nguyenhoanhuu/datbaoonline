package fit.iuh.edu.datbaogiay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fit.iuh.edu.datbaogiay.entity.GioHang;

public interface GioHangRepository extends JpaRepository<GioHang, Integer>{

	@Query("SELECT gh FROM GioHang gh JOIN gh.khachHang kh JOIN kh.users u WHERE u.id = :usersId")
	public GioHang findByUsersId(Integer usersId);
}
