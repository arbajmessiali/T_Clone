package com.tclone.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tclone.model.ApplicationUser;

@Repository //required to create bean in SpringBoot
public interface UserRepo extends JpaRepository<ApplicationUser, Integer>{

	//Spring Security method to check username
	Optional<ApplicationUser> findByUsername(String username);
	
}
