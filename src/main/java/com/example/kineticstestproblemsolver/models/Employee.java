package com.example.kineticstestproblemsolver.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee_table")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "employee_id")
    private Long id;

    @NotBlank(message = "Full name is mandatory")
    private String fullName;

    private String department;

    private String position;

    @Column(unique = true)
    private String rank;

    @Column(name = "iin", unique = true)
    private String IIN;
}
