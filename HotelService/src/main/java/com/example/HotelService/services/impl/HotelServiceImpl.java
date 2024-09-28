package com.example.HotelService.services.impl;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.HotelService.entities.Hotel;
import com.example.HotelService.exceptions.ResourceNotFoundException;
import com.example.HotelService.repositories.HotelRepository;
import com.example.HotelService.services.HotelService;


@Service
public class HotelServiceImpl implements HotelService{
	
	@Autowired
	private HotelRepository hotelRepository;
	
	private Logger logger = LoggerFactory.getLogger(HotelServiceImpl.class);

	@Override
	public Hotel createHotel(Hotel hotel) {
		logger.info("Calling the Create Hotel Method okay ");
//		While Creating the New Hotel i want that HotelId Will be Created By Own Okay 
		String hotelId = UUID.randomUUID().toString();	
		hotel.setId(hotelId);
		return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotels() {
		logger.info("calling the get All Hotels okay :");
		return hotelRepository.findAll();
	}

	@Override
	public Hotel getHotel(String id) {
		logger.debug("calling the getHotel methods okay :");
		return hotelRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Hotel Id is not found Okay"));
	}

	@Override
	public void deleteHotelData(String hotelId) {
		logger.debug("calling the Delete Hotel method :");
		logger.debug("The Hotel id is :"+hotelId);
		hotelRepository.deleteById(hotelId);
	}
	
	

}
