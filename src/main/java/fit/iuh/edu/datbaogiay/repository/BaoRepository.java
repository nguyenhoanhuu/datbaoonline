package fit.iuh.edu.datbaogiay.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fit.iuh.edu.datbaogiay.entity.Bao;
import java.lang.String;

@Repository
public interface BaoRepository extends JpaRepository<Bao, Integer> {
	List<Bao> findByTenBao(String tenbao);
	

}