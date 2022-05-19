package fit.iuh.edu.datbaogiay.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fit.iuh.edu.datbaogiay.entity.KhachHang;

public interface KhachHangRepository extends JpaRepository<KhachHang, Integer>{

	public Optional<KhachHang> findByUsersId(int id);
}
