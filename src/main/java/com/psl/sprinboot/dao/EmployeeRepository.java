package com.psl.sprinboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.psl.sprinboot.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
  //that's it .. no need to  write any code like we did in DAO and DAO Implementation classes.
}
