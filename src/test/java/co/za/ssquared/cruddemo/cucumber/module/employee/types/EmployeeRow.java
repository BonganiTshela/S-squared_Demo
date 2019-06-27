package co.za.ssquared.cruddemo.cucumber.module.employee.types;

import co.za.ssquared.cruddemo.entity.Address;

public class EmployeeRow {
    private int employeeIndex;
    private String firstName;
    private String lastName;
    private String email;
    private Address addressIndex;

    public EmployeeRow(int employeeIndex, String firstName, String lastName, String email, Address addressIndex) {
        this.employeeIndex = employeeIndex;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.addressIndex = addressIndex;
    }

    public int getEmployeeIndex() {
        return employeeIndex;
    }

    public void setEmployeeIndex(int employeeIndex) {
        this.employeeIndex = employeeIndex;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddressIndex() {
        return addressIndex;
    }

    public void setAddressIndex(Address addressIndex) {
        this.addressIndex = addressIndex;
    }
}
