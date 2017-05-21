package com.fatosmorina.explorecalifornia.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.fatosmorina.explorecalifornia.domain.TourRating;
import com.fatosmorina.explorecalifornia.domain.TourRatingPk;

@RepositoryRestResource(exported = false)
public interface TourRatingRepository extends CrudRepository<TourRating, TourRatingPk> {
    List<TourRating> findByPkTourId(Integer tourId);

    TourRating findByPkTourIdAndPkCustomerId(Integer tourId, Integer customerId);

    Page<TourRating> findByPkTourId(Integer tourId, Pageable pageable);
}