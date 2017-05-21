package com.fatosmorina.explorecalifornia.web;

import java.util.AbstractMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fatosmorina.explorecalifornia.domain.Tour;
import com.fatosmorina.explorecalifornia.domain.TourRating;
import com.fatosmorina.explorecalifornia.domain.TourRatingPk;
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

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createTourRating(@PathVariable(value = "tourId") int tourId, @RequestBody @Validated RatingDto ratingDto) {
        Tour tour = verifyTour(tourId);
        tourRatingRepository.save(new TourRating(new TourRatingPk(tour, ratingDto.getCustomerId()), ratingDto.getScore(), ratingDto.getComment()));
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<RatingDto> getAllRatingsForTour(@PathVariable(value = "tourId") int tourId) {
        verifyTour(tourId);
        return tourRatingRepository.findByPkTourId(tourId)
            .stream()
            .map(tourRating -> toDto(tourRating))
            .collect(Collectors.toList());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/average")
    public AbstractMap.SimpleEntry<String, Double> getAverage(@PathVariable(value = "tourId") int tourId) {
        verifyTour(tourId);
        List<TourRating> tourRatings = tourRatingRepository.findByPkTourId(tourId);
        OptionalDouble average = tourRatings.stream()
            .mapToInt(TourRating::getScore)
            .average();
        return new AbstractMap.SimpleEntry<String, Double>("average", average.isPresent() ? average.getAsDouble() : null);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public RatingDto updateTourWithPatch(@PathVariable(value = "tourId") int tourId, @RequestBody @Validated RatingDto ratingDto) {
        TourRating tourRating = verifyTourRating(tourId, ratingDto.getCustomerId());
        tourRating.setScore(ratingDto.getScore());
        tourRating.setComment(ratingDto.getComment());
        return toDto(tourRatingRepository.save(tourRating));
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public String return400(NoSuchElementException exception) {
        return exception.getMessage();
    }

    private TourRating verifyTourRating(int tourId, int customerId) {
        TourRating tourRating = tourRatingRepository.findByPkTourIdAndPkCustomerId(tourId, customerId);
        if (tourRating == null) {
            throw new NoSuchElementException("TourRating pair for request(" + tourId + " for customer " + customerId);
        }
        return tourRating;
    }

    private RatingDto toDto(TourRating tourRating) {
        return new RatingDto(tourRating.getScore(), tourRating.getComment(), tourRating.getPk()
            .getCustomerId());
    }

    private Tour verifyTour(int tourId) {
        Tour tour = tourRepository.findOne(tourId);
        if (tour == null) {
            throw new NoSuchElementException("Tour with ID: " + tourId);
        }
        return tour;
    }
}
