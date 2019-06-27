package co.za.ssquared.cruddemo.cucumber.module.employee.steps;

import co.za.ssquared.cruddemo.cucumber.common.BaseCucumber;
import co.za.ssquared.cruddemo.cucumber.module.employee.core.World;
import co.za.ssquared.cruddemo.cucumber.module.employee.types.AddressRow;
import co.za.ssquared.cruddemo.cucumber.module.employee.types.EmployeeRow;
import co.za.ssquared.cruddemo.dao.AddressRepository;
import co.za.ssquared.cruddemo.dao.EmployeeRepository;
import co.za.ssquared.cruddemo.entity.Address;
import co.za.ssquared.cruddemo.entity.Employee;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class EmployeeStepsDefination extends BaseCucumber {

    private World world;
    private EmployeeRepository employeeRepository;
    private AddressRepository addressRepository;


    @Autowired
    public EmployeeStepsDefination(EmployeeRepository employeeRepository, AddressRepository addressRepository) {
        this.employeeRepository = employeeRepository;
        this.addressRepository = addressRepository;
    }

    @Given("Employee with name \"([^\"]*)\" doesnt exist")
    public void employee_with_name_doesnt_exist(String firstName) {
        world = new World();
        Optional.ofNullable(employeeRepository.findByFirstName(firstName))
                .ifPresent(employee -> employeeRepository.deleteById(employee.getId()));
    }

    @Given("I create a new employee with he following details")
    public void i_create_a_new_employee_with_he_following_details(final List<EmployeeRow> rows) {
        for(EmployeeRow row : rows) {
            Employee employee = new Employee();
            employee.setFirstName(row.getFirstName());
            employee.setLastName(row.getLastName());
            employee.setEmail(row.getEmail());
            world.add(row.getEmployeeIndex(), employee);
        }
    }

    @Given("An address with he following details")
    public void an_address_with_he_following_details(final List<AddressRow> rows) {
        System.out.println("An address with he following details");
        Address address = null;
        for(AddressRow row : rows) {
            address = new Address(row.getStreetName(), row.getCityName(), row.getZip(), row.getCountry());
        }
    }

    @When("We submit a request to save an employee")
    public void we_submit_a_request_to_save_an_employee() {
        Employee employee = world.getEmployeeMap().get(1);
        if(employee != null) {
            Address address = addressRepository.save(employee.getAddress());
            employee.setAddress(address);
            employeeRepository.save(employee);
        }
    }

    @Then("I verify that the employee with name \"([^\"]*)\" was saved successfully")
    public void i_verify_that_the_employee_with_name_was_saved_successfully(String firstName) {
        Optional<Employee> employee = Optional.ofNullable(employeeRepository.findByFirstName(firstName));
        if(employee.isPresent()) {
            final Employee emp = employee.get();
            assertEmployee(world.getEmployeeMap().get(1), emp);
        }
    }

    private void assertEmployee(Employee expected, Employee actual) {
        Assert.assertEquals(expected.getEmail(), actual.getEmail());
    }

}
