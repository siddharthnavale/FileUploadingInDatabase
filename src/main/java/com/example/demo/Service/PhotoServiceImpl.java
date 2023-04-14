package com.example.demo.Service;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.example.demo.Entity.Photo;
import com.example.demo.ExceptionHandler.DuringStoringPhotosException;
import com.example.demo.ExceptionHandler.PhotoNotFoundException;
import com.example.demo.Repository.PhotoRepository;

@Service
public class PhotoServiceImpl implements PhotoService {

	@Autowired
	private PhotoRepository photoRepository;

	@Override
	public Photo storePhoto(MultipartFile photo) {

		try {
			
			Photo p = new Photo(photo.getOriginalFilename(), photo.getContentType(), photo.getBytes());
			return photoRepository.save(p);
			
		} catch (IOException ex) {

			throw new DuringStoringPhotosException("File not Stored.. Please try again......", ex);
		}

	}

	@Override
	public Photo getPhoto(String id) {
		
		return photoRepository.findById(id).
				orElseThrow(()->new PhotoNotFoundException("Photo not found by id " + id));
	}
	
	

}
