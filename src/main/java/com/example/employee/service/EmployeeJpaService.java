package com.example.employee.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;
import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.repository.EmployeeJpaRepository;


@Service
public class EmployeeJpaService implements EmployeeRepository{
    @Autowired
    private EmployeeJpaRepository ejp;
    @Override
    public ArrayList<Employee> getEmployees(){
        List<Employee> emp = ejp.findAll();
        ArrayList<Employee> emps = new ArrayList<>(emp);
        return emps;
    }
    @Override
    public Employee getEmployeeById(int employeeId){
        try{
            Employee em = ejp.findById(employeeId).get();
            return em;
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } 
    }
    @Override
    public Employee addEmployee(Employee employee){
        ejp.save(employee);
        return employee;
    }
    @Override
    public Employee updateEmployee(int employeeId , Employee employee){
        try{
            Employee emp = ejp.findById(employeeId).get();
            if(employee.getEmployeeName() != null){
                emp.setEmployeeName(employee.getEmployeeName());
            }
            if(employee.getEmail()!= null){
                emp.setEmail(employee.getEmail());
            }
            if(employee.getDepartment() != null){
                emp.setDepartment(employee.getDepartment());
            }
            ejp.save(emp);
            return emp;
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    @Override
    public void deleteEmployee(int employeeId){
        try{
            ejp.deleteById(employeeId);
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}