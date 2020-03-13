package com.psl.sprinboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psl.sprinboot.dao.EmployeeRepository;
import com.psl.sprinboot.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	//@Service annotation is used with classes that provide some business functionalities
	//Spring context will autodetect these classes when annotation-based configuration and classpath scanning is used.
	//This is used so that we can get its instance from the context.(Refer google)
	

	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	//@Transactional : commented since JPARepository provides this functionality
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	//@Transactional
	public Employee findById(int theId) {
		//Optional is introduced in Java 8. It is used to resolve null pointer exception. (Refer google)
		Optional<Employee> result = employeeRepository.findById(theId);
		 Employee employee = null;
		   if(result.isPresent()) {
			   employee=result.get();
		   }
		   else {
			   throw new RuntimeException("Did not find the employee with id - " + theId);
		   }
		return employee;
	}

	@Override
	//@Transactional
	public void save(Employee theEmployee) {
		employeeRepository.save(theEmployee);

	}

	@Override
	//@Transactional
	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);
	}

}
