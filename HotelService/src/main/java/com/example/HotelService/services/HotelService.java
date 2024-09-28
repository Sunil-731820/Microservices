package com.example.HotelService.services;

import java.util.List;

import com.example.HotelService.entities.Hotel;

public interface HotelService {

//	Create hotel
	
	Hotel createHotel(Hotel hotel);
	
//	get All Hotels okay 
	
	List<Hotel> getAllHotels();
	
//	get Single Hotel 
	Hotel getHotel(String id);
	
//	Delete the hotel Data using Hotel id 
	
	void deleteHotelData(String id);
	
	
	
}
