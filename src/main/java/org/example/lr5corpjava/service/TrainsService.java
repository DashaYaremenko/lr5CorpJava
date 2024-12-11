package org.example.lr5corpjava.service;

import org.example.lr5corpjava.data.Trains;
import org.example.lr5corpjava.repository.TrainsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainsService {
    private TrainsRepository trainRepository;

    public TrainsService(TrainsRepository trainRepository) {
        this.trainRepository = trainRepository;
    }
    public List<Trains> getAllTrains(){return trainRepository.findAll();}
}
