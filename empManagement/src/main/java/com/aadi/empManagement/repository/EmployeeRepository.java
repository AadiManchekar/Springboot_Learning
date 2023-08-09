package com.aadi.empManagement.repository;

import com.aadi.empManagement.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository
  extends JpaRepository<EmployeeEntity, String> {}
