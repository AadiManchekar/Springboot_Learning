package com.aadi.NoUniqueBeanError;

import com.aadi.NoUniqueBeanError.POJOs.Vehicle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class NoUniqueBeanErrorApplication {

  public static void main(String[] args) {
    SpringApplication.run(NoUniqueBeanErrorApplication.class, args);

    var context = new AnnotationConfigApplicationContext(NoUniqueBeanErrorApplication.class);
    // Vehicle veh = context.getBean(Vehicle.class);
    // System.out.println(veh.getName());
    // running this we get
    // Exception in thread "main" org.springframework.beans.factory.NoUniqueBeanDefinitionException:
    // No qualifying bean of type 'com.aadi.NoUniqueBeanError.POJOs.Vehicle' available: expected
    // single matching bean but found 3: vehicle1,vehicle2,vehicle3
    //     at
    // org.springframework.beans.factory.support.DefaultListableBeanFactory.resolveNamedBean(DefaultListableBeanFactory.java:1312)
    //     at
    // org.springframework.beans.factory.support.DefaultListableBeanFactory.resolveBean(DefaultListableBeanFactory.java:486)
    //     at
    // org.springframework.beans.factory.support.DefaultListableBeanFactory.getBean(DefaultListableBeanFactory.java:341)
    //     at
    // org.springframework.beans.factory.support.DefaultListableBeanFactory.getBean(DefaultListableBeanFactory.java:334)
    //     at
    // org.springframework.context.support.AbstractApplicationContext.getBean(AbstractApplicationContext.java:1252)
    //     at
    // com.aadi.NoUniqueBeanError.NoUniqueBeanErrorApplication.main(NoUniqueBeanErrorApplication.java:15)

    Vehicle veh = context.getBean("vehicle1", Vehicle.class);
    System.out.println(veh.getName());

	Vehicle veh1 = context.getBean("F1Car", Vehicle.class);
    System.out.println(veh1.getName());
  }
}
