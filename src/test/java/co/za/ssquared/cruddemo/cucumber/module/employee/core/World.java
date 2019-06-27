package co.za.ssquared.cruddemo.cucumber.module.employee.core;

import co.za.ssquared.cruddemo.entity.Employee;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class World {
    Map<Integer, Employee> employeeMap = new HashMap<>();

    public void add(Integer employeeIndex, Employee employee) {
        employeeMap.putIfAbsent(employeeIndex, employee);
    }

    public Map<Integer, Employee> getEmployeeMap() {
        return Collections.unmodifiableMap(employeeMap);
    }
}
