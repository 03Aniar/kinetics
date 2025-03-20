package com.example.kineticstestproblemsolver.repositories;

import com.example.kineticstestproblemsolver.models.Training;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public interface TrainingRepository extends JpaRepository<Training, Long> {
    // Find trainings by type
    List<Training> findByType(String type);

    // Find trainings by date and time
    List<Training> findByDateTime(Date dateTime);

    // Find trainings by start time
    List<Training> findByStartTime(Time startTime);

    // Find trainings by location
    List<Training> findByLocation(String location);
}
