package com.aadi.JwtExample3.Service;

import com.aadi.JwtExample3.model.User;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private List<User> store = new ArrayList<>();

  public UserService() {
    store.add(
      new User(
        UUID.randomUUID().toString(),
        "Aadi Manchekar",
        "amjanthree@gmail.com"
      )
    );
    store.add(new User(UUID.randomUUID().toString(), "sda", "sdas@gmail.com"));
    store.add(
      new User(UUID.randomUUID().toString(), "das dsa", "dsa@gmail.com")
    );
  }

  public List<User> getUsers() {
    return this.store;
  }
}
