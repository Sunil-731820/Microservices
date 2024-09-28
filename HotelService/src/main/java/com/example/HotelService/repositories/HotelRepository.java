package com.example.HotelService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.HotelService.entities.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, String> {

}
