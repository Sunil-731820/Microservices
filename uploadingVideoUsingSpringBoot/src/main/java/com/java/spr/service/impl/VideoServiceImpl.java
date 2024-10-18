package com.java.spr.service.impl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.java.spr.entities.Video;
import com.java.spr.repositories.VideoRepository;
import com.java.spr.service.VideoService;

import jakarta.annotation.PostConstruct;

@Service
public class VideoServiceImpl implements VideoService {

	@Autowired
	private VideoRepository repository;
	
	Logger logger = LoggerFactory.getLogger(VideoServiceImpl.class);

	 @Value("${files.video}")
	 String DIR;
	 
	 @Value("${file.video.hsl}")
	    String HSL_DIR;
	 
	 @PostConstruct
	    public void init() {

	        File file = new File(DIR);


	        try {
	            Files.createDirectories(Paths.get(HSL_DIR));
	        } catch (IOException e) {
	            throw new RuntimeException(e);
	        }

	        if (!file.exists()) {
	            file.mkdir();
	            System.out.println("Folder Created:");
	        } else {
	            System.out.println("Folder already created");
	        }

	    }
	
	@Override
	public Video save(Video video, MultipartFile file) {
        // original file name

        try {


            String filename = file.getOriginalFilename();
            String contentType = file.getContentType();
            InputStream inputStream = file.getInputStream();


            // file path
            String cleanFileName = StringUtils.cleanPath(filename);


            //folder path : create

            String cleanFolder = StringUtils.cleanPath(DIR);


            // folder path with  filename
            Path path = Paths.get(cleanFolder, cleanFileName);

            System.out.println(contentType);
            System.out.println(path);

            // copy file to the folder
            Files.copy(inputStream, path, StandardCopyOption.REPLACE_EXISTING);


            // video meta data

            video.setContentType(contentType);
            video.setFilePath(path.toString());
            Video savedVideo = repository.save(video);
            //processing video
//            processVideo(savedVideo.getVideoId());

            //delete actual video file and database entry  if exception

            // metadata save
            return savedVideo;

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error in processing video ");
        }


    }

	@Override
	public Video getVideoById(String videoId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Video getVideoByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String videoProcessing(String videoId) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
