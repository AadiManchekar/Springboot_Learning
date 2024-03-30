package com.aadi.ComponentAndBean;

import com.aadi.ComponentAndBean.Components.Vehicle2;
import com.aadi.ComponentAndBean.Components.Vehicle3;
import com.aadi.ComponentAndBean.Config.Vehicle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class ComponentAndBeanApplication {

  public static void main(String[] args) {
    SpringApplication.run(ComponentAndBeanApplication.class, args);

    var context = new AnnotationConfigApplicationContext(ComponentAndBeanApplication.class);
    Vehicle v = context.getBean(Vehicle.class);
    System.out.println("v.getName: " + v.getName());

    Vehicle2 v2 = context.getBean(Vehicle2.class);
    System.out.println("v2.getName: " + v2.getName());

    Vehicle3 v3 = context.getBean(Vehicle3.class);
    System.out.println("v3.getName: " + v3.getName());
  }
}
