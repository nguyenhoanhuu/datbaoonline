package fit.iuh.edu.datbaogiay.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fit.iuh.edu.datbaogiay.entity.Bao;

@Repository
public interface BaoRepository extends JpaRepository<Bao, Integer> {
	@Query(value = "select * from bao s where s.ten_bao like %:ten% ", nativeQuery = true)
	List<Bao> findAllByTenBao(@Param("ten") String tenbao);
	

}