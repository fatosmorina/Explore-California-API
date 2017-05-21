package com.fatosmorina.explorecalifornia.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import com.fatosmorina.explorecalifornia.domain.TourPackage;

public interface TourPackageRepository extends CrudRepository<TourPackage, String> {
    TourPackage findByName(@Param("name") String name);

    @Override
    @RestResource(exported = false)
    default <S extends TourPackage> S save(S entity) {
        // TODO Auto-generated method stub
        return null;
    }

}
