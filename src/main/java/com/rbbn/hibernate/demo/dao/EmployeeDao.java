package com.rbbn.hibernate.demo.dao;

import com.rbbn.hibernate.demo.entities.Employee;

import java.sql.Date;
import java.util.List;

public interface EmployeeDao {

    public void createEmployee(Employee employee);

    public List<Employee> getAllEmployees();

    public List<Employee> getEmployeeById(Long id);

    public List<Employee> getEmployeeByName(String name);

    public List<Employee> getEmployeeByDepartment(String department);

    public List<Employee> getEmployeeByGender(String gender);

    public List<Employee> getEmployeeByDob(Date dob);
}
