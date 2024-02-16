package com.aadi.jwtauthenticationservice.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class SecurityFilterChainConfig {

  @SuppressWarnings("deprecation")
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
    
    private final AuthenticationEntryPoint authenticationEntryPoint;
    private final JWTAuthenticationFilter jwtAuthenticationFilter;
    
    // Disable CORS
    httpSecurity.cors(corsConfig -> corsConfig.disable());

    // Disable CSRF
    httpSecurity.csrf(csrfConfig -> csrfConfig.disable());

    // Http Request Filter
    httpSecurity.authorizeRequests(
        requestMatcher ->
            requestMatcher
                .requestMatchers("/api/auth/login/**")
                .permitAll()
                .requestMatchers("/api/auth/sign-up/**")
                .permitAll()
                .anyRequest()
                .authenticated());

    // Authentication Entry Point -->Exception Handler
    httpSecurity.exceptionHandling(
        exceptionConfig -> exceptionConfig.authenticationEntryPoint(authenticationEntryPoint)
    );

    // Set session policy = STATELESS
    httpSecurity.sessionManagement(
        sessionConfig->sessionConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    );

    // Add JWT Authentication Filter
    httpSecurity.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
    return null;
  }
}
