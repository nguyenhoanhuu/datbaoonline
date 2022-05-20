package fit.iuh.edu.datbaogiay.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fit.iuh.edu.datbaogiay.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {

  public Optional<Users> findByUsername(String username);
  
   public Users findById(int id);
}
