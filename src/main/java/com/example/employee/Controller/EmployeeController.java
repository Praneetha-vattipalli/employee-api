package com.example.employee.Controller;

import com.example.employee.Entity.Employee;
import com.example.employee.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeInfoBusinessService employeeService;

    @GetMapping("/department/{name}")
    public List<Employee> getEmployeesByDepartment(@PathVariable String departmentName) {
        return employeeService.findAllEmployeesSortedByDeptAndEmpNo(departmentName);

    }

    @GetMapping("/department/{name}/starts-with-a")
    public List<Employee> getEmployeesByDepartmentStartingWithA(@PathVariable String departmentName) {
        return employeeService.findEmployeesByDepartmentStartingWithA(departmentName,"A");

    }

    @GetMapping("/all")
    public List<Employee> getAllEmployeesSorted(String departmentName) {
        return employeeService.findEmployeesByDepartmentSortedByEmpNo(departmentName);

    }

    // a) Retrieve all employees for a given department name, sorted by employee name
    @GetMapping("/by-department")
    public ResponseEntity<List<Employee>> getEmployeesByDepartmentNameSortedByName(
            @RequestParam String departmentName) {
        List<Employee> employees = employeeService.findEmployeesByDepartmentSortedByEmpName(departmentName);

        return ResponseEntity.ok(employees);
    }
    @PostMapping("/department/by-empno")
    public ResponseEntity<String> getDepartmentByEmpNo(@RequestBody Map<String, String> request) {
        String employeeNumber = request.get("employeeNumber");
        String deptName = employeeService.getDepartmentNameByEmployeeNumber(employeeNumber);
        return ResponseEntity.ok(deptName);
    }


}
