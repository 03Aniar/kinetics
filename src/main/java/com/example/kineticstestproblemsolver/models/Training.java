package com.example.kineticstestproblemsolver.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Training")
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "training_id")
    private Long id;

    @NotBlank(message = "Type is mandatory")
    @Column(name = "type", nullable = false)
    private String type;

    @NotNull(message = "Date and time are mandatory")
    @Column(name = "dateTime", nullable = false)
    private Date dateTime;

    @NotNull(message = "Start time is mandatory")
    @Column(name = "startTime", nullable = false)
    private Time startTime;

    @NotBlank(message = "Location is mandatory")
    @Column(name = "location", nullable = false)
    private String location;

}
