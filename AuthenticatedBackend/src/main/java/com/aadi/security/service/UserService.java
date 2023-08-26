package com.aadi.security.service;

import com.aadi.security.model.ApplicationUser;
import com.aadi.security.model.Role;
import com.aadi.security.repository.UserRepository;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

// responsible for loading user details by username during the authentication process
@Service
public class UserService implements UserDetailsService {

  @Autowired
  private PasswordEncoder encoder;

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username)
    throws UsernameNotFoundException {
    System.out.println("In the User Details Service");

    return userRepository.findByUsername(username).orElseThrow();
  }
}
