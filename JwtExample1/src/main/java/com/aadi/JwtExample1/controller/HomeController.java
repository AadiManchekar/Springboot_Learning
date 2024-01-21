package com.aadi.JwtExample1.controller;

import com.aadi.JwtExample1.model.User;
import com.aadi.JwtExample1.service.UserService;
import java.security.Principal;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
@RequiredArgsConstructor
public class HomeController {

  private final UserService userService;

  @GetMapping("/users")
  public List<User> getUsers() {
    return userService.getStore();
  }

  @GetMapping("/current-user")
  public String getLoggedInUseString(Principal principal) {
    return principal.getName();
  }
}
