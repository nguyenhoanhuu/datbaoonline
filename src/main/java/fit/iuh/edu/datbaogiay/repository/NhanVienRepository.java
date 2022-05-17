package fit.iuh.edu.datbaogiay.repository;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.springframework.data.jpa.repository.JpaRepository;

import fit.iuh.edu.datbaogiay.entity.NhanVien;

public interface NhanVienRepository extends JpaRepository<NhanVien, Integer> {

}
