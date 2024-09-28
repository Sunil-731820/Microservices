package com.example.RatingService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.RatingService.entities.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, String> {

	
//	Custom Query to get the Details Here Okay 
	List<Rating> findByUserId(String userId);
	List<Rating> findByhotelId(String hotelId);

}
