package com.mvcProject.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mvcProject.entities.Employee;



public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
	 public List<Employee> findAllByOrderByLastNameAsc();

}
