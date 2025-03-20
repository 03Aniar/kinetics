package com.example.kineticstestproblemsolver.services;

import com.example.kineticstestproblemsolver.models.Competition;
import com.example.kineticstestproblemsolver.repositories.CompetitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CompetitionService {

    private final CompetitionRepository competitionRepository;

    @Autowired
    public CompetitionService(CompetitionRepository competitionRepository) {
        this.competitionRepository = competitionRepository;
    }

    // Create a new competition
    public Competition createCompetition(Competition competition) {
        return competitionRepository.save(competition);
    }

    // Get competition by ID
    public Optional<Competition> getCompetitionById(Integer id) {
        return competitionRepository.findById(id);
    }

    // Get all competitions
    public List<Competition> getAllCompetitions() {
        return competitionRepository.findAll();
    }

    // Update a competition
    public Competition updateCompetition(Competition competition) {
        return competitionRepository.save(competition);
    }

    // Delete a competition
    public void deleteCompetition(Integer id) {
        competitionRepository.deleteById(id);
    }

    // Get competitions by type
    public List<Competition> getCompetitionsByType(String type) {
        return competitionRepository.findByType(type);
    }

    // Get competitions by exact date
    public List<Competition> getCompetitionsByDate(Date date) {
        return competitionRepository.findByDate(date);
    }

    // Get competitions after a specific date
    public List<Competition> getCompetitionsAfterDate(Date date) {
        return competitionRepository.findByDateAfter(date);
    }

    // Get competitions before a specific date
    public List<Competition> getCompetitionsBeforeDate(Date date) {
        return competitionRepository.findByDateBefore(date);
    }

    // Get competitions between two dates
    public List<Competition> getCompetitionsBetweenDates(Date startDate, Date endDate) {
        return competitionRepository.findByDateBetween(startDate, endDate);
    }

    // Get competitions by location
    public List<Competition> getCompetitionsByLocation(String location) {
        return competitionRepository.findByLocation(location);
    }

    // Get competitions by location substring (case-insensitive)
    public List<Competition> searchCompetitionsByLocation(String locationSubstring) {
        return competitionRepository.findByLocationContainingIgnoreCase(locationSubstring);
    }

    // Get competitions after a specific time
    public List<Competition> getCompetitionsAfterTime(Time time) {
        return competitionRepository.findByTimeAfter(time);
    }

    // Get upcoming competitions
    public List<Competition> getUpcomingCompetitions() {
        return competitionRepository.findUpcomingCompetitions();
    }
}