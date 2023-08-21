package com.aadi.JwtExample3.Controller;

import com.aadi.JwtExample3.Service.UserService;
import com.aadi.JwtExample3.model.User;
import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {

  @Autowired
  private UserService userService;

  @GetMapping("/user")
  public List<User> getUser() {
    return this.userService.getUsers();
  }

  @GetMapping("/current-user")
  public String getLoggedInUser(Principal principal) {
    return principal.getName();
  }
}
