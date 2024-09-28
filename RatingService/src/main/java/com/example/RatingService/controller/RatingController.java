package com.example.RatingService.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.RatingService.entities.Rating;
import com.example.RatingService.service.RatingService;

@RestController
@RequestMapping("/rating")
public class RatingController {

	
	@Autowired
	private RatingService service;
	private Logger logger = LoggerFactory.getLogger(RatingController.class);
	
//	Creating the New rating Okay 
	@PostMapping
	public ResponseEntity<Rating> createRating(Rating rating){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.createRating(rating));
	}
	
//	get All ratings from The Database okay 
	@GetMapping
	public ResponseEntity<List<Rating>> getAllRating(){
		return ResponseEntity.ok(service.getAllratings());
	}
	
//	get All the rating using userId from the User MicroServices okay 
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<List<Rating>> getratingUserId(@PathVariable String userId){
		logger.info("calling the getratingbyUser id method called : =");
		return ResponseEntity.ok(service.getAllRatingUsingUserId(userId));
	}
	
//	get All the rating using hotelId from the Hotel microServices okay

	@GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable String hotelId) {
		logger.info("calling the getRatingByHotelId method called :=");
        return ResponseEntity.ok(service.getAllRatingUsingHotelId(hotelId));
    }

}
