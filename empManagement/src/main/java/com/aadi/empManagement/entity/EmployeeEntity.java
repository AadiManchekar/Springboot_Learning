package com.aadi.empManagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_employee")
public class EmployeeEntity {

  @Id
  private String employeeId;

  private String firstName;
  private String lastName;
  private String emailId;
  private String department;
}
