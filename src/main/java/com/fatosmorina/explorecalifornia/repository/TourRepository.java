package com.fatosmorina.explorecalifornia.repository;

import org.springframework.data.repository.CrudRepository;

import com.fatosmorina.explorecalifornia.domain.Tour;

public interface TourRepository extends CrudRepository<Tour, Integer> {
    
}
