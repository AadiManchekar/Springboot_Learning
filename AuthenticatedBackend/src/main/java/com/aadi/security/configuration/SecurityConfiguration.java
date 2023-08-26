package com.aadi.security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  // Authentication Manager
  // AuthenticationManager is a core component responsible for authenticating users. It takes care of validating user credentials, handling authentication-related logic, and making sure that the authentication process is secure.
  @Bean
  public AuthenticationManager authenticationManager(
    UserDetailsService detailsService
  ) {
    // DaoAuthenticationProvider is one of the implementations of the AuthenticationProvider
    DaoAuthenticationProvider daoProvider = new DaoAuthenticationProvider();
    daoProvider.setUserDetailsService(detailsService);
    return new ProviderManager(daoProvider);
    // ProviderManager is yet another implementation of the AuthenticationManager interface. It takes one or more AuthenticationProvider instances (in this case, just the DaoAuthenticationProvider) and uses them to authenticate users.
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    return http
      .csrf(csrf -> csrf.disable())
      .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
      .httpBasic()
      .and()
      .build();
  }
}
