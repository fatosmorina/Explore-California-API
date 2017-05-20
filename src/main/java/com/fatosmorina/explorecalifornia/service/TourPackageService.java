package com.fatosmorina.explorecalifornia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatosmorina.explorecalifornia.domain.TourPackage;
import com.fatosmorina.explorecalifornia.repository.TourPackageRepository;

@Service
public class TourPackageService {

    @Autowired
    private TourPackageRepository tourPackageRepository;

    public TourPackage createTourPackage(String code, String name) {
        if (!tourPackageRepository.exists(code)) {
            tourPackageRepository.save(new TourPackage(code, name));
        }
        return null;
    }

}
