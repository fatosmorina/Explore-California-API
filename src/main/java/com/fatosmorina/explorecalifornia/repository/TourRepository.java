package com.fatosmorina.explorecalifornia.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import com.fatosmorina.explorecalifornia.domain.Tour;

public interface TourRepository extends PagingAndSortingRepository<Tour, Integer> {
    List<Tour> findByTourPackageCode(@Param("code") String code, Pageable pageable);

    @Override
    @RestResource(exported = false)
    default <S extends Tour> S save(S entity) {
        return null;
    }

    @Override
    @RestResource(exported = false)
    default <S extends Tour> Iterable<S> save(Iterable<S> entities) {
        // TODO Auto-generated method stub
        return null;
    }

}
