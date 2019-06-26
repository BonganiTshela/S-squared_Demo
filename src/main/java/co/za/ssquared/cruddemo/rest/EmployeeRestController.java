package co.za.ssquared.cruddemo.rest;

import co.za.ssquared.cruddemo.entity.Employee;
import co.za.ssquared.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    //quick and dirty : inject employee dao
    @Autowired
    public EmployeeRestController(EmployeeService theImp){
        this.employeeService = theImp;
    }

    //expose "/employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee theEmployee = employeeService.findById(employeeId);

        if (theEmployee == null){
            throw new RuntimeException("Employee Id not found");
        }

        return theEmployee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        theEmployee.setId(0);
        employeeService.save(theEmployee);
        return theEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        employeeService.save(theEmployee);
        return theEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee tempemp = employeeService.findById(employeeId);

        if(tempemp == null){
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        employeeService.deletByid(employeeId);

        return "deleted employee id - " + employeeId;
    }
}
