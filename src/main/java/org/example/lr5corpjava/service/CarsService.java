package org.example.lr5corpjava.service;

import org.example.lr5corpjava.data.Cars;
import org.example.lr5corpjava.data.Trains;
import org.example.lr5corpjava.repository.CarsRepository;
import org.example.lr5corpjava.repository.TrainsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarsService {
    private CarsRepository carsRepository;

    public CarsService(CarsRepository carsRepository) {
       this.carsRepository = carsRepository;
    }
    public List<Cars> getAllCars(){return carsRepository.findAll();}
}
