package com.aadi.JwtExample1.security;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
@Slf4j
@RequiredArgsConstructor
public class JWTAuthenticationFilter extends OncePerRequestFilter {

  private final JWTHelper jwtHelper;
  private final UserDetailsService userDetailsService;

  @Override
  protected void doFilterInternal(
      HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {

    String requestHeader = request.getHeader("Authorization");
    log.info(" Header :  {}", requestHeader);

    String username = null;
    String token = null;

    if (requestHeader != null && requestHeader.startsWith("Bearer")) {
      token = requestHeader.substring(7);
      try {

        username = jwtHelper.getUsernameFromToken(token);

      } catch (IllegalArgumentException e) {
        log.info("Illegal Argument while fetching the username !!");
        e.printStackTrace();
      } catch (ExpiredJwtException e) {
        log.info("Given jwt token is expired !!");
        e.printStackTrace();
      } catch (MalformedJwtException e) {
        log.info("Some changed has done in token !! Invalid Token");
        e.printStackTrace();
      } catch (Exception e) {
        e.printStackTrace();
      }
    } else {
      log.info("Invalid Header Value !! ");
    }

    if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
      UserDetails userDetails = userDetailsService.loadUserByUsername(username);
      Boolean validateToken = jwtHelper.validateToken(token, userDetails);

      if (validateToken) {
        UsernamePasswordAuthenticationToken authentication =
            new UsernamePasswordAuthenticationToken(
                userDetails, null, userDetails.getAuthorities());

        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authentication);
      } else {
        log.info("Validation Failed !!");
      }
    }
    filterChain.doFilter(request, response);
  }
}
