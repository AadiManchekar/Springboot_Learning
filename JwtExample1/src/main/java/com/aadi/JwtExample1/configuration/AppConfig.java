package com.aadi.JwtExample1.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class AppConfig {

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public UserDetailsService userDetailsService() {
    UserDetails user1 =
        User.builder()
            .username("person1")
            .password(passwordEncoder().encode("person1"))
            .roles("ADMIN")
            .build();

    UserDetails user2 =
        User.builder()
            .username("person2")
            .password(passwordEncoder().encode("person2"))
            .roles("ADMIN")
            .build();

    return new InMemoryUserDetailsManager(user1, user2);
  }
}
