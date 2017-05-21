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
    <S extends Tour> S save(S entity);

    @Override
    @RestResource(exported = false)
    default <S extends Tour> Iterable<S> save(Iterable<S> entities) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @RestResource(exported = false)
    default void delete(Integer id) {
        // TODO Auto-generated method stub

    }

    @Override
    @RestResource(exported = false)
    default void delete(Tour entity) {
        // TODO Auto-generated method stub

    }

    @Override
    @RestResource(exported = false)
    default void delete(Iterable<? extends Tour> entities) {
        // TODO Auto-generated method stub

    }

    @Override
    @RestResource(exported = false)
    default void deleteAll() {
        // TODO Auto-generated method stub

    }

}
