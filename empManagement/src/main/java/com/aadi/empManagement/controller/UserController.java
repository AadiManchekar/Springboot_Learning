package com.aadi.empManagement.controller;

import com.aadi.empManagement.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @RequestMapping("/")
  public String home() {
    return "hello world";
  }

  @GetMapping("/dummyuser")
  public User createDummyUser() {
    User user = new User("1", "Aadi", "amjanthree@gmail.com");
    return user;
  }

  @GetMapping("/{id}")
  public String pathVariable(@PathVariable String id){
    return id;
  }
}
