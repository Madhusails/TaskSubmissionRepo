package com.webApplication.EmployeeManagement.EmployeeManagement.Employee;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {
    private EmployeeService employeeService;
    private EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeService employeeService,EmployeeRepository employeeRepository) {
        this.employeeRepository=employeeRepository;
        this.employeeService = employeeService;
    }

    @GetMapping("employees")
    public String AllEmployees(ModelMap model)
    {
//        List<Employee> employeeList=employeeService.GetAll();
        List<Employee> employeeList=employeeRepository.findAll();
        model.addAttribute("employeeList",employeeList);
        return "listEmployees";
    }

    @RequestMapping(value="add-employee",method=RequestMethod.GET)
    public String showNewEmployeePage()
    {

        return "addEmployee";
    }
    @RequestMapping(value="add-employee",method=RequestMethod.POST)
    public String addNewEmployee(@RequestParam String name,String designation,LocalDate dateOfBirth,double salary)
    {
        //employeeService.addEmployee(name,designation,dateOfBirth,salary);
        Employee employee = new Employee();
        employee.setName(name);
        employee.setDesignation(designation);
        employee.setDateOfBirth(dateOfBirth);
        employee.setSalary(salary);
        employeeRepository.save(employee);
        return "redirect:employees";
    }
    @RequestMapping(value="update-employee",method=RequestMethod.GET)
    public String updateEmployeePage()
    {

        return "updateEmployee";
    }
    @RequestMapping(value="update-employee",method=RequestMethod.POST)
    public String updateOldEmployee(@RequestParam int id,String name,String designation,LocalDate dateOfBirth,double salary)
    {
        //employeeService.updateEmployee(id,name,designation,dateOfBirth,salary);
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);

        if (optionalEmployee.isPresent()) {
            Employee existingEmployee = optionalEmployee.get();
            existingEmployee.setName(name);
            existingEmployee.setDesignation(designation);
            existingEmployee.setDateOfBirth(dateOfBirth);
            existingEmployee.setSalary(salary);
            employeeRepository.save(existingEmployee);

            return "redirect:/employees";
        } else {

            return "errorPage";
        }

    }

    @RequestMapping("delete-employee")
    public String deleteEmployee(@RequestParam int id)
    {
        employeeRepository.deleteById(id);
        return "redirect:employees";
    }


}
