package com.tclone;

import java.util.HashSet;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.tclone.model.ApplicationUser;
import com.tclone.model.Role;
import com.tclone.repo.RoleRepo;
import com.tclone.repo.UserRepo;
import com.tclone.services.UserService;

@SpringBootApplication
public class TcloneApplication {

	public static void main(String[] args) {
		SpringApplication.run(TcloneApplication.class, args);
	}

	@Bean
	CommandLineRunner run(RoleRepo roleRepo, UserService userService) {
		return args -> {
			roleRepo.save(new Role(1, "USER"));
			ApplicationUser u = new ApplicationUser();
			u.setFirstName("unknown");
			u.setLastName("dev");
			userService.registerUser(u);
			/* ApplicationUser u = new ApplicationUser();
			u.setFirstName("unknown");
			u.setLastName("dev");
			HashSet<Role> roles = new HashSet<>();
			roles.add(roleRepo.findRoleByAuthority("USER").get());
			u.setAuthorities(roles);
			userRepo.save(u);
			*/
		};
	}	
}
