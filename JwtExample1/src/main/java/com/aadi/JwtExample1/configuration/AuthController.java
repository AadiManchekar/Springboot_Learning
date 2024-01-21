package com.aadi.JwtExample1.configuration;

import com.aadi.JwtExample1.model.JWTRequest;
import com.aadi.JwtExample1.model.JWTResponse;
import com.aadi.JwtExample1.security.JWTHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

  private final UserDetailsService userDetailsService;
  private final AuthenticationManager authenticationManager;
  private final JWTHelper jwtHelper;

  private void doAuthenticate(String email, String password) {

    UsernamePasswordAuthenticationToken authentication =
        new UsernamePasswordAuthenticationToken(email, password);
    try {
      authenticationManager.authenticate(authentication);

    } catch (BadCredentialsException e) {
      throw new BadCredentialsException(" Invalid Username or Password  !!");
    }
  }

  @PostMapping("/login")
  public ResponseEntity<JWTResponse> login(@RequestBody JWTRequest request) {

    doAuthenticate(request.getEmail(), request.getPassword());
    UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
    String token = jwtHelper.generateToken(userDetails);

    JWTResponse response =
        JWTResponse.builder().jwtToken(token).username(userDetails.getUsername()).build();
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @ExceptionHandler(BadCredentialsException.class)
  public String exceptionHandler() {
    return "Credentials Invalid !!";
  }
}
