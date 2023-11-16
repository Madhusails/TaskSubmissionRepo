package com.webApplication.EmployeeManagement.EmployeeManagement.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class EmployeeService {

    private static List<Employee> employeeList=new ArrayList<>();
    private static int idCount=0;
    static
    {
        employeeList.add(new Employee(++idCount,"John","Developer", LocalDate.of(2000,3,2),40000));
        employeeList.add(new Employee(++idCount,"Jack","Tester", LocalDate.of(2000,5,25),30000));
        employeeList.add(new Employee(++idCount,"Mary","QA", LocalDate.of(2000,4,2),20000));
        employeeList.add(new Employee(++idCount,"Nemo","Developer", LocalDate.of(2000,3,23),40000));
        employeeList.add(new Employee(++idCount,"Dora","Tester", LocalDate.of(2000,6,22),10000));
    }

    public List<Employee> GetAll() {
        return employeeList;
    }

    public void addEmployee(String name,String designation,LocalDate dateOfBirth,double salary)
    {
        Employee emp=new Employee(++idCount,name,designation,dateOfBirth,salary);
        employeeList.add(emp);
    }

    public void deleteById(int id) {
        Predicate<? super Employee> predicate=x->x.getId()==id;
        Employee emp=employeeList.stream().filter(predicate).findFirst().orElse(null);
        employeeList.remove(emp);
    }
    public Employee getEmployeeById(int id) {
        Predicate<? super Employee> predicate=x->x.getId()==id;
        return employeeList.stream().filter(predicate).findFirst().orElse(null);
    }

    // Update an employee
    public void updateEmployee(int id, String name, String designation, LocalDate dateOfBirth, double salary) {
        Predicate<? super Employee> predicate=x->x.getId()==id;
        Employee existingEmployee = employeeList.stream().filter(predicate).findFirst().orElse(null);
        if (existingEmployee != null) {
            existingEmployee.setName(name);
            existingEmployee.setDesignation(designation);
            existingEmployee.setDateOfBirth(dateOfBirth);
            existingEmployee.setSalary(salary);
            int index = employeeList.indexOf(existingEmployee);
            if (index >= 0) {
                employeeList.set(index, existingEmployee);
            }
        }
    }
}
