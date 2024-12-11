package org.example.lr5corpjava.repository;

import org.example.lr5corpjava.data.Cars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarsRepository extends JpaRepository<Cars, Integer> {
    Optional<Cars> findById(int id);
}
