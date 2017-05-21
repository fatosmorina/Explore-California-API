package com.fatosmorina.explorecalifornia.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatosmorina.explorecalifornia.domain.TourRating;
import com.fatosmorina.explorecalifornia.repository.TourRatingRepository;
import com.fatosmorina.explorecalifornia.repository.TourRepository;

@RestController
@RequestMapping(path = "/tours/{tourId}/ratings")
public class TourRatingController {
    @Autowired
    TourRatingRepository tourRatingRepository;
    @Autowired
    TourRepository tourRepository;

    protected TourRatingController() {
        super();
    }

    private RatingDto toDto(TourRating tourRating) {
        return new RatingDto(tourRating.getScore(), tourRating.getComment(), tourRating.getPk()
            .getCustomerId());
    }

}
