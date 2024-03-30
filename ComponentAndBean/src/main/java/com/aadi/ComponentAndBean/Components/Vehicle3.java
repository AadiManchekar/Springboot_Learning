package com.aadi.ComponentAndBean.Components;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Vehicle3 {
  private String name;

  // we dont have much control if we create bean using @component
  // with @bean we can initialize things as per out will
  // if we want similar then PostConstruct is the way
  @PostConstruct
  public void initialize() {
    this.name = "Honda";
    return;
  }
}
