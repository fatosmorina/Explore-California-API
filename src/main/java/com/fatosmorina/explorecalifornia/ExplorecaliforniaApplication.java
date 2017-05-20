package com.fatosmorina.explorecalifornia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fatosmorina.explorecalifornia.service.TourPackageService;
import com.fatosmorina.explorecalifornia.service.TourService;

@SpringBootApplication
public class ExplorecaliforniaApplication implements CommandLineRunner {

    @Autowired
    private TourPackageService tourPackageService;
    @Autowired
    private TourService tourService;

    public static void main(String[] args) {
        SpringApplication.run(ExplorecaliforniaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        tourPackageService.createTourPackage("BC", "Backack Cal");
        tourPackageService.createTourPackage("CC", "California Calm");
        tourPackageService.createTourPackage("TC", "Taste of California");
        tourPackageService.createTourPackage("SC", "Snowboard California");
        tourPackageService.lookup()
            .forEach(tourPackage -> System.out.println(tourPackage));
    }
}
