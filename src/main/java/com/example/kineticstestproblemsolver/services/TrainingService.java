package com.example.kineticstestproblemsolver.services;

import com.example.kineticstestproblemsolver.models.Training;
import com.example.kineticstestproblemsolver.repositories.TrainingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TrainingService {

    private final TrainingRepository trainingRepository;

    public List<Training> getAllTrainings() {
        return trainingRepository.findAll();
    }

    public Optional<Training> getTrainingById(Long id) {
        return trainingRepository.findById(id);
    }

    public List<Training> getTrainingsByType(String type) {
        return trainingRepository.findByType(type);
    }

    public List<Training> getTrainingsByDateTime(Date dateTime) {
        return trainingRepository.findByDateTime(dateTime);
    }

    public List<Training> getTrainingsByStartTime(Time startTime) {
        return trainingRepository.findByStartTime(startTime);
    }

    public List<Training> getTrainingsByLocation(String location) {
        return trainingRepository.findByLocation(location);
    }

    public Training saveOrUpdateTraining(Training training) {
        return trainingRepository.save(training);
    }

    public void deleteTraining(Long id) {
        trainingRepository.deleteById(id);
    }
}