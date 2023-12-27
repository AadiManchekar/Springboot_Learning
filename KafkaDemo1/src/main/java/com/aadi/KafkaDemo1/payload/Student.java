package com.aadi.KafkaDemo1.payload;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Student {
    private int id;
    private String firstName;
    private String lastName;
}
