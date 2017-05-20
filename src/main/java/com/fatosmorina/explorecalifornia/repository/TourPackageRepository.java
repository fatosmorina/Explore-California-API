package com.fatosmorina.explorecalifornia.repository;

import org.springframework.data.repository.CrudRepository;

import com.fatosmorina.explorecalifornia.domain.TourPackage;

public interface TourPackageRepository extends CrudRepository<TourPackage, String> {
    TourPackage findByName(String name);
}
