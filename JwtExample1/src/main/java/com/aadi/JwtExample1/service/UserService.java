package com.aadi.JwtExample1.service;

import com.aadi.JwtExample1.model.User;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Getter private List<User> store = new ArrayList<>();

  public UserService() {
    store.add(
        User.builder()
            .userId(UUID.randomUUID().toString())
            .name("Person 1")
            .email("person1@gmail.com")
            .build());
    store.add(
        User.builder()
            .userId(UUID.randomUUID().toString())
            .name("Person 2")
            .email("person2@gmail.com")
            .build());
    store.add(
        User.builder()
            .userId(UUID.randomUUID().toString())
            .name("Person 3")
            .email("person3@gmail.com")
            .build());
    store.add(
        User.builder()
            .userId(UUID.randomUUID().toString())
            .name("Person 4")
            .email("person4@gmail.com")
            .build());
  }
}
