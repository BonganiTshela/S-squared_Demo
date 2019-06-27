package co.za.ssquared.cruddemo.cucumber.module.employee.core;

import co.za.ssquared.cruddemo.entity.Address;
import co.za.ssquared.cruddemo.entity.Employee;

public class WorldEmployee {

    Employee employee;
    Address address;

    public WorldEmployee() {
    }

    public WorldEmployee(Employee employee, Address address) {
        this.employee = employee;
        this.address = address;
    }


    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }





}
