package com.fatosmorina.explorecalifornia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatosmorina.explorecalifornia.domain.Difficulty;
import com.fatosmorina.explorecalifornia.domain.Region;
import com.fatosmorina.explorecalifornia.domain.Tour;
import com.fatosmorina.explorecalifornia.domain.TourPackage;
import com.fatosmorina.explorecalifornia.repository.TourPackageRepository;
import com.fatosmorina.explorecalifornia.repository.TourRepository;

@Service
public class TourService {
    @Autowired
    private TourPackageRepository tourPackageRepository;
    @Autowired
    private TourRepository tourRepository;

    public Tour createTour(String title, String description, String blurb, Integer price, String duration, String bullets, String keywords, String tourPackageCode, Difficulty difficulty, Region region) {
        TourPackage tourPackage = tourPackageRepository.findOne(tourPackageCode);
        if (tourPackage == null) {
            throw new RuntimeException("Tour package does not exist: " + tourPackageCode);
        }
        return tourRepository.save(new Tour(title, description, blurb, price, duration, bullets, keywords, tourPackage, difficulty, region));
    }

    public Iterable<Tour> lookup() {
        return tourRepository.findAll();
    }
}
