package com.java.spr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.spr.entities.Video;

@Repository
public interface VideoRepository extends JpaRepository<Video, String> {
	

	Video findVideoByTitle(String title);
}
