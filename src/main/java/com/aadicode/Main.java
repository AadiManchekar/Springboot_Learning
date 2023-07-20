package com.aadicode;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// annotations
@SpringBootApplication
@RestController
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @GetMapping("/greet")
    public GreetResponse greet() {
        GreetResponse response = new GreetResponse("Hello", List.of("JAVA", "GO", "C++"), new Person("Aadi",28,30_000));

        return response;
    }

    record Person(String name, int age, double savings) {
    }

    record GreetResponse(String response, List<String> favProgrammingLanguages, Person Person) {
    }
}
