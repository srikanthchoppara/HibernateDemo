package com.rbbn.hibernate.demo.controller;

import com.rbbn.hibernate.demo.dao.EmployeeDao;
import com.rbbn.hibernate.demo.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value= "/employee")
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @PostMapping(path = "/insert", consumes = "application/json")
    public void insertEmployeeToDB(@RequestBody Employee employee) {
        employeeDao.createEmployee(employee);
    }

    @RequestMapping(value= "/all")
    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }

    @GetMapping(value= "/get/{id}")
    public List<Employee> getEmployeeById(@PathVariable(name="id") Long id) {
        return employeeDao.getEmployeeById(id);
    }

    @GetMapping(value= "/get/{name}")
    public List<Employee> getEmployeeByName(@PathVariable(name="name") String name) {
        return employeeDao.getEmployeeByName(name);
    }

    @GetMapping(value= "/get/{department}")
    public List<Employee> getEmployeeByDepartment(@PathVariable(name="department") String department) {
        return employeeDao.getEmployeeByDepartment(department);
    }

    @GetMapping(value= "/get/{gender}")
    public List<Employee> getEmployeeByGender(@PathVariable(name="gender") String gender) {
        return employeeDao.getEmployeeByGender(gender);
    }

    @GetMapping(value= "/get/{dob}")
    public List<Employee> getEmployeeByDob(@PathVariable(name="dob") Date dob) {
        return employeeDao.getEmployeeByDob(dob);
    }
}
