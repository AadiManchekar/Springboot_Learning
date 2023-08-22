package com.aadi.JwtExample3.security;

import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Component;

@Component
// this class is used to create basic function for JWT token
public class JwtHelper {

  public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

  private String secret =
    "3597952A6331073575F2DC7F281F8CDFFF4F963BC7063CD835BC6A97E001B3FB";

  // retrive username from the token
  public String getUsernameFromToken(String token) {
    return getClaimFromToken(token, Claims::getSubject);
  }
}
