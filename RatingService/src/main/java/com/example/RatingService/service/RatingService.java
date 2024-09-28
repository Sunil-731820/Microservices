package com.example.RatingService.service;

import java.util.List;

import com.example.RatingService.entities.Rating;

public interface RatingService {

	
//	Creating the rating okay 
	Rating createRating(Rating rating);
	
//	get All ratings 
	List<Rating> getAllratings();
	
//	get All Rating by using userId
	
	List<Rating> getAllRatingUsingUserId(String userId);
//	get All Rating By Using Hotel id Okay
	
	List<Rating> getAllRatingUsingHotelId(String id);
	
	
}
