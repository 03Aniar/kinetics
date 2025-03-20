package com.example.kineticstestproblemsolver.repositories;

import com.example.kineticstestproblemsolver.models.Competition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public interface CompetitionRepository extends JpaRepository<Competition, Long> {
    // Find competitions by type
    List<Competition> findByType(String type);

    // Find competitions by exact date
    List<Competition> findByDate(Date date);

    // Find competitions after a specific date
    List<Competition> findByDateAfter(Date date);

    // Find competitions before a specific date
    List<Competition> findByDateBefore(Date date);

    // Find competitions between two dates
    List<Competition> findByDateBetween(Date startDate, Date endDate);

    // Find competitions by location
    List<Competition> findByLocation(String location);

    // Find competitions by location containing a substring (case-insensitive)
    List<Competition> findByLocationContainingIgnoreCase(String locationSubstring);

    // Find competitions after a specific time
    List<Competition> findByTimeAfter(Time time);

    // Find upcoming competitions (future date)
    @Query("SELECT c FROM Competition c WHERE c.date >= CURRENT_DATE ORDER BY c.date ASC")
    List<Competition> findUpcomingCompetitions();

}