package com.fatosmorina.explorecalifornia.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.fatosmorina.explorecalifornia.domain.Tour;

public interface TourRepository extends PagingAndSortingRepository<Tour, Integer> {
    List<Tour> findByTourPackageCode(@Param("code") String code, Pageable pageable);

    @Override
    default <S extends Tour> S save(S entity) {
        // TODO Auto-generated method stub
        return null;
    }

}
