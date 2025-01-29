package com.mvcProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mvcProject.dao.EmployeeRepository;
import com.mvcProject.entities.Employee;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
        this.employeeRepository = theEmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> result = employeeRepository.findById(theId);

        if (result.isPresent()) {
            return result.get();
        } else {
            // We didn't find the employee
            throw new RuntimeException("Did not find employee id - " + theId);
        }
    }

   /* @Override
    public void save(Employee theEmployee) {
        employeeRepository.save(theEmployee);
    }*/
    
    
    @Override
    public void save(Employee theEmployee) {
        employeeRepository.save(theEmployee);  // The save method will work for both creating and updating
    }

    

    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }
}
