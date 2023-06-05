package com.tclone.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tclone.model.ApplicationUser;
import com.tclone.model.Role;
import com.tclone.repo.RoleRepo;
import com.tclone.repo.UserRepo;

@Service
public class UserService {
	
	private final UserRepo userRepo;
	private final RoleRepo roleRepo;
	
	@Autowired
	public UserService(UserRepo userRepo, RoleRepo roleRepo) {
		this.userRepo = userRepo;
		this.roleRepo = roleRepo;
	}
	
	public ApplicationUser registerUser(ApplicationUser user) {
		Set<Role> roles = user.getAuthorities();
		roles.add(roleRepo.findRoleByAuthority("USER").get());
		user.setAuthorities(roles);
		
		return userRepo.save(user);
	}
}
