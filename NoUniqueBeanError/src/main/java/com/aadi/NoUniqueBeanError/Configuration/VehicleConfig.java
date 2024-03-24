package com.aadi.NoUniqueBeanError.Configuration;

import com.aadi.NoUniqueBeanError.POJOs.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VehicleConfig {

  @Bean
  Vehicle vehicle1() {
    var veh = new Vehicle();
    veh.setName("Tata");
    return veh;
  }

  @Bean
  Vehicle vehicle2() {
    var veh = new Vehicle();
    veh.setName("Porsche");
    return veh;
  }

  @Bean
  Vehicle vehicle3() {
    var veh = new Vehicle();
    veh.setName("Suzuki");
    return veh;
  }
}
