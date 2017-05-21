package com.fatosmorina.explorecalifornia.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.fatosmorina.explorecalifornia.domain.TourPackage;

public interface TourPackageRepository extends CrudRepository<TourPackage, String> {
    TourPackage findByName(@Param("name") String name);
}
