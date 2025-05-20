package com.example.employee.Service;

import com.example.employee.Entity.Employee;

import java.util.List;

public interface EmployeeInfoBusinessService {

    List<Employee> findEmployeesByDepartmentSortedByEmpNo(String departmentName);

    List<Employee> findEmployeesByDepartmentStartingWithA(String departmentName, String a);

    List<Employee> findAllEmployeesSortedByDeptAndEmpNo(String departmentName);

    List<Employee> findEmployeesByDepartmentSortedByEmpName(String departmentName);

    String getDepartmentNameByEmployeeNumber(String employeeNumber);
}
