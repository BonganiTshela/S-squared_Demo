package co.za.ssquared.cruddemo.service;

import co.za.ssquared.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> findAll();
    public Employee findById(int theId);
    public void save(Employee theEmployee);
    public void deletByid(int theId);
    Employee findByFirstName(String firstName);

}
