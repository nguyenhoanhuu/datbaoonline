package fit.iuh.edu.datbaogiay.service;

import org.springframework.stereotype.Service;

import fit.iuh.edu.datbaogiay.entity.Users;

@Service
public interface UsersService {
	public Users getByUsername(String userName);

	Users findById(int id);

}
