package co.za.ssquared.cruddemo.dao;


import co.za.ssquared.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Integer> {

    Employee findByFirstName(String firstName);

}
