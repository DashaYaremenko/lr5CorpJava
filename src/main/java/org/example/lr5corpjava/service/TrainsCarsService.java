package org.example.lr5corpjava.service;

import org.example.lr5corpjava.data.Cars;
import org.example.lr5corpjava.data.Trains;
import org.example.lr5corpjava.data.TrainsCars;
import org.example.lr5corpjava.repository.CarsRepository;
import org.example.lr5corpjava.repository.TrainsCarsRepository;
import org.example.lr5corpjava.repository.TrainsRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class TrainsCarsService {
    private final TrainsCarsRepository trainsCarsRepository;
    private final CarsRepository carsRepository;
    private final TrainsRepository trainsRepository;

    public TrainsCarsService(TrainsCarsRepository trainsCarsRepository,
                             CarsRepository carsRepository,
                             TrainsRepository trainsRepository) {
    this.trainsCarsRepository = trainsCarsRepository;
    this.carsRepository = carsRepository;
    this.trainsRepository = trainsRepository;
}
public List<TrainsCars> getAllTrainsCars() {return trainsCarsRepository.findAll();}

    public void addTrainsCar(int trainsId, int carId) {
        Trains train = trainsRepository.findById(trainsId).orElseThrow(() -> new RuntimeException("Train with ID " + trainsId + " not found"));
        Cars car = carsRepository.findById(carId).orElseThrow(() -> new RuntimeException("Car with ID " + carId + " not found"));
        TrainsCars trainsCars = new TrainsCars(train, car);
        trainsCarsRepository.save(trainsCars);
    }
    public void updateTrainsCar(int id,int trainsId, int carId, LocalDate date_reception) {
        trainsCarsRepository.findById(id).ifPresent(trainsCars -> {
            trainsRepository.findById(trainsId).ifPresent(train -> {
                carsRepository.findById(carId).ifPresent(car -> {
                    trainsCars.setTrainId(train);
                    trainsCars.setCarsId(car);
                    trainsCars.setDate_reception(date_reception);
                    trainsCarsRepository.save(trainsCars);
                });
            });
        });
    }
    public void deleteTrainsCar(int id) {
        trainsCarsRepository.deleteById(id);
    }

}
