package com.example.RatingService.service.impl;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RatingService.entities.Rating;
import com.example.RatingService.repository.RatingRepository;
import com.example.RatingService.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService {
	
	@Autowired
	private RatingRepository ratingRepository;
	
	Logger logger = LoggerFactory.getLogger(RatingServiceImpl.class);

	@Override
	public Rating createRating(Rating rating) {
		logger.info("calling the Create rating Service method :");
//		I want that the id Will be Generate By own okay \
		
		String ratingId = UUID.randomUUID().toString();
		rating.setRatingId(ratingId);
		return ratingRepository.save(rating);
	}

	@Override
	public List<Rating> getAllratings() {
		logger.info("calling the get All rating methods okay");
		return ratingRepository.findAll();
	}

	@Override
	public List<Rating> getAllRatingUsingUserId(String userId) {
		logger.info("calling the method of get All rating by User id");
		return ratingRepository.findAll();
	}

	@Override
	public List<Rating> getAllRatingUsingHotelId(String id) {
		logger.info("Calling the Method of get All rating Using Hotel id Now ");
		return ratingRepository.findAll();
	}
	
	
	

}
