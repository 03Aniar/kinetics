package com.example.kineticstestproblemsolver.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Competition-Table")
public class Competition {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "competition_id_sequence")
    @SequenceGenerator(
            name = "competition_id_sequence",
            sequenceName = "competition_id_sequence",
            allocationSize = 1
    )
    @Column(name = "competition_id")
    private Long id;

    @NotBlank(message = "Type is mandatory")
    @Column(name = "type", nullable = false)
    private String type;

    @NotNull(message = "Date is mandatory")
    @Column(name = "date", nullable = false)
    private Date date;

    @NotNull(message = "Time is mandatory")
    @Column(name = "time", nullable = false)
    private Time time;

    @NotBlank(message = "Location is mandatory")
    @Column(name = "location", nullable = false)
    private String location;
}
