package fit.iuh.edu.datbaogiay.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fit.iuh.edu.datbaogiay.entity.NhanVien;

public interface NhanVienRepository extends JpaRepository<NhanVien, Integer> {

	public Optional<NhanVien> findByUsersId(int id);

}
