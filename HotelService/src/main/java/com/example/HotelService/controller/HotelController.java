package com.example.HotelService.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.HotelService.entities.Hotel;
import com.example.HotelService.services.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {

	@Autowired
	private HotelService service;
	
	Logger logger = LoggerFactory.getLogger(HotelController.class);
	
//	Creating the New Hotel Data 
	 @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createHotel(hotel));
    }
    
//    getting all The Hotel Data 

	@GetMapping
	public ResponseEntity<List<Hotel>> getAllHotels(){
		List<Hotel> allHotel = service.getAllHotels();
		return ResponseEntity.ok(allHotel);
	} 
    
    
//    getting the Single Hotel Details Okay 

	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel> getSingleHotel(@PathVariable String hotelId){
		Hotel gethotelData = service.getHotel(hotelId);
		return ResponseEntity.ok(gethotelData);
	}
	
//	Deleting the Hotel Data using hotel Id 

	@DeleteMapping("/{hotelId}")
	public void deleteHotelDataUsingHotelId(@PathVariable String hotelId){
	logger.debug("calling the Delete method from The COntroller Bean class : ");
		service.deleteHotelData(hotelId);
	}
    
}
