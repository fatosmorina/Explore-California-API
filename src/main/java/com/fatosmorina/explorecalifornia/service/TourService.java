package com.fatosmorina.explorecalifornia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatosmorina.explorecalifornia.repository.TourPackageRepository;

@Service
public class TourService {
    @Autowired
    private TourPackageRepository tourPackageRepository;
}
