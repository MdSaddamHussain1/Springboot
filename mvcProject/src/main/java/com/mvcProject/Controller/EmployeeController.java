package com.mvcProject.Controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.mvcProject.entities.Employee;
import com.mvcProject.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    // Constructor injection for EmployeeService
    public EmployeeController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    // Method to list all employees
    @GetMapping("/list")
    public String listEmployees(Model theModel) {
        List<Employee> theEmployees = employeeService.findAll();
        theModel.addAttribute("employees", theEmployees);
        return "employees/list-employees";
    }

    // Method to show the form to add a new employee
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        Employee theEmployee = new Employee();
        theModel.addAttribute("employee", theEmployee);
        return "employees/employee-form";
    }

    // Method to show the form to update an existing employee
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel) {
        Employee theEmployee = employeeService.findById(theId);
        theModel.addAttribute("employee", theEmployee);
        return "employees/employee-form";
    }

    // Method to save or update employee
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
        employeeService.save(theEmployee);  // This method will handle both save and update
        return "redirect:/employees/list";  // Redirect after save/update
    }

    // Method to delete employee
    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId") int theId) {
        employeeService.deleteById(theId);
        return "redirect:/employees/list";  // Redirect back to list
    }
    
    /*@GetMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId") int theId) {
        // Delete the employee from the database
        employeeService.deleteById(theId);
        // Redirect back to the employee list
        return "redirect:/employees/list";
    }*/
}
