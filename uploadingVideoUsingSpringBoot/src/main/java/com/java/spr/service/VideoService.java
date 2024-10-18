package com.java.spr.service;

import org.springframework.web.multipart.MultipartFile;

import com.java.spr.entities.Video;

public interface VideoService {
	
//	Save Video 
	Video save(Video video, MultipartFile file);

	
//	get Video By Using videoId
	Video getVideoById(String videoId);
	
//	get Video By title
	Video getVideoByTitle(String title);
	
//	Video processing 
	String videoProcessing(String videoId);
	
}
