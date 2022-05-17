package fit.iuh.edu.datbaogiay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import fit.iuh.edu.datbaogiay.entity.KhuyenMai;


public interface KhuyenMaiRepository extends  JpaRepository<KhuyenMai, Integer> {

}
