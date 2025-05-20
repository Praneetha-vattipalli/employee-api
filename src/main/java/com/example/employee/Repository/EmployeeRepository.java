package com.example.employee.Repository;

import com.example.employee.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

        Optional<Employee> findByEmployeeNumber(String employeeNumber);

        List<Employee> findByDepartment_DepartmentNameOrderByEmployeeNumberAsc(String departmentName);

        List<Employee> findByDepartment_DepartmentNameIgnoreCaseAndEmployeeNameStartingWithIgnoreCase(
                String departmentName, String prefix);

        List<Employee> findAllByOrderByDepartment_DepartmentNameAscEmployeeNumberAsc();

        List<Employee> findByDepartment_DepartmentNameOrderByEmployeeNameAsc(String departmentName);
}
