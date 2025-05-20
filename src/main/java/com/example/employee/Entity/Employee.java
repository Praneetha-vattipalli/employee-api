package com.example.employee.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String employeeNumber;

    private String employeeName;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;


    // Getters and Setters
}
