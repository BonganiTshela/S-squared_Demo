package co.za.ssquared.cruddemo.service;


import co.za.ssquared.cruddemo.dao.EmployeeRepository;
import co.za.ssquared.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    @Transactional
    public List<Employee> findAll() {
        return (List<Employee>) employeeRepository.findAll();
    }

    @Override
    @Transactional
    public Employee findById(int theId) {
        Optional<Employee> result = employeeRepository.findById(theId);
        Employee tempEmp = null;


        if (result.isPresent())
        {
            tempEmp = result.get();
        }
        else{
            throw new RuntimeException("Did not find employee id - " + theId);

        }
        return tempEmp;
    }

    @Override
    @Transactional
    public void save(Employee theEmployee) {
        employeeRepository.save(theEmployee);
    }

    @Override
    @Transactional
    public void deletByid(int theId) {
        employeeRepository.deleteById(theId);
    }

    @Override
    public Employee findByFirstName(String firstName) {
        return employeeRepository.findByFirstName(firstName);
    }
}
