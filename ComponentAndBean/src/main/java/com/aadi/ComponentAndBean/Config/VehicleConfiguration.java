package com.aadi.ComponentAndBean.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VehicleConfiguration {
    
    @Bean
    Vehicle vehicle(){
        var veh = new Vehicle();
        veh.setName("Suzuki");
        return veh;
    } 
}
