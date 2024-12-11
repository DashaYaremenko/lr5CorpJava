package org.example.lr5corpjava.repository;

import org.example.lr5corpjava.data.TrainsCars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainsCarsRepository extends JpaRepository<TrainsCars, Integer> {
}
