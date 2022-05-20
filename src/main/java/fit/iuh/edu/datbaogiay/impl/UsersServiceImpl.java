package fit.iuh.edu.datbaogiay.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fit.iuh.edu.datbaogiay.entity.Users;
import fit.iuh.edu.datbaogiay.repository.UsersRepository;
import fit.iuh.edu.datbaogiay.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersRepository usersRepository;

	@Override
	public Users getByUsername(String userName) {
		return usersRepository.findByUsername(userName).orElse(null);
	}
	@Override
	public Users findById(int id ) {
		return usersRepository.findById(id);
	}

}
