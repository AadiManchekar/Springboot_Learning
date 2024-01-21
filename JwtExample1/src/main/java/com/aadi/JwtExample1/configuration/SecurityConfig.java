package com.aadi.JwtExample1.configuration;

import com.aadi.JwtExample1.security.JWTAuthenticationEntrypoint;
import com.aadi.JwtExample1.security.JWTAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfiguration{

  private final JWTAuthenticationEntrypoint authenticationEntrypoint;
  private final JWTAuthenticationFilter authenticationFilter;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

    http.csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(
            auth ->
                auth.requestMatchers("/home/**")
                    .authenticated()
                    .requestMatchers("auth/login")
                    .permitAll()
                    .anyRequest()
                    .authenticated())
        .exceptionHandling(ex -> ex.authenticationEntryPoint(authenticationEntrypoint))
        .sessionManagement(
            session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

    http.addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class);

    return http.build();
  }
}
