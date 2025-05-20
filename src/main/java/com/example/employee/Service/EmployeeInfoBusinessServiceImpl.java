package com.example.employee.Service;

import com.example.employee.Entity.Employee;
import com.example.employee.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeInfoBusinessServiceImpl implements EmployeeInfoBusinessService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findEmployeesByDepartmentSortedByEmpNo(String departmentName) {
        return employeeRepository.findByDepartment_DepartmentNameOrderByEmployeeNumberAsc(departmentName);
    }

    @Override
    public List<Employee> findEmployeesByDepartmentStartingWithA(String departmentName, String a) {
        return employeeRepository.findByDepartment_DepartmentNameIgnoreCaseAndEmployeeNameStartingWithIgnoreCase(departmentName, "A");
    }

    @Override
    public List<Employee> findAllEmployeesSortedByDeptAndEmpNo(String departmentName) {
        return employeeRepository.findAllByOrderByDepartment_DepartmentNameAscEmployeeNumberAsc();
    }

    @Override
    public List<Employee> findEmployeesByDepartmentSortedByEmpName(String departmentName) {
        return employeeRepository.findByDepartment_DepartmentNameOrderByEmployeeNameAsc(departmentName);
    }

    @Override
    public String getDepartmentNameByEmployeeNumber(String employeeNumber) {
        return employeeRepository.findByEmployeeNumber(employeeNumber)
                .map(emp -> emp.getDepartment().getDepartmentName())
                .orElseThrow(() -> new RuntimeException("Employee not found with empNo: " + employeeNumber));
    }
}
