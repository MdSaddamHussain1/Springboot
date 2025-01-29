
package com.mvcProject.service;

import java.util.List;
import com.mvcProject.entities.Employee;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int theId);

    void save(Employee theEmployee);

    void deleteById(int theId);
}
