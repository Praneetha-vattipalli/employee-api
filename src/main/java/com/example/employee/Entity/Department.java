package com.example.employee.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String departmentName;

    @OneToMany(mappedBy = "department")
    private List<Employee> employees;



    // Getters and Setters
}
