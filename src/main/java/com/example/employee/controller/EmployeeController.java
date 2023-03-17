package com.example.employee.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeJpaService;

@RestController
public class EmployeeController{
    @Autowired
    public EmployeeJpaService ejs;

    @GetMapping("/employees")
    public ArrayList<Employee> getEmployees(){
        return ejs.getEmployees();
    }
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable ("employeeId") int employeeId){
        return ejs.getEmployeeById(employeeId);
    }
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        return ejs.addEmployee(employee);
    }
    @PutMapping("/employees/{employeeId}")
    public Employee updateEmployee(@PathVariable ("employeeId") int employeeId , @RequestBody Employee employee){
        return ejs.updateEmployee(employeeId , employee);
    }
    @DeleteMapping("/employees/{employeeId}")
    public void deleteEmp(@PathVariable ("employeeId") int employeeId){
        ejs.deleteEmployee(employeeId);
    }
}