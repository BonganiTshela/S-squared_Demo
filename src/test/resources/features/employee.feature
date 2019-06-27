Feature: EMPLOYEE
  Background:
    Given Employee with name "Bart" doesnt exist

  Scenario: 1. Create a new employee
    Given I create a new employee with he following details
      | employeeIndex | firstName | lastName | email          | addressIndex |
      | 1             | Bart      | Simpson  | Bart@gmail.com | 1            |
    And An address with he following details
      | addressIndex | streetName | cityName      | zip  | country      |
      | 1            | HumeRoad   | PortElizabeth | 6001 | South Africa |
    When We submit a request to save an employee
    Then I verify that the employee with name "Bart" was saved successfully
