package com.omnidata.app1.Services;

import com.omnidata.app1.Model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

 public  Employee createEmployee(Employee employee);

 public List<Employee> saveAllEmployees(List<Employee> employees);

 public List<Employee> getEmployees();


 public Employee getEmployeeById(int id);

 public  Optional<Employee> getEmployeeByFullName(String fullName);


public void removeEmployee(int id);

public Employee updateEmployee(int id,Employee employee);
}
