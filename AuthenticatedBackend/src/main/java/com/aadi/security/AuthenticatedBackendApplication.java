package com.aadi.security;

import com.aadi.security.model.ApplicationUser;
import com.aadi.security.model.Role;
import com.aadi.security.repository.RoleRepository;
import com.aadi.security.repository.UserRepository;
import java.util.HashSet;
import java.util.Set;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class AuthenticatedBackendApplication {

  public static void main(String[] args) {
    SpringApplication.run(AuthenticatedBackendApplication.class, args);
  }

  @Bean
  CommandLineRunner run(
    RoleRepository roleRepository,
    UserRepository userRepository,
    PasswordEncoder passwordEncoder
  ) {
    return args -> {
      // check if the admin role is present, if yes then the below code is already ran before, so skip it
      if (roleRepository.findByAuthority("ADMIN").isPresent()) return;

      Role adminRole = roleRepository.save(new Role(1, "ADMIN"));
      roleRepository.save(new Role(2, "USER"));

      // now we have to create an admin user
      Set<Role> roles = new HashSet<>();
      roles.add(adminRole);

      ApplicationUser admin = new ApplicationUser(
        1,
        "admin",
        passwordEncoder.encode("password"),
        roles
      );
      userRepository.save(admin);
    };
  }
}
