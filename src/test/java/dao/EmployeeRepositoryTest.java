package dao;

        import co.za.ssquared.cruddemo.CruddemoApplicationTests;
        import co.za.ssquared.cruddemo.dao.EmployeeRepository;
        import co.za.ssquared.cruddemo.entity.Employee;
        import org.junit.Test;
        import org.springframework.beans.factory.annotation.Autowired;

        import java.util.List;

        import static org.junit.Assert.assertNotNull;

public class EmployeeRepositoryTest extends CruddemoApplicationTests {

    @Autowired private EmployeeRepository employeeRepository;

    @Test
    public void testFindAll() {
        List<Employee> employees = employeeRepository.findAll();
        assertNotNull(employees);
    }
}