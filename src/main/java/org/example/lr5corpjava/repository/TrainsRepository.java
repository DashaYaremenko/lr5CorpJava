package org.example.lr5corpjava.repository;

import org.example.lr5corpjava.data.Trains;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TrainsRepository extends JpaRepository<Trains, Integer> {
    Optional<Trains> findById(int id);
}
