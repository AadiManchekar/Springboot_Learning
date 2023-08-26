package com.aadi.security.repository;

import com.aadi.security.model.ApplicationUser;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository
  extends JpaRepository<ApplicationUser, Integer> {
  Optional<ApplicationUser> findByUsername(String username);
}
