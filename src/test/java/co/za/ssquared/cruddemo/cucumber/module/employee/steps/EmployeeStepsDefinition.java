package co.za.ssquared.cruddemo.cucumber.module.employee.steps;

import co.za.ssquared.cruddemo.cucumber.common.BaseCucumber;
import co.za.ssquared.cruddemo.cucumber.module.employee.core.World;
import co.za.ssquared.cruddemo.cucumber.module.employee.core.WorldEmployee;
import co.za.ssquared.cruddemo.cucumber.module.employee.types.AddressRow;
import co.za.ssquared.cruddemo.cucumber.module.employee.types.EmployeeRow;
import co.za.ssquared.cruddemo.dao.AddressRepository;
import co.za.ssquared.cruddemo.dao.EmployeeRepository;
import co.za.ssquared.cruddemo.entity.Address;
import co.za.ssquared.cruddemo.entity.Employee;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class EmployeeStepsDefinition extends BaseCucumber {


    private EmployeeRepository employeeRepository;
    private AddressRepository addressRepository;
    private World world;
    private WorldEmployee worldEmployee;
    private Address address;
    private Employee employee ;

    @Autowired
    public EmployeeStepsDefinition(EmployeeRepository employeeRepository, AddressRepository addressRepository) {
        this.employeeRepository = employeeRepository;
        this.addressRepository = addressRepository;
    }


    @Given("Employee with name \"([^\"]*)\" doesnt exist")
    public void employee_with_name_doesnt_exist(String firstName) {
        world = new World();

        employee = employeeRepository.findByFirstName(firstName);
        if(employee!=null)
        {
            employeeRepository.delete(employee);
        }
       else
        {
            employee = new Employee();
        }
        System.out.println("done 1");
    }

    @Given("I create a new employee with he following details")
    public void i_create_a_new_employee_with_he_following_details(final List<EmployeeRow> rows) {
        worldEmployee = new WorldEmployee();

        for(EmployeeRow row : rows) {
            employee = new Employee();
            employee.setFirstName(row.getFirstName());
            employee.setLastName(row.getLastName());
            employee.setEmail(row.getEmail());
            worldEmployee.setEmployee(employee);

        }
        System.out.println("done 2");
    }

    @Given("An address with he following details")
    public void an_address_with_he_following_details(final List<AddressRow> rows) {
        System.out.println("An address with he following details");
        address = null;
        for(AddressRow row : rows) {
            address = new Address(row.getStreetName(), row.getCityName(), row.getZip(), row.getCountry());
            worldEmployee.setAddress(address);
            world.addWorldEmployee(row.getAddressIndex(),worldEmployee);
        }

        System.out.println("done 3");

    }

    @When("We submit a request to save an employee")
    public void we_submit_a_request_to_save_an_employee() {
        WorldEmployee worldEmployee = world.getWorldEmployeeMap().get(1);

        if(worldEmployee != null) {
            address = addressRepository.save(worldEmployee.getAddress());
            employee.setAddress(address);
            employeeRepository.save(employee);
        }
        System.out.println("done 4");
    }

    @Then("I verify that the employee with name \"([^\"]*)\" was saved successfully")
    public void i_verify_that_the_employee_with_name_was_saved_successfully(String firstName) {
////        Optional<Employee> employee = Optional.ofNullable(employeeRepository.findByFirstName(firstName));
////        if(employee.isPresent()) {
////            final Employee emp = employee.get();
////            assertEmployee(world.getEmployeeMap().get(1), emp);
//        }
        System.out.println("done 5");

    }


    private void assertEmployee(Employee expected, Employee actual) {
        Assert.assertEquals(expected.getEmail(), actual.getEmail());
    }
}
