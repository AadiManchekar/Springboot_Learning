package com.aadi.jwtauth.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class SecurityFilterChainConfig {

  private final AuthenticationEntryPoint authenticationEntryPoint;
  private final JWTAuthenticaionFilter jwtAuthenticationFilter;

  @SuppressWarnings("removal")
  public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
    // Disable CORS
    // httpSecurity.cors(corsConfig -> corsConfig.disable());
    httpSecurity.cors(AbstractHttpConfigurer::disable);

    // Disable CSRF
    httpSecurity.csrf(AbstractHttpConfigurer::disable);

    // http req filter
    httpSecurity.authorizeHttpRequests(
        requestMatcher ->
            requestMatcher
                .requestMatchers("/api/auth/login/**")
                .permitAll()
                .requestMatchers("/api/auth/sign-up/**")
                .permitAll()
                .anyRequest()
                .authenticated());

    // Authentication Entry Point -> exception handler
    httpSecurity.exceptionHandling(
        exceptionConfig -> exceptionConfig.authenticationEntryPoint(authenticationEntryPoint));

    // Set session policy = STATELESS
    httpSecurity.sessionManagement(
        sessionConfig -> sessionConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

    // Add JWT authentication filter
    httpSecurity.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

    return null;
  }
}
